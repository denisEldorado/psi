
package org.muhia.app.psi.integ.wsdl.mpesa.cbp.result;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ResultMgrService", targetNamespace = "http://api-v1.gen.mm.vodafone.com/mminterface/result", wsdlLocation = "xsd/CBPInterface_Result.wsdl")
public class ResultMgrService
    extends Service
{

    private final static URL RESULTMGRSERVICE_WSDL_LOCATION;
    private final static WebServiceException RESULTMGRSERVICE_EXCEPTION;
    private final static QName RESULTMGRSERVICE_QNAME = new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrService");

    static {
        RESULTMGRSERVICE_WSDL_LOCATION = org.muhia.app.psi.integ.wsdl.mpesa.cbp.result.ResultMgrService.class.getResource("xsd/CBPInterface_Result.wsdl");
        WebServiceException e = null;
        if (RESULTMGRSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'xsd/CBPInterface_Result.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        RESULTMGRSERVICE_EXCEPTION = e;
    }

    public ResultMgrService() {
        super(__getWsdlLocation(), RESULTMGRSERVICE_QNAME);
    }

    public ResultMgrService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RESULTMGRSERVICE_QNAME, features);
    }

    public ResultMgrService(URL wsdlLocation) {
        super(wsdlLocation, RESULTMGRSERVICE_QNAME);
    }

    public ResultMgrService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RESULTMGRSERVICE_QNAME, features);
    }

    public ResultMgrService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ResultMgrService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ResultMgrPortType
     */
    @WebEndpoint(name = "ResultMgrServicePort")
    public ResultMgrPortType getResultMgrServicePort() {
        return super.getPort(new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrServicePort"), ResultMgrPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ResultMgrPortType
     */
    @WebEndpoint(name = "ResultMgrServicePort")
    public ResultMgrPortType getResultMgrServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://api-v1.gen.mm.vodafone.com/mminterface/result", "ResultMgrServicePort"), ResultMgrPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RESULTMGRSERVICE_EXCEPTION!= null) {
            throw RESULTMGRSERVICE_EXCEPTION;
        }
        return RESULTMGRSERVICE_WSDL_LOCATION;
    }

}
