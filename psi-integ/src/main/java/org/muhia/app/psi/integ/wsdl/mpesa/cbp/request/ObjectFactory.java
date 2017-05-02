
package org.muhia.app.psi.integ.wsdl.mpesa.cbp.request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import java.math.BigInteger;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.muhia.app.psi.integ.wsdl.mpesa.cbp.request package. 
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

    private final static QName _RequestMsg_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "RequestMsg");
    private final static QName _RequestSOAPHeader_QNAME = new QName("http://www.huawei.com.cn/schema/common/v2_1", "RequestSOAPHeader");
    private final static QName _Response_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/response", "response");
    private final static QName _Request_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "request");
    private final static QName _Result_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "result");
    private final static QName _ResponseMsg_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/request", "ResponseMsg");

    private final static QName _ResultResultType_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultType");
    private final static QName _ResultOriginatorConversationID_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "OriginatorConversationID");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.muhia.app.psi.integ.wsdl.mpesa.cbp.request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link Request.Identity }
     * 
     */
    public Request.Identity createRequestIdentity() {
        return new Request.Identity();
    }

    /**
     * Create an instance of {@link Request.Transaction }
     * 
     */
    public Request.Transaction createRequestTransaction() {
        return new Request.Transaction();
    }

    /**
     * Create an instance of {@link Request.Transaction.Parameters }
     * 
     */
    public Request.Transaction.Parameters createRequestTransactionParameters() {
        return new Request.Transaction.Parameters();
    }

    /**
     * Create an instance of {@link Result }
     * 
     */
    public Result createResult() {
        return new Result();
    }

    /**
     * Create an instance of {@link ParameterType }
     * 
     */
    public ParameterType createParameterType() {
        return new ParameterType();
    }

    /**
     * Create an instance of {@link ParameterType2 }
     * 
     */
    public ParameterType2 createParameterType2() {
        return new ParameterType2();
    }

    /**
     * Create an instance of {@link RequestSOAPHeader }
     * 
     */
    public RequestSOAPHeader createRequestSOAPHeader() {
        return new RequestSOAPHeader();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Request.Identity.Caller }
     * 
     */
    public Request.Identity.Caller createRequestIdentityCaller() {
        return new Request.Identity.Caller();
    }

    /**
     * Create an instance of {@link Request.Identity.Initiator }
     * 
     */
    public Request.Identity.Initiator createRequestIdentityInitiator() {
        return new Request.Identity.Initiator();
    }

    /**
     * Create an instance of {@link Request.Identity.PrimaryParty }
     * 
     */
    public Request.Identity.PrimaryParty createRequestIdentityPrimartyParty() {
        return new Request.Identity.PrimaryParty();
    }

    /**
     * Create an instance of {@link Request.Identity.ReceiverParty }
     * 
     */
    public Request.Identity.ReceiverParty createRequestIdentityReceiverParty() {
        return new Request.Identity.ReceiverParty();
    }

    /**
     * Create an instance of {@link Request.Identity.AccessDevice }
     * 
     */
    public Request.Identity.AccessDevice createRequestIdentityAccessDevice() {
        return new Request.Identity.AccessDevice();
    }

    /**
     * Create an instance of {@link Request.Transaction.ReferenceData }
     * 
     */
    public Request.Transaction.ReferenceData createRequestTransactionReferenceData() {
        return new Request.Transaction.ReferenceData();
    }

    /**
     * Create an instance of {@link Request.Transaction.Parameters.Parameter }
     * 
     */
    public Request.Transaction.Parameters.Parameter createRequestTransactionParametersParameter() {
        return new Request.Transaction.Parameters.Parameter();
    }

    /**
     * Create an instance of {@link Result.ResultParameters }
     * 
     */
    public Result.ResultParameters createResultResultParameters() {
        return new Result.ResultParameters();
    }

    /**
     * Create an instance of {@link Result.ReferenceData }
     * 
     */
    public Result.ReferenceData createResultReferenceData() {
        return new Result.ReferenceData();
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/request", name = "RequestMsg")
    public JAXBElement<String> createRequestMsg(String value) {
        return new JAXBElement<>(_RequestMsg_QNAME, String.class, JAXBElement.GlobalScope.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestSOAPHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.huawei.com.cn/schema/common/v2_1", name = "RequestSOAPHeader")
    public JAXBElement<RequestSOAPHeader> createRequestSOAPHeader(RequestSOAPHeader value) {
        return new JAXBElement<RequestSOAPHeader>(_RequestSOAPHeader_QNAME, RequestSOAPHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/response", name = "response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/request", name = "request")
    public JAXBElement<Request> createRequest(Request value) {
        return new JAXBElement<Request>(_Request_QNAME, Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "result")
    public JAXBElement<Result> createResult(Result value) {
        return new JAXBElement<Result>(_Result_QNAME, Result.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/request", name = "ResponseMsg")
    public JAXBElement<String> createResponseMsg(String value) {
        return new JAXBElement<String>(_ResponseMsg_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "ResultType", scope = Result.class)
    public JAXBElement<BigInteger> createResultResultType(BigInteger value) {
        return new JAXBElement<BigInteger>(_ResultResultType_QNAME, BigInteger.class, Result.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", name = "OriginatorConversationID", scope = Result.class)
    public JAXBElement<String> createResultOriginatorConversationID(String value) {
        return new JAXBElement<String>(_ResultOriginatorConversationID_QNAME, String.class, Result.class, value);
    }

}
