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

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.sql.models.DacExportParameters;
import com.microsoft.windowsazure.management.sql.models.DacGetStatusResponse;
import com.microsoft.windowsazure.management.sql.models.DacImportExportResponse;
import com.microsoft.windowsazure.management.sql.models.DacImportParameters;
import com.microsoft.windowsazure.management.sql.models.StatusInfo;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* Includes operations for importing and exporting SQL Databases into and out of
* Windows Azure blob storage.
*/
public class DacOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, DacOperations {
    /**
    * Initializes a new instance of the DacOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    DacOperationsImpl(SqlManagementClientImpl client) {
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
    * Export DAC into Windows Azure blob storage.
    *
    * @param serverName Required. The name of the server being exported from.
    * @param parameters Optional. Export parameters.
    * @return Response for an DAC Import/Export request.
    */
    @Override
    public Future<DacImportExportResponse> exportAsync(final String serverName, final DacExportParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<DacImportExportResponse>() { 
            @Override
            public DacImportExportResponse call() throws Exception {
                return export(serverName, parameters);
            }
         });
    }
    
    /**
    * Export DAC into Windows Azure blob storage.
    *
    * @param serverName Required. The name of the server being exported from.
    * @param parameters Optional. Export parameters.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @return Response for an DAC Import/Export request.
    */
    @Override
    public DacImportExportResponse export(String serverName, DacExportParameters parameters) throws MalformedURLException, ProtocolException, ParserConfigurationException, SAXException, TransformerException, ServiceException, IOException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (parameters != null) {
            if (parameters.getBlobCredentials() != null) {
                if (parameters.getBlobCredentials().getStorageAccessKey() == null) {
                    throw new NullPointerException("parameters.BlobCredentials.StorageAccessKey");
                }
                if (parameters.getBlobCredentials().getUri() == null) {
                    throw new NullPointerException("parameters.BlobCredentials.Uri");
                }
            }
            if (parameters.getConnectionInfo() != null) {
                if (parameters.getConnectionInfo().getDatabaseName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.DatabaseName");
                }
                if (parameters.getConnectionInfo().getPassword() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.Password");
                }
                if (parameters.getConnectionInfo().getServerName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.ServerName");
                }
                if (parameters.getConnectionInfo().getUserName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.UserName");
                }
            }
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "exportAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/DacOperations/Export";
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
        httpRequest.setRequestMethod("Post");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        if (parameters != null) {
            Element exportInputElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ExportInput");
            requestDoc.appendChild(exportInputElement);
            
            if (parameters.getBlobCredentials() != null) {
                Element blobCredentialsElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "BlobCredentials");
                exportInputElement.appendChild(blobCredentialsElement);
                
                Attr typeAttribute = requestDoc.createAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type");
                typeAttribute.setValue("BlobStorageAccessKeyCredentials");
                blobCredentialsElement.setAttributeNode(typeAttribute);
                
                Element uriElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "Uri");
                uriElement.appendChild(requestDoc.createTextNode(parameters.getBlobCredentials().getUri().toString()));
                blobCredentialsElement.appendChild(uriElement);
                
                Element storageAccessKeyElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "StorageAccessKey");
                storageAccessKeyElement.appendChild(requestDoc.createTextNode(parameters.getBlobCredentials().getStorageAccessKey()));
                blobCredentialsElement.appendChild(storageAccessKeyElement);
            }
            
            if (parameters.getConnectionInfo() != null) {
                Element connectionInfoElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ConnectionInfo");
                exportInputElement.appendChild(connectionInfoElement);
                
                Element databaseNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "DatabaseName");
                databaseNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getDatabaseName()));
                connectionInfoElement.appendChild(databaseNameElement);
                
                Element passwordElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "Password");
                passwordElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getPassword()));
                connectionInfoElement.appendChild(passwordElement);
                
                Element serverNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ServerName");
                serverNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getServerName()));
                connectionInfoElement.appendChild(serverNameElement);
                
                Element userNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "UserName");
                userNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getUserName()));
                connectionInfoElement.appendChild(userNameElement);
            }
        }
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        
        // Send Request
        try {
            httpRequest.getOutputStream().write(requestContent.getBytes());
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != 200) {
                ServiceException ex = ServiceException.createFromXml(requestContent, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            DacImportExportResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new DacImportExportResponse();
            DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
            documentBuilderFactory2.setNamespaceAware(true);
            DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
            Document responseDoc = documentBuilder2.parse(new BOMInputStream(responseContent));
            
            Element guidElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/2003/10/Serialization/", "guid");
            if (guidElement != null) {
                result.setGuid(guidElement.getTextContent());
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
    * Gets the status of the DAC.
    *
    * @param serverName Required. The name of the server.
    * @param fullyQualifiedServerName Required. The fully qualified name of the
    * server.
    * @param username Required. The server's username.
    * @param password Required. The server's password.
    * @param requestId Required. The request ID of the operation being queried.
    * @return The response structure for the DAC GetStatus operation.
    */
    @Override
    public Future<DacGetStatusResponse> getStatusAsync(final String serverName, final String fullyQualifiedServerName, final String username, final String password, final String requestId) {
        return this.getClient().getExecutorService().submit(new Callable<DacGetStatusResponse>() { 
            @Override
            public DacGetStatusResponse call() throws Exception {
                return getStatus(serverName, fullyQualifiedServerName, username, password, requestId);
            }
         });
    }
    
    /**
    * Gets the status of the DAC.
    *
    * @param serverName Required. The name of the server.
    * @param fullyQualifiedServerName Required. The fully qualified name of the
    * server.
    * @param username Required. The server's username.
    * @param password Required. The server's password.
    * @param requestId Required. The request ID of the operation being queried.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return The response structure for the DAC GetStatus operation.
    */
    @Override
    public DacGetStatusResponse getStatus(String serverName, String fullyQualifiedServerName, String username, String password, String requestId) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (fullyQualifiedServerName == null) {
            throw new NullPointerException("fullyQualifiedServerName");
        }
        if (username == null) {
            throw new NullPointerException("username");
        }
        if (password == null) {
            throw new NullPointerException("password");
        }
        if (requestId == null) {
            throw new NullPointerException("requestId");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("fullyQualifiedServerName", fullyQualifiedServerName);
            tracingParameters.put("username", username);
            tracingParameters.put("password", password);
            tracingParameters.put("requestId", requestId);
            CloudTracing.enter(invocationId, this, "getStatusAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/DacOperations/Status" + "?";
        url = url + "servername=" + URLEncoder.encode(fullyQualifiedServerName.trim(), "UTF-8");
        url = url + "&" + "username=" + URLEncoder.encode(username.trim(), "UTF-8");
        url = url + "&" + "password=" + URLEncoder.encode(password.trim(), "UTF-8");
        url = url + "&" + "reqId=" + URLEncoder.encode(requestId.trim(), "UTF-8");
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
        httpRequest.setRequestMethod("Get");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Send Request
        try {
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != 200) {
                ServiceException ex = ServiceException.createFromXml(null, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            DacGetStatusResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new DacGetStatusResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element arrayOfStatusInfoElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ArrayOfStatusInfo");
            if (arrayOfStatusInfoElement != null) {
                if (arrayOfStatusInfoElement != null) {
                    for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(arrayOfStatusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "StatusInfo").size(); i1 = i1 + 1) {
                        org.w3c.dom.Element statusInfoElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(arrayOfStatusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "StatusInfo").get(i1));
                        StatusInfo statusInfoInstance = new StatusInfo();
                        result.getStatusInfoList().add(statusInfoInstance);
                        
                        Element blobUriElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "BlobUri");
                        if (blobUriElement != null) {
                            URI blobUriInstance;
                            blobUriInstance = new URI(blobUriElement.getTextContent());
                            statusInfoInstance.setBlobUri(blobUriInstance);
                        }
                        
                        Element databaseNameElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "DatabaseName");
                        if (databaseNameElement != null) {
                            String databaseNameInstance;
                            databaseNameInstance = databaseNameElement.getTextContent();
                            statusInfoInstance.setDatabaseName(databaseNameInstance);
                        }
                        
                        Element errorMessageElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ErrorMessage");
                        if (errorMessageElement != null) {
                            boolean isNil = false;
                            Attr nilAttribute = errorMessageElement.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "nil");
                            if (nilAttribute != null) {
                                isNil = "true".equals(nilAttribute.getValue());
                            }
                            if (isNil == false) {
                                String errorMessageInstance;
                                errorMessageInstance = errorMessageElement.getTextContent();
                                statusInfoInstance.setErrorMessage(errorMessageInstance);
                            }
                        }
                        
                        Element lastModifiedTimeElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "LastModifiedTime");
                        if (lastModifiedTimeElement != null) {
                            Calendar lastModifiedTimeInstance;
                            lastModifiedTimeInstance = DatatypeConverter.parseDateTime(lastModifiedTimeElement.getTextContent());
                            statusInfoInstance.setLastModifiedTime(lastModifiedTimeInstance);
                        }
                        
                        Element queuedTimeElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "QueuedTime");
                        if (queuedTimeElement != null) {
                            Calendar queuedTimeInstance;
                            queuedTimeInstance = DatatypeConverter.parseDateTime(queuedTimeElement.getTextContent());
                            statusInfoInstance.setQueuedTime(queuedTimeInstance);
                        }
                        
                        Element requestIdElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "RequestId");
                        if (requestIdElement != null) {
                            String requestIdInstance;
                            requestIdInstance = requestIdElement.getTextContent();
                            statusInfoInstance.setRequestId(requestIdInstance);
                        }
                        
                        Element requestTypeElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "RequestType");
                        if (requestTypeElement != null) {
                            String requestTypeInstance;
                            requestTypeInstance = requestTypeElement.getTextContent();
                            statusInfoInstance.setRequestType(requestTypeInstance);
                        }
                        
                        Element serverNameElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ServerName");
                        if (serverNameElement != null) {
                            String serverNameInstance;
                            serverNameInstance = serverNameElement.getTextContent();
                            statusInfoInstance.setServerName(serverNameInstance);
                        }
                        
                        Element statusElement = XmlUtility.getElementByTagNameNS(statusInfoElement, "http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "Status");
                        if (statusElement != null) {
                            String statusInstance;
                            statusInstance = statusElement.getTextContent();
                            statusInfoInstance.setStatus(statusInstance);
                        }
                    }
                }
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
    * Import DAC from Windows Azure blob storage.
    *
    * @param serverName Required. The name of the server being imported to.
    * @param parameters Optional. Import parameters.
    * @return Response for an DAC Import/Export request.
    */
    @Override
    public Future<DacImportExportResponse> importAsync(final String serverName, final DacImportParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<DacImportExportResponse>() { 
            @Override
            public DacImportExportResponse call() throws Exception {
                return import(serverName, parameters);
            }
         });
    }
    
    /**
    * Import DAC from Windows Azure blob storage.
    *
    * @param serverName Required. The name of the server being imported to.
    * @param parameters Optional. Import parameters.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @return Response for an DAC Import/Export request.
    */
    @Override
    public DacImportExportResponse import(String serverName, DacImportParameters parameters) throws MalformedURLException, ProtocolException, ParserConfigurationException, SAXException, TransformerException, ServiceException, IOException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (parameters != null) {
            if (parameters.getBlobCredentials() != null) {
                if (parameters.getBlobCredentials().getStorageAccessKey() == null) {
                    throw new NullPointerException("parameters.BlobCredentials.StorageAccessKey");
                }
                if (parameters.getBlobCredentials().getUri() == null) {
                    throw new NullPointerException("parameters.BlobCredentials.Uri");
                }
            }
            if (parameters.getConnectionInfo() != null) {
                if (parameters.getConnectionInfo().getDatabaseName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.DatabaseName");
                }
                if (parameters.getConnectionInfo().getPassword() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.Password");
                }
                if (parameters.getConnectionInfo().getServerName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.ServerName");
                }
                if (parameters.getConnectionInfo().getUserName() == null) {
                    throw new NullPointerException("parameters.ConnectionInfo.UserName");
                }
            }
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "importAsync", tracingParameters);
        }
        
        // Construct URL
        String baseUrl = this.getClient().getBaseUri().toString();
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "/DacOperations/Import";
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
        httpRequest.setRequestMethod("Post");
        httpRequest.setDoOutput(true);
        
        // Set Headers
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        httpRequest.setRequestProperty("x-ms-version", "2012-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        if (parameters != null) {
            Element importInputElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ImportInput");
            requestDoc.appendChild(importInputElement);
            
            if (parameters.getAzureEdition() != null) {
                Element azureEditionElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "AzureEdition");
                azureEditionElement.appendChild(requestDoc.createTextNode(parameters.getAzureEdition()));
                importInputElement.appendChild(azureEditionElement);
            }
            
            if (parameters.getBlobCredentials() != null) {
                Element blobCredentialsElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "BlobCredentials");
                importInputElement.appendChild(blobCredentialsElement);
                
                Attr typeAttribute = requestDoc.createAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type");
                typeAttribute.setValue("BlobStorageAccessKeyCredentials");
                blobCredentialsElement.setAttributeNode(typeAttribute);
                
                Element uriElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "Uri");
                uriElement.appendChild(requestDoc.createTextNode(parameters.getBlobCredentials().getUri().toString()));
                blobCredentialsElement.appendChild(uriElement);
                
                Element storageAccessKeyElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "StorageAccessKey");
                storageAccessKeyElement.appendChild(requestDoc.createTextNode(parameters.getBlobCredentials().getStorageAccessKey()));
                blobCredentialsElement.appendChild(storageAccessKeyElement);
            }
            
            if (parameters.getConnectionInfo() != null) {
                Element connectionInfoElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ConnectionInfo");
                importInputElement.appendChild(connectionInfoElement);
                
                Element databaseNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "DatabaseName");
                databaseNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getDatabaseName()));
                connectionInfoElement.appendChild(databaseNameElement);
                
                Element passwordElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "Password");
                passwordElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getPassword()));
                connectionInfoElement.appendChild(passwordElement);
                
                Element serverNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "ServerName");
                serverNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getServerName()));
                connectionInfoElement.appendChild(serverNameElement);
                
                Element userNameElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "UserName");
                userNameElement.appendChild(requestDoc.createTextNode(parameters.getConnectionInfo().getUserName()));
                connectionInfoElement.appendChild(userNameElement);
            }
            
            Element databaseSizeInGBElement = requestDoc.createElementNS("http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.Management.Dac.ServiceTypes", "DatabaseSizeInGB");
            databaseSizeInGBElement.appendChild(requestDoc.createTextNode(Integer.toString(parameters.getDatabaseSizeInGB())));
            importInputElement.appendChild(databaseSizeInGBElement);
        }
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        httpRequest.setRequestProperty("Content-Type", "application/xml");
        
        // Send Request
        try {
            httpRequest.getOutputStream().write(requestContent.getBytes());
            int statusCode = httpRequest.getResponseCode();
            if (statusCode != 200) {
                ServiceException ex = ServiceException.createFromXml(requestContent, httpRequest.getResponseMessage(), httpRequest.getResponseCode(), httpRequest.getContentType(), httpRequest.getInputStream());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            DacImportExportResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpRequest.getInputStream();
            result = new DacImportExportResponse();
            DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
            documentBuilderFactory2.setNamespaceAware(true);
            DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
            Document responseDoc = documentBuilder2.parse(new BOMInputStream(responseContent));
            
            Element guidElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/2003/10/Serialization/", "guid");
            if (guidElement != null) {
                result.setGuid(guidElement.getTextContent());
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
