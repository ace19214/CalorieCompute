
package jaxb.general;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.general package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListFoods_QNAME = new QName("http://calorie.compute", "listFoods");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.general
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListFoodsItem }
     * 
     */
    public ListFoodsItem createListFoodsItem() {
        return new ListFoodsItem();
    }

    /**
     * Create an instance of {@link Foods }
     * 
     */
    public Foods createFoods() {
        return new Foods();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListFoodsItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calorie.compute", name = "listFoods")
    public JAXBElement<ListFoodsItem> createListFoods(ListFoodsItem value) {
        return new JAXBElement<ListFoodsItem>(_ListFoods_QNAME, ListFoodsItem.class, null, value);
    }

}
