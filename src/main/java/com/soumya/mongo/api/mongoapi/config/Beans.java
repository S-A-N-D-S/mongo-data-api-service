package com.soumya.mongo.api.mongoapi.config;

import com.soumya.mongo.api.mongoapi.properties.MongoDataApiProperties;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class Beans {

    @Autowired
    private MongoDataApiProperties mongoDataApiProperties;

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate();
////        final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
//    }

//    private CloseableHttpClient httpClient() {
//        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
//        poolingHttpClientConnectionManager.setMaxTotal(mongoDataApiProperties.getMaxConnectionPoolSize());
//        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(mongoDataApiProperties.getMaxConnectionRoutes());
//
//        RequestConfig requestConfig;
//        if (mongoDataApiProperties.getProxy()) {
//            requestConfig = RequestConfig.custom().setConnectTimeout(mongoDataApiProperties.getTimeout()).setConnectionRequestTimeout(mongoDataApiProperties.getRequestTimeout()).setSocketTimeout(mongoDataApiProperties.getSocketTimeout()).setProxy(new HttpHost(mongoDataApiProperties.getProxyHost(), mongoDataApiProperties.getProxyPort())).build();
//            HttpHost host = new HttpHost(mongoDataApiProperties.getProxyHost(), mongoDataApiProperties.getProxyPort());
//            SSLContext context = null;
//            try {
//                context = new SSLContextBuilder().loadTrustMaterial(null, (x509CertChain, authType) -> true).build();
//            } catch (NoSuchAlgorithmException e) {
//                throw new RuntimeException(e);
//            } catch (KeyStoreException e) {
//                throw new RuntimeException(e);
//            } catch (KeyManagementException e) {
//                throw new RuntimeException(e);
//            }
//            CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//            credentialsProvider.setCredentials(new AuthScope(mongoDataApiProperties.getProxyHost(), mongoDataApiProperties.getProxyPort()), new UsernamePasswordCredentials(mongoDataApiProperties.getProxyUsername(), mongoDataApiProperties.getProxyPassword()));
//            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().disableConnectionState().disableCookieManagement().disableAuthCaching().setDefaultCredentialsProvider(credentialsProvider).setRoutePlanner(new DefaultProxyRoutePlanner(host) {
//                @Override
//                public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
//                    return super.determineProxy(httpHost, httpRequest, httpContext);
//                }
//            })
//                    .setSSLContext(context)
//                    .setConnectionManager(new PoolingHttpClientConnectionManager(
//                            RegistryBuilder.<ConnectionSocketFactory>create()
//                                    .register("http", PlainConnectionSocketFactory.INSTANCE)
//                                    .register("https", new SSLConnectionSocketFactory(context,
//                                            NoopHostnameVerifier.INSTANCE))
//                                    .build()
//                    ))
//                    .setProxy(new HttpHost(mongoDataApiProperties.getProxyHost(), mongoDataApiProperties.getProxyPort()))
//                    .setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy())
//                    .setRedirectStrategy(new LaxRedirectStrategy()).build();
//            return closeableHttpClient;
//        } else {
//        }
//    }
}
