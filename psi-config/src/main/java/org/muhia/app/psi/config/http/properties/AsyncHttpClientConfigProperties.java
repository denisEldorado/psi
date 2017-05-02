package org.muhia.app.psi.config.http.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.config.http.properties
  Generated on: 12-Mar-17, 19:27.
 */
@PropertySource(value = "file:${CONFIG_PATH}/netty-ahc.properties")
@Configuration
public class AsyncHttpClientConfigProperties {
    @Value("${org.muhia.psi.config.asynchttpclient.threadpoolname}")
    private String asynchttpclientThreadPoolName;
    @Value("${org.muhia.psi.config.asynchttpclient.maxconnections}")
    private int asynchttpclientMaxConnections;
    @Value("${org.muhia.psi.config.asynchttpclient.maxconnectionsperhost}")
    private int asynchttpclientMaxConnectionsPerHost;
    @Value("${org.muhia.psi.config.asynchttpclient.connecttimeout}")
    private int asynchttpclientConnectTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.pooledconnectionidletimeout}")
    private int asynchttpclientPooledConnectionIdleTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.connectionpoolcleanerperiod}")
    private int asynchttpclientConnectionPoolCleanerPeriod;
    @Value("${org.muhia.psi.config.asynchttpclient.readtimeout}")
    private int asynchttpclientReadTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.requesttimeout}")
    private int asynchttpclientRequestTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.connectionttl}")
    private int asynchttpclientConnectionTtl;
    @Value("${org.muhia.psi.config.asynchttpclient.followredirect}")
    private boolean asynchttpclientFollowRedirect;
    @Value("${org.muhia.psi.config.asynchttpclient.maxredirects}")
    private int asynchttpclientMaxRedirects;
    @Value("${org.muhia.psi.config.asynchttpclient.compressionenforced}")
    private boolean asynchttpclientCompressionEnforced;
    @Value("${org.muhia.psi.config.asynchttpclient.useragent}")
    private String asynchttpclientUserAgent;
    @Value("${org.muhia.psi.config.asynchttpclient.enabledprotocols}")
    private String[] asynchttpclientEnabledProtocols;
    @Value("${org.muhia.psi.config.asynchttpclient.enabledciphersuites}")
    private String[] asynchttpclientEnabledCipherSuites;
    @Value("${org.muhia.psi.config.asynchttpclient.useproxyselector}")
    private boolean asynchttpclientUseProxySelector;
    @Value("${org.muhia.psi.config.asynchttpclient.useproxyproperties}")
    private boolean asynchttpclientUseProxyProperties;
    @Value("${org.muhia.psi.config.asynchttpclient.validateresponseheaders}")
    private boolean asynchttpclientValidateResponseHeaders;
    @Value("${org.muhia.psi.config.asynchttpclient.strict302handling}")
    private boolean asynchttpclientStrict302Handling;
    @Value("${org.muhia.psi.config.asynchttpclient.keepalive}")
    private boolean asynchttpclientKeepAlive;
    @Value("${org.muhia.psi.config.asynchttpclient.maxrequestretry}")
    private int asynchttpclientMaxRequestRetry;
    @Value("${org.muhia.psi.config.asynchttpclient.disableurlencodingforboundrequests}")
    private boolean asynchttpclientDisableUrlEncodingForBoundRequests;
    @Value("${org.muhia.psi.config.asynchttpclient.removequeryparamonredirect}")
    private boolean asynchttpclientRemoveQueryParamOnRedirect;
    @Value("${org.muhia.psi.config.asynchttpclient.useopenssl}")
    private boolean asynchttpclientUseOpenSsl;
    @Value("${org.muhia.psi.config.asynchttpclient.useinsecuretrustmanager}")
    private boolean asynchttpclientUseInsecureTrustManager;
    @Value("${org.muhia.psi.config.asynchttpclient.disablehttpsalgorithm}")
    private boolean asynchttpclientDisableHttpsAlgorithm;
    @Value("${org.muhia.psi.config.asynchttpclient.sslsessioncachesize}")
    private int asynchttpclientSslSessionCacheSize;
    @Value("${org.muhia.psi.config.asynchttpclient.sslsessiontimeout}")
    private int asynchttpclientSslSessionTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.tcpnodelay}")
    private boolean asynchttpclientTcpNoDelay;
    @Value("${org.muhia.psi.config.asynchttpclient.soreuseaddress}")
    private boolean asynchttpclientSoReuseAddress;
    @Value("${org.muhia.psi.config.asynchttpclient.solinger}")
    private int asynchttpclientSoLinger;
    @Value("${org.muhia.psi.config.asynchttpclient.sosndbuf}")
    private int asynchttpclientSoSndBuf;
    @Value("${org.muhia.psi.config.asynchttpclient.sorcvbuf}")
    private int asynchttpclientSoRcvBuf;
    @Value("${org.muhia.psi.config.asynchttpclient.httpclientcodecmaxinitiallinelength}")
    private int asynchttpclientHttpClientCodecMaxInitialLineLength;
    @Value("${org.muhia.psi.config.asynchttpclient.httpclientcodecmaxheadersize}")
    private int asynchttpclientHttpClientCodecMaxHeaderSize;
    @Value("${org.muhia.psi.config.asynchttpclient.httpclientcodecmaxchunksize}")
    private int asynchttpclientHttpClientCodecMaxChunkSize;
    @Value("${org.muhia.psi.config.asynchttpclient.disablezerocopy}")
    private boolean asynchttpclientDisableZeroCopy;
    @Value("${org.muhia.psi.config.asynchttpclient.handshaketimeout}")
    private int asynchttpclientHandshakeTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.chunkedfilechunksize}")
    private int asynchttpclientChunkedFileChunkSize;
    @Value("${org.muhia.psi.config.asynchttpclient.websocketmaxbuffersize}")
    private int asynchttpclientWebSocketMaxBufferSize;
    @Value("${org.muhia.psi.config.asynchttpclient.websocketmaxframesize}")
    private int asynchttpclientWebSocketMaxFrameSize;
    @Value("${org.muhia.psi.config.asynchttpclient.keepencodingheader}")
    private boolean asynchttpclientKeepEncodingHeader;
    @Value("${org.muhia.psi.config.asynchttpclient.shutdownquietperiod}")
    private int asynchttpclientShutdownQuietPeriod;
    @Value("${org.muhia.psi.config.asynchttpclient.shutdowntimeout}")
    private int asynchttpclientShutdownTimeout;
    @Value("${org.muhia.psi.config.asynchttpclient.usenativetransport}")
    private boolean asynchttpclientUseNativeTransport;
    @Value("${org.muhia.psi.config.asynchttpclient.iothreadscount}")
    private int asynchttpclientIoThreadsCount;
    @Value("${org.muhia.psi.config.asynchttpclient.response.status.success}") private  int asynchttpclientResponseStatusSuccess;



    public String getAsynchttpclientThreadPoolName() {
        return asynchttpclientThreadPoolName;
    }

    public int getAsynchttpclientMaxConnections() {
        return asynchttpclientMaxConnections;
    }

    public int getAsynchttpclientMaxConnectionsPerHost() {
        return asynchttpclientMaxConnectionsPerHost;
    }

    public int getAsynchttpclientConnectTimeout() {
        return asynchttpclientConnectTimeout;
    }

    public int getAsynchttpclientPooledConnectionIdleTimeout() {
        return asynchttpclientPooledConnectionIdleTimeout;
    }

    public int getAsynchttpclientConnectionPoolCleanerPeriod() {
        return asynchttpclientConnectionPoolCleanerPeriod;
    }

    public int getAsynchttpclientReadTimeout() {
        return asynchttpclientReadTimeout;
    }

    public int getAsynchttpclientRequestTimeout() {
        return asynchttpclientRequestTimeout;
    }

    public int getAsynchttpclientConnectionTtl() {
        return asynchttpclientConnectionTtl;
    }

    public boolean isAsynchttpclientFollowRedirect() {
        return asynchttpclientFollowRedirect;
    }

    public int getAsynchttpclientMaxRedirects() {
        return asynchttpclientMaxRedirects;
    }

    public boolean isAsynchttpclientCompressionEnforced() {
        return asynchttpclientCompressionEnforced;
    }

    public String getAsynchttpclientUserAgent() {
        return asynchttpclientUserAgent;
    }

    public String[] getAsynchttpclientEnabledProtocols() {
        return asynchttpclientEnabledProtocols;
    }

    public String[] getAsynchttpclientEnabledCipherSuites() {
        return asynchttpclientEnabledCipherSuites;
    }

    public boolean isAsynchttpclientUseProxySelector() {
        return asynchttpclientUseProxySelector;
    }

    public boolean isAsynchttpclientUseProxyProperties() {
        return asynchttpclientUseProxyProperties;
    }

    public boolean isAsynchttpclientValidateResponseHeaders() {
        return asynchttpclientValidateResponseHeaders;
    }

    public boolean isAsynchttpclientStrict302Handling() {
        return asynchttpclientStrict302Handling;
    }

    public boolean isAsynchttpclientKeepAlive() {
        return asynchttpclientKeepAlive;
    }

    public int getAsynchttpclientMaxRequestRetry() {
        return asynchttpclientMaxRequestRetry;
    }

    public boolean isAsynchttpclientDisableUrlEncodingForBoundRequests() {
        return asynchttpclientDisableUrlEncodingForBoundRequests;
    }

    public boolean isAsynchttpclientRemoveQueryParamOnRedirect() {
        return asynchttpclientRemoveQueryParamOnRedirect;
    }

    public boolean isAsynchttpclientUseOpenSsl() {
        return asynchttpclientUseOpenSsl;
    }

    public boolean isAsynchttpclientUseInsecureTrustManager() {
        return asynchttpclientUseInsecureTrustManager;
    }

    public boolean isAsynchttpclientDisableHttpsAlgorithm() {
        return asynchttpclientDisableHttpsAlgorithm;
    }

    public int getAsynchttpclientSslSessionCacheSize() {
        return asynchttpclientSslSessionCacheSize;
    }

    public int getAsynchttpclientSslSessionTimeout() {
        return asynchttpclientSslSessionTimeout;
    }

    public boolean isAsynchttpclientTcpNoDelay() {
        return asynchttpclientTcpNoDelay;
    }

    public boolean isAsynchttpclientSoReuseAddress() {
        return asynchttpclientSoReuseAddress;
    }

    public int getAsynchttpclientSoLinger() {
        return asynchttpclientSoLinger;
    }

    public int getAsynchttpclientSoSndBuf() {
        return asynchttpclientSoSndBuf;
    }

    public int getAsynchttpclientSoRcvBuf() {
        return asynchttpclientSoRcvBuf;
    }

    public int getAsynchttpclientHttpClientCodecMaxInitialLineLength() {
        return asynchttpclientHttpClientCodecMaxInitialLineLength;
    }

    public int getAsynchttpclientHttpClientCodecMaxHeaderSize() {
        return asynchttpclientHttpClientCodecMaxHeaderSize;
    }

    public int getAsynchttpclientHttpClientCodecMaxChunkSize() {
        return asynchttpclientHttpClientCodecMaxChunkSize;
    }

    public boolean isAsynchttpclientDisableZeroCopy() {
        return asynchttpclientDisableZeroCopy;
    }

    public int getAsynchttpclientHandshakeTimeout() {
        return asynchttpclientHandshakeTimeout;
    }

    public int getAsynchttpclientChunkedFileChunkSize() {
        return asynchttpclientChunkedFileChunkSize;
    }

    public int getAsynchttpclientWebSocketMaxBufferSize() {
        return asynchttpclientWebSocketMaxBufferSize;
    }

    public int getAsynchttpclientWebSocketMaxFrameSize() {
        return asynchttpclientWebSocketMaxFrameSize;
    }

    public boolean isAsynchttpclientKeepEncodingHeader() {
        return asynchttpclientKeepEncodingHeader;
    }

    public int getAsynchttpclientShutdownQuietPeriod() {
        return asynchttpclientShutdownQuietPeriod;
    }

    public int getAsynchttpclientShutdownTimeout() {
        return asynchttpclientShutdownTimeout;
    }

    public boolean isAsynchttpclientUseNativeTransport() {
        return asynchttpclientUseNativeTransport;
    }

    public int getAsynchttpclientIoThreadsCount() {
        return asynchttpclientIoThreadsCount;
    }

    public int getAsynchttpclientResponseStatusSuccess() {
        return asynchttpclientResponseStatusSuccess;
    }
}
