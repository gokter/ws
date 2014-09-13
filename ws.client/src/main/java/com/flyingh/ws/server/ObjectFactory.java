
package com.flyingh.ws.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.flyingh.ws.server package. 
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

    private final static QName _GetBooksByUserResponse_QNAME = new QName("http://server.ws.flyingh.com/", "getBooksByUserResponse");
    private final static QName _GetBooksByUser_QNAME = new QName("http://server.ws.flyingh.com/", "getBooksByUser");
    private final static QName _SayResponse_QNAME = new QName("http://server.ws.flyingh.com/", "sayResponse");
    private final static QName _Say_QNAME = new QName("http://server.ws.flyingh.com/", "say");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.flyingh.ws.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBooksByUser }
     * 
     */
    public GetBooksByUser createGetBooksByUser() {
        return new GetBooksByUser();
    }

    /**
     * Create an instance of {@link GetBooksByUserResponse }
     * 
     */
    public GetBooksByUserResponse createGetBooksByUserResponse() {
        return new GetBooksByUserResponse();
    }

    /**
     * Create an instance of {@link SayResponse }
     * 
     */
    public SayResponse createSayResponse() {
        return new SayResponse();
    }

    /**
     * Create an instance of {@link Say }
     * 
     */
    public Say createSay() {
        return new Say();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.flyingh.com/", name = "getBooksByUserResponse")
    public JAXBElement<GetBooksByUserResponse> createGetBooksByUserResponse(GetBooksByUserResponse value) {
        return new JAXBElement<GetBooksByUserResponse>(_GetBooksByUserResponse_QNAME, GetBooksByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBooksByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.flyingh.com/", name = "getBooksByUser")
    public JAXBElement<GetBooksByUser> createGetBooksByUser(GetBooksByUser value) {
        return new JAXBElement<GetBooksByUser>(_GetBooksByUser_QNAME, GetBooksByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.flyingh.com/", name = "sayResponse")
    public JAXBElement<SayResponse> createSayResponse(SayResponse value) {
        return new JAXBElement<SayResponse>(_SayResponse_QNAME, SayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Say }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.ws.flyingh.com/", name = "say")
    public JAXBElement<Say> createSay(Say value) {
        return new JAXBElement<Say>(_Say_QNAME, Say.class, null, value);
    }

}
