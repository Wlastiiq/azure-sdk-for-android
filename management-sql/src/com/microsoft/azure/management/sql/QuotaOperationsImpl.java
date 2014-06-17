/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.sql;

import com.microsoft.azure.AzureHttpStatus;
import com.microsoft.azure.core.ServiceOperations;
import com.microsoft.azure.core.utils.BOMInputStream;
import com.microsoft.azure.exception.ServiceException;
import com.microsoft.azure.management.sql.models.Quota;
import com.microsoft.azure.management.sql.models.QuotaGetResponse;
import com.microsoft.azure.management.sql.models.QuotaListResponse;
import com.microsoft.azure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.datatype.DatatypeConfigurationException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
* The Azure SQL Database Management API includes operations for getting Azure
* SQL Database Server quotas. Specifically, using the APIs you can get a
* specific quota or list all of the quotas for the Azure SQL Database Server.
*/
public class QuotaOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, QuotaOperations {
    /**
    * Initializes a new instance of the QuotaOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    QuotaOperationsImpl(SqlManagementClientImpl client) {
        this.client = client;
    }
    
    private SqlManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.sql.SqlManagementClientImpl.
    * @return The Client value.
    */
    public SqlManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Retrieves the specified quota from the server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * from which to retrieve the quota.
    * @param quotaName Required. The name of the quota to retrieve.
    * @return Represents the response structure for the Quota Get operation.
    */
    @Override
    public Future<QuotaGetResponse> getAsync(final String serverName, final String quotaName) {
        return this.getClient().getExecutorService().submit(new Callable<QuotaGetResponse>() { 
            @Override
            public QuotaGetResponse call() throws Exception {
                return get(serverName, quotaName);
            }
         });
    }
    
    /**
    * Retrieves the specified quota from the server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * from which to retrieve the quota.
    * @param quotaName Required. The name of the quota to retrieve.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws XmlPullParserException This exception is thrown to signal XML
    * Pull Parser related faults.
    * @throws DatatypeConfigurationException Invalid datatype configuration
    * @return Represents the response structure for the Quota Get operation.
    */
    @Override
    public QuotaGetResponse get(String serverName, String quotaName) throws MalformedURLException, ProtocolException, ServiceException, IOException, XmlPullParserException, DatatypeConfigurationException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (quotaName == null) {
            throw new NullPointerException("quotaName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("quotaName", quotaName);
            CloudTracing.enter(invocationId, this, "getAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/serverquotas/" + quotaName.trim();
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("GET");
        httpRequest.setDoInput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            QuotaGetResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new QuotaGetResponse();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new InputStreamReader(new BOMInputStream(responseContent)));
            
            int eventType = xmlPullParser.getEventType();
            while ((eventType == XmlPullParser.END_DOCUMENT) != true) {
                if (eventType == XmlPullParser.START_TAG && "ServiceResource".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                    while ((eventType == XmlPullParser.END_TAG && "ServiceResource".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                        if (eventType == XmlPullParser.START_TAG && "ServiceResource".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                            while ((eventType == XmlPullParser.END_TAG && "ServiceResource".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                Quota serviceResourceInstance = new Quota();
                                result.setQuota(serviceResourceInstance);
                                
                                if (eventType == XmlPullParser.START_TAG && "Value".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Value".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String valueInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            valueInstance = xmlPullParser.getText();
                                            serviceResourceInstance.setValue(valueInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String nameInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            nameInstance = xmlPullParser.getText();
                                            serviceResourceInstance.setName(nameInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "Type".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "Type".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String typeInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            typeInstance = xmlPullParser.getText();
                                            serviceResourceInstance.setType(typeInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                if (eventType == XmlPullParser.START_TAG && "State".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                    while ((eventType == XmlPullParser.END_TAG && "State".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                        String stateInstance;
                                        if (eventType == XmlPullParser.TEXT) {
                                            stateInstance = xmlPullParser.getText();
                                            serviceResourceInstance.setState(stateInstance);
                                        }
                                        
                                        eventType = xmlPullParser.next();
                                    }
                                }
                                
                                eventType = xmlPullParser.next();
                            }
                        }
                        
                        eventType = xmlPullParser.next();
                    }
                }
                
                eventType = xmlPullParser.next();
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
    
    /**
    * Returns a list of quotas from the server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * from which to get the quotas.
    * @return Represents the response structure for the Quota List operation.
    */
    @Override
    public Future<QuotaListResponse> listAsync(final String serverName) {
        return this.getClient().getExecutorService().submit(new Callable<QuotaListResponse>() { 
            @Override
            public QuotaListResponse call() throws Exception {
                return list(serverName);
            }
         });
    }
    
    /**
    * Returns a list of quotas from the server.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * from which to get the quotas.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws XmlPullParserException This exception is thrown to signal XML
    * Pull Parser related faults.
    * @throws DatatypeConfigurationException Invalid datatype configuration
    * @return Represents the response structure for the Quota List operation.
    */
    @Override
    public QuotaListResponse list(String serverName) throws MalformedURLException, ProtocolException, ServiceException, IOException, XmlPullParserException, DatatypeConfigurationException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/serverquotas";
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        URL serverAddress = new URL(url);
        HttpURLConnection httpRequest = ((HttpURLConnection) serverAddress.openConnection());
        httpRequest.setRequestMethod("GET");
        httpRequest.setDoInput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Set Credentials
        this.getClient().getCredentials().processRequest(httpRequest);
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != AzureHttpStatus.OK) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            QuotaListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new QuotaListResponse();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new InputStreamReader(new BOMInputStream(responseContent)));
            
            int eventType = xmlPullParser.getEventType();
            while ((eventType == XmlPullParser.END_DOCUMENT) != true) {
                if (eventType == XmlPullParser.START_TAG && "ServiceResources".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                    while ((eventType == XmlPullParser.END_TAG && "ServiceResources".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                        if (eventType == XmlPullParser.START_TAG && "ServiceResource".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                            Quota serviceResourceInstance = new Quota();
                            result.getQuotas().add(serviceResourceInstance);
                            
                            if (eventType == XmlPullParser.START_TAG && "Value".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                while ((eventType == XmlPullParser.END_TAG && "Value".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                    String valueInstance;
                                    if (eventType == XmlPullParser.TEXT) {
                                        valueInstance = xmlPullParser.getText();
                                        serviceResourceInstance.setValue(valueInstance);
                                    }
                                    
                                    eventType = xmlPullParser.next();
                                }
                            }
                            
                            if (eventType == XmlPullParser.START_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                while ((eventType == XmlPullParser.END_TAG && "Name".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                    String nameInstance;
                                    if (eventType == XmlPullParser.TEXT) {
                                        nameInstance = xmlPullParser.getText();
                                        serviceResourceInstance.setName(nameInstance);
                                    }
                                    
                                    eventType = xmlPullParser.next();
                                }
                            }
                            
                            if (eventType == XmlPullParser.START_TAG && "Type".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                while ((eventType == XmlPullParser.END_TAG && "Type".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                    String typeInstance;
                                    if (eventType == XmlPullParser.TEXT) {
                                        typeInstance = xmlPullParser.getText();
                                        serviceResourceInstance.setType(typeInstance);
                                    }
                                    
                                    eventType = xmlPullParser.next();
                                }
                            }
                            
                            if (eventType == XmlPullParser.START_TAG && "State".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) {
                                while ((eventType == XmlPullParser.END_TAG && "State".equals(xmlPullParser.getName()) && "http://schemas.microsoft.com/windowsazure".equals(xmlPullParser.getNamespace())) != true) {
                                    String stateInstance;
                                    if (eventType == XmlPullParser.TEXT) {
                                        stateInstance = xmlPullParser.getText();
                                        serviceResourceInstance.setState(stateInstance);
                                    }
                                    
                                    eventType = xmlPullParser.next();
                                }
                            }
                            
                            eventType = xmlPullParser.next();
                        }
                        
                        eventType = xmlPullParser.next();
                    }
                }
                
                eventType = xmlPullParser.next();
            }
            
            result.setStatusCode(statusCode);
            result.setRequestId(httpRequest.getHeaderField("x-ms-request-id"));
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpRequest != null) {
                httpRequest.disconnect();
            }
        }
    }
}
