/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duydd.crawl;

import duydd.dto.DrawlDataDTO;
import duydd.utils.XMLUtils;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author DELL
 */
public class DrawlData extends Thread{
    
    public static void getCategoriesLink(String src){
        XMLInputFactory fact = XMLInputFactory.newInstance();
        fact.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        fact.setProperty(XMLInputFactory.IS_VALIDATING, false);      
        XMLEventReader reader = null;
        List<String> listUrl = null;
        try {
            InputStream is = new ByteArrayInputStream(src.getBytes());
            reader = fact.createXMLEventReader(new InputStreamReader(is, "UTF-8"));
            boolean isInsideTag = false;
            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiGrid-root MuiGrid-container")){
                            isInsideTag = true;
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("a") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiGrid-root jss12 MuiGrid-container MuiGrid-item MuiGrid-align-items-xs-center MuiGrid-justify-xs-center")){
                          Attribute attrHref = startElement.getAttributeByName(new QName("href"));
                          if(attrHref != null){
                              if(listUrl == null){
                                  listUrl = new ArrayList<>();
                              }
                              listUrl.add(attrHref.getValue());
                          }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiBox-root jss418")){
                            isInsideTag = false;
                        }
                    }
                    
                    
                }
                

                
            }
            for(int i = 0; i < listUrl.size(); i++){
                XMLUtils utils = new XMLUtils();
                String result = utils.parseHTML("https://www.calorieking.com", listUrl.get(i));
                Thread t = new Thread(){
                    @Override
                    public void run() {
                        getDetailLink(result);
                    }
                  
                };
                t.start();
                
               
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getDetailLink(String src){
        XMLInputFactory fact = XMLInputFactory.newInstance();
        fact.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        fact.setProperty(XMLInputFactory.IS_VALIDATING, false);      
        XMLEventReader reader = null;
        List<String> listUrl = null;
        try {
            InputStream is = new ByteArrayInputStream(src.getBytes());
            reader = fact.createXMLEventReader(new InputStreamReader(is, "UTF-8"));
            boolean isInsideTag = false;
            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiGrid-root MuiGrid-item MuiGrid-grid-xs-true")){
                            isInsideTag = true;
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("a") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiButtonBase-root MuiListItem-root MuiListItem-gutters MuiListItem-button")){
                          Attribute attrHref = startElement.getAttributeByName(new QName("href"));
                          if(attrHref != null){
                              if(listUrl == null){
                                  listUrl = new ArrayList<>();
                              }
                              listUrl.add(attrHref.getValue());
                          }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("id"));
                        if(attrs != null && attrs.getValue().equals("ad-slot-CK_InScreen_1x1-5")){
                            isInsideTag = false;                           
                        }
                    }
                    
                    
                }
                

                
            }
            for(int i = 0; i < listUrl.size(); i++){
                XMLUtils utils = new XMLUtils();
                String result = utils.parseHTML("https://www.calorieking.com", listUrl.get(i));
                Thread t = new Thread(){
                    public void run() {
                        getDetail(result);
                    }
                };
               t.start();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getDetail(String src){
        XMLInputFactory fact = XMLInputFactory.newInstance();
        fact.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        fact.setProperty(XMLInputFactory.IS_VALIDATING, false);      
        XMLEventReader reader = null;
        try {
            InputStream is = new ByteArrayInputStream(src.getBytes());
            reader = fact.createXMLEventReader(new InputStreamReader(is, "UTF-8"));
            boolean isInsideTag = false;
            String brand = null;
            String title = null;
            String categories = null;
            String calories = null;
            String unit = null;
            String fat = null;
            String carbs = null;
            String fiber = null;
            String protein = null;
            String type = "Underfined";
            int count = 0;
            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("ol")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiBreadcrumbs-ol jss360")){
                            isInsideTag = true;
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("a") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiTypography-root MuiLink-root MuiLink-underlineHover MuiTypography-body2 MuiTypography-colorInherit")){
                          event = (XMLEvent) reader.next();
                          if(event.isCharacters()){
                              Characters chars = (Characters) event;
                              if(chars.getData().equals("Home")){
                                  count++;
                              }else if(chars.getData().equals("Foods")){
                                  count++;
                              }else if(count == 2){
                                  brand = chars.getData();
                                  count++;
                              }else if(count == 3){
                                  title = chars.getData();
                                  count++;
                                  
                              }
                          }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("a") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiTypography-root MuiLink-root MuiLink-underlineHover jss365 MuiTypography-body2 MuiTypography-colorInherit")){
                            event = (XMLEvent) reader.next();
                            if(event.isCharacters()){
                                Characters chars = (Characters) event;
                                categories = chars.getData();
                                isInsideTag = false;
                            }
                        }
                    }
                    
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiPaper-root MuiCard-root jss373 MuiPaper-elevation1 MuiPaper-rounded")){
                            isInsideTag = true;
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("h2") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiTypography-root MuiCardHeader-title MuiTypography-h4 MuiTypography-colorInherit MuiTypography-gutterBottom MuiTypography-displayBlock")){
                            event = (XMLEvent) reader.next();
                            if(event.isCharacters()){
                                Characters chars = (Characters) event;
                                calories = chars.getData();
                            }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiSelect-root MuiSelect-select MuiSelect-selectMenu MuiInputBase-input MuiInput-input")){
                            event = (XMLEvent) reader.next();
                            if(event.isCharacters()){
                                Characters chars = (Characters) event;
                                unit = chars.getData();
                            }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("span") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiTypography-root MuiTypography-subtitle1 MuiTypography-noWrap MuiTypography-alignCenter MuiTypography-displayBlock")){
                            event = (XMLEvent) reader.next();
                            if(event.isCharacters()){
                                Characters chars = (Characters) event;
                                type = chars.getData();
                            }
                        }
                    }
                    
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("span") && isInsideTag){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiTypography-root MuiTypography-h5 MuiTypography-noWrap MuiTypography-alignCenter MuiTypography-displayBlock")){
                          event = (XMLEvent) reader.next();
                          if(event.isCharacters()){                             
                              Characters chars = (Characters) event;
                              if(type.equals("Fat")){
                                  fat = chars.getData();
                              }else if(type.equals("Carbs")){
                                  carbs = chars.getData();
                              }else if(type.equals("Fiber")){
                                  fiber = chars.getData();
                              }else if(type.equals("Protein")){
                                  protein = chars.getData();
                              }
                          }
                        }
                        
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("MuiBox-root jss423")){
                            isInsideTag = false;
                            DrawlData drawl = new DrawlData();
                            drawl.formatDataAfterDrawl(brand, title, categories, calories, type, unit, fat, carbs, fiber, protein);
                        }
                    }
                    
                }
                

                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void getVegetableDetail(String src){
        XMLInputFactory fact = XMLInputFactory.newInstance();
        fact.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
        fact.setProperty(XMLInputFactory.IS_VALIDATING, false);      
        XMLEventReader reader = null;
        
        try {
            InputStream is = new ByteArrayInputStream(src.getBytes());
            reader = fact.createXMLEventReader(new InputStreamReader(is, "UTF-8"));
            boolean isInsideTag = false;
            String brand = "Underfined";
            String title = "Vegetable";
            String categories = null;
            String calories = null;
            String unit = "100g";
            String fat = null;
            String carbs = null;
            String fiber = null;
            String protein = null;
            String type = "Underfined";
            int count = 0;
            while(reader.hasNext()){
                XMLEvent event = reader.nextEvent();
                if(event.isStartElement()){
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("maincontent")){
                            isInsideTag = true;
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("h2") && isInsideTag){                       
                        event = (XMLEvent) reader.next();
                        if(event.isCharacters()){
                            Characters chars = (Characters) event;
                            categories = chars.getData();
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("th") && isInsideTag){                       
                        event = (XMLEvent) reader.next();
                        if(event.isCharacters()){
                            count++;                            
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("td") && isInsideTag){                       
                        event = (XMLEvent) reader.next();
                        if(event.isCharacters()){
                            Characters chars = (Characters) event;
                            switch (count) {
                                case 1:
                                    calories = chars.getData();
                                    break;
                                case 2:
                                    carbs = chars.getData();
                                    break;
                                case 3:
                                    protein = chars.getData();
                                    break;
                                case 4:
                                    fat = chars.getData();
                                    break;
                                case 5:
                                    fiber = chars.getData();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    if(event.isStartElement() && event.asStartElement().getName().toString().equals("div")){
                        StartElement startElement = (StartElement) event;
                        Attribute attrs = startElement.getAttributeByName(new QName("class"));
                        if(attrs != null && attrs.getValue().equals("trial-right")){
                            isInsideTag = false;
                            DrawlData drawl = new DrawlData();
                            drawl.formatDataAfterDrawl(brand, title, categories, calories, type, unit, fat, carbs, fiber, protein);
                        }
                    }
                    
                    
                }
                

                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized DrawlDataDTO formatDataAfterDrawl(String brand, String title, String category,
            String calories, String type, String unit, String fat, String carbs, String fiber, String protein){
        
        if(calories.contains("kcal") || calories.contains("Calories")){
            int index = calories.indexOf("kcal");
            int index1 = calories.indexOf("Calories");
            if(index > index1){
                calories = calories.substring(0, index);
            }else{
                calories = calories.substring(0, index1);
            }
        }
        if(fat.contains("g")){
            fat = fat.substring(0, fat.length() - 1);
        }
        if(carbs.contains("g")){
            carbs = carbs.substring(0, carbs.length() - 1);
        }
        if(fiber.contains("g")){
            fiber = fiber.substring(0, fiber.length() - 1);
        }
        if(protein.contains("g")){
            protein = protein.substring(0, protein.length() - 1);
        }
        if(fat.contains("-") || fat.contains("&")){
            fat = "0";
        }
        if(carbs.contains("-") || carbs.contains("&")){
            carbs = "0";
        }
        if(fiber.contains("-") || fiber.contains("&")){
            fiber = "0";
        }
        if(protein.contains("-") || protein.contains("&")){
            protein = "0";
        }        
        float fatNum = Float.parseFloat(fat);
        float carbsNum = Float.parseFloat(carbs);
        float fiberNum = Float.parseFloat(fiber);
        float proteinNum = Float.parseFloat(protein);
        
        if(fatNum > carbsNum && fatNum > fiberNum && fatNum > proteinNum){
            type = "Fat";
        }else if(carbsNum > fatNum && carbsNum > fiberNum && carbsNum > proteinNum){
            type = "Carbs";
        }else if(fiberNum > fatNum && fiberNum > carbsNum && fiberNum > proteinNum){
            type = "Fiber";
        }else if(proteinNum > fatNum && proteinNum > carbsNum && proteinNum > fiberNum){
            type = "Protein";
        }else{
            type = "Underfined";
        }
        
        
        DrawlDataDTO dto = new DrawlDataDTO(brand, title, category,new BigDecimal(calories.trim()) , unit,
                type, new BigDecimal(fat.trim()), new BigDecimal(carbs.trim()), new BigDecimal(fiber.trim()), new BigDecimal(protein.trim()));
        System.out.println("Brand : " +dto.getBrand());
        System.out.println("Title : " +dto.getTitle());
        System.out.println("Category : " +dto.getCategory());
        System.out.println("Calories : " +dto.getCalories());
        System.out.println("Unit : " +dto.getUnit());
        System.out.println("Type : " +dto.getType());
        System.out.println("Fat : " +dto.getFat());
        System.out.println("Carbs : " +dto.getCarbs());
        System.out.println("Fiber : " +dto.getFiber());
        System.out.println("Protein : " +dto.getProtein());
        return dto;
    }
}
