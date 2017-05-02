package org.muhia.app.psi.integ.wsdl.crba.transunion;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 */
@WebServiceClient(name = "ControllerKenyaImplService", targetNamespace = "http://impl.ws.crbws.transunion.ke.co/", wsdlLocation = "apis/crbafrica_transunion.wsdl")
public class ControllerKenyaImplService extends Service {

    private final static URL CONTROLLERKENYAIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONTROLLERKENYAIMPLSERVICE_EXCEPTION;
    private final static QName CONTROLLERKENYAIMPLSERVICE_QNAME = new QName("http://impl.ws.crbws.transunion.ke.co/", "ControllerKenyaImplService");

    static {
        CONTROLLERKENYAIMPLSERVICE_WSDL_LOCATION = org.muhia.app.psi.integ.wsdl.crba.transunion.ControllerKenyaImplService.class.getResource("apis/crbafrica_transunion.wsdl");
        WebServiceException e = null;
        if (CONTROLLERKENYAIMPLSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'apis/crbafrica_transunion.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        CONTROLLERKENYAIMPLSERVICE_EXCEPTION = e;
    }

    public ControllerKenyaImplService() {
        super(__getWsdlLocation(), CONTROLLERKENYAIMPLSERVICE_QNAME);
    }

    public ControllerKenyaImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONTROLLERKENYAIMPLSERVICE_QNAME, features);
    }

    public ControllerKenyaImplService(URL wsdlLocation) {
        super(wsdlLocation, CONTROLLERKENYAIMPLSERVICE_QNAME);
    }

    public ControllerKenyaImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONTROLLERKENYAIMPLSERVICE_QNAME, features);
    }

    public ControllerKenyaImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ControllerKenyaImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    private static URL __getWsdlLocation() {
        if (CONTROLLERKENYAIMPLSERVICE_EXCEPTION != null) {
            throw CONTROLLERKENYAIMPLSERVICE_EXCEPTION;
        }
        return CONTROLLERKENYAIMPLSERVICE_WSDL_LOCATION;
    }

    /**
     * @return returns ControllerKenya
     */
    @WebEndpoint(name = "ControllerKenyaImplPort")
    public ControllerKenya getControllerKenyaImplPort() {
        return super.getPort(new QName("http://impl.ws.crbws.transunion.ke.co/", "ControllerKenyaImplPort"), ControllerKenya.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns ControllerKenya
     */
    @WebEndpoint(name = "ControllerKenyaImplPort")
    public ControllerKenya getControllerKenyaImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.ws.crbws.transunion.ke.co/", "ControllerKenyaImplPort"), ControllerKenya.class, features);
    }

}