/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.utils;

import duydd.state.machine.TextUtils;
import duydd.state.machine.XmlSyntaxChecker;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 *
 * @author DELL
 */
public class XMLUtils extends Thread {

    public static String parseHTML(String prefx, String uri) {
        String result = "";
        try {
            URL url = new URL(prefx + uri);
            URLConnection yc = url.openConnection();
            yc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible: MSIE 6.0: Windows NT 5.0)");
            yc.setConnectTimeout(35000);
            yc.setReadTimeout(15000);
            InputStream is = yc.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result = result + inputLine;
            }
            result = TextUtils.refineHtml(result);
            in.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
    
    public static<S> boolean validateXml(String xsdFilePath, S obj){
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Marshaller marshaller = context.createMarshaller();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            XmlValidatorHandler handler = new XmlValidatorHandler();
            
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(handler);
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            
            marshaller.setEventHandler(handler);
            Validator validator = schema.newValidator();
            validator.validate(new JAXBSource(marshaller, obj));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
