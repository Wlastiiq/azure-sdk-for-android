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

package com.microsoft.windowsazure.management.compute;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.OperationStatusResponse;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.compute.models.HostedServiceAddExtensionParameters;
import com.microsoft.windowsazure.management.compute.models.HostedServiceCheckNameAvailabilityResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceCreateParameters;
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetExtensionResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceListAvailableExtensionsResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceListExtensionsResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceListResponse;
import com.microsoft.windowsazure.management.compute.models.HostedServiceUpdateParameters;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
* The Service Management API includes operations for managing the hosted
* services beneath your subscription.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/ee460812.aspx for more
* information)
*/
public interface HostedServiceOperations {
    /**
    * The Add Extension operation adds an available extension to your cloud
    * service. In Azure, a process can run as an extension of a cloud service.
    * For example, Remote Desktop Access or the Azure Diagnostics Agent can
    * run as extensions to the cloud service. You can find the available
    * extension by using the List Available Extensions operation.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169558.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Add Extension
    * operation.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    OperationStatusResponse addExtension(String serviceName, HostedServiceAddExtensionParameters parameters) throws InterruptedException, ExecutionException, ServiceException;
    
    /**
    * The Add Extension operation adds an available extension to your cloud
    * service. In Azure, a process can run as an extension of a cloud service.
    * For example, Remote Desktop Access or the Azure Diagnostics Agent can
    * run as extensions to the cloud service. You can find the available
    * extension by using the List Available Extensions operation.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169558.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Add Extension
    * operation.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    Future<OperationStatusResponse> addExtensionAsync(String serviceName, HostedServiceAddExtensionParameters parameters);
    
    /**
    * The Begin Adding Extension operation adds an available extension to your
    * cloud service. In Azure, a process can run as an extension of a cloud
    * service. For example, Remote Desktop Access or the Azure Diagnostics
    * Agent can run as extensions to the cloud service. You can find the
    * available extension by using the List Available Extensions operation.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/dn169558.aspx
    * for more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Begin Adding
    * Extension operation.
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
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse beginAddingExtension(String serviceName, HostedServiceAddExtensionParameters parameters) throws MalformedURLException, ProtocolException, ParserConfigurationException, SAXException, TransformerException, ServiceException, IOException;
    
    /**
    * The Begin Adding Extension operation adds an available extension to your
    * cloud service. In Azure, a process can run as an extension of a cloud
    * service. For example, Remote Desktop Access or the Azure Diagnostics
    * Agent can run as extensions to the cloud service. You can find the
    * available extension by using the List Available Extensions operation.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/dn169558.aspx
    * for more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Begin Adding
    * Extension operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> beginAddingExtensionAsync(String serviceName, HostedServiceAddExtensionParameters parameters);
    
    /**
    * The Begin Deleting All Hosted Service operation deletes the specified
    * cloud service from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse beginDeletingAll(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException;
    
    /**
    * The Begin Deleting All Hosted Service operation deletes the specified
    * cloud service from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> beginDeletingAllAsync(String serviceName);
    
    /**
    * The Begin Deleting Extension operation deletes the specified extension
    * from a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169560.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse beginDeletingExtension(String serviceName, String extensionId) throws MalformedURLException, ProtocolException, ServiceException, IOException;
    
    /**
    * The Begin Deleting Extension operation deletes the specified extension
    * from a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169560.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> beginDeletingExtensionAsync(String serviceName, String extensionId);
    
    /**
    * The Check Hosted Service Name Availability operation checks for the
    * availability of the specified cloud service name.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154116.aspx for
    * more information)
    *
    * @param serviceName Required. The cloud service name that you would like
    * to use.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The Check Hosted Service Name Availability operation response.
    */
    HostedServiceCheckNameAvailabilityResponse checkNameAvailability(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException;
    
    /**
    * The Check Hosted Service Name Availability operation checks for the
    * availability of the specified cloud service name.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154116.aspx for
    * more information)
    *
    * @param serviceName Required. The cloud service name that you would like
    * to use.
    * @return The Check Hosted Service Name Availability operation response.
    */
    Future<HostedServiceCheckNameAvailabilityResponse> checkNameAvailabilityAsync(String serviceName);
    
    /**
    * The Create Hosted Service operation creates a new cloud service in Azure.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/gg441304.aspx
    * for more information)
    *
    * @param parameters Required. Parameters supplied to the Create Hosted
    * Service operation.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
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
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse create(HostedServiceCreateParameters parameters) throws InterruptedException, ExecutionException, ServiceException, MalformedURLException, ProtocolException, ParserConfigurationException, SAXException, TransformerException, IOException, URISyntaxException;
    
    /**
    * The Create Hosted Service operation creates a new cloud service in Azure.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/gg441304.aspx
    * for more information)
    *
    * @param parameters Required. Parameters supplied to the Create Hosted
    * Service operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> createAsync(HostedServiceCreateParameters parameters);
    
    /**
    * The Delete Hosted Service operation deletes the specified cloud service
    * from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse delete(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException, InterruptedException, ExecutionException;
    
    /**
    * The Delete Hosted Service operation deletes the specified cloud service
    * from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> deleteAsync(String serviceName);
    
    /**
    * The Delete All Hosted Service operation deletes the specified cloud
    * service from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    OperationStatusResponse deleteAll(String serviceName) throws InterruptedException, ExecutionException, ServiceException;
    
    /**
    * The Delete All Hosted Service operation deletes the specified cloud
    * service from Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441305.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    Future<OperationStatusResponse> deleteAllAsync(String serviceName);
    
    /**
    * The Delete Extension operation deletes the specified extension from a
    * cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169560.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    OperationStatusResponse deleteExtension(String serviceName, String extensionId) throws InterruptedException, ExecutionException, ServiceException;
    
    /**
    * The Delete Extension operation deletes the specified extension from a
    * cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169560.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request. If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request and error information regarding the failure.
    */
    Future<OperationStatusResponse> deleteExtensionAsync(String serviceName, String extensionId);
    
    /**
    * The Get Hosted Service Properties operation retrieves system properties
    * for the specified cloud service. These properties include the service
    * name and service type; and the name of the affinity group to which the
    * service belongs, or its location if it is not part of an affinity group.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/ee460806.aspx
    * for more information)
    *
    * @param serviceName Required. The name of the cloud service.
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
    * @return The Get Hosted Service operation response.
    */
    HostedServiceGetResponse get(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The Get Hosted Service Properties operation retrieves system properties
    * for the specified cloud service. These properties include the service
    * name and service type; and the name of the affinity group to which the
    * service belongs, or its location if it is not part of an affinity group.
    * (see http://msdn.microsoft.com/en-us/library/windowsazure/ee460806.aspx
    * for more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return The Get Hosted Service operation response.
    */
    Future<HostedServiceGetResponse> getAsync(String serviceName);
    
    /**
    * The Get Detailed Hosted Service Properties operation retrieves system
    * properties for the specified cloud service. These properties include the
    * service name and service type; the name of the affinity group to which
    * the service belongs, or its location if it is not part of an affinity
    * group; and information on the deployments of the service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460806.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
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
    * @return The detailed Get Hosted Service operation response.
    */
    HostedServiceGetDetailedResponse getDetailed(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The Get Detailed Hosted Service Properties operation retrieves system
    * properties for the specified cloud service. These properties include the
    * service name and service type; the name of the affinity group to which
    * the service belongs, or its location if it is not part of an affinity
    * group; and information on the deployments of the service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460806.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return The detailed Get Hosted Service operation response.
    */
    Future<HostedServiceGetDetailedResponse> getDetailedAsync(String serviceName);
    
    /**
    * The Get Extension operation retrieves information about a specified
    * extension that was added to a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169557.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The Get Extension operation response.
    */
    HostedServiceGetExtensionResponse getExtension(String serviceName, String extensionId) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException;
    
    /**
    * The Get Extension operation retrieves information about a specified
    * extension that was added to a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169557.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param extensionId Required. The identifier that was assigned to the
    * extension when it was added to the cloud service
    * @return The Get Extension operation response.
    */
    Future<HostedServiceGetExtensionResponse> getExtensionAsync(String serviceName, String extensionId);
    
    /**
    * The List Hosted Services operation lists the cloud services available
    * under the current subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460781.aspx for
    * more information)
    *
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
    * @return The List Hosted Service operation response.
    */
    HostedServiceListResponse list() throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The List Hosted Services operation lists the cloud services available
    * under the current subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460781.aspx for
    * more information)
    *
    * @return The List Hosted Service operation response.
    */
    Future<HostedServiceListResponse> listAsync();
    
    /**
    * The List Available Extensions operation lists the extensions that are
    * available to add to your cloud service. In Windows Azure, a process can
    * run as an extension of a cloud service. For example, Remote Desktop
    * Access or the Azure Diagnostics Agent can run as extensions to the cloud
    * service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169559.aspx for
    * more information)
    *
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
    * @return The List Available Extensions operation response.
    */
    HostedServiceListAvailableExtensionsResponse listAvailableExtensions() throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The List Available Extensions operation lists the extensions that are
    * available to add to your cloud service. In Windows Azure, a process can
    * run as an extension of a cloud service. For example, Remote Desktop
    * Access or the Azure Diagnostics Agent can run as extensions to the cloud
    * service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169559.aspx for
    * more information)
    *
    * @return The List Available Extensions operation response.
    */
    Future<HostedServiceListAvailableExtensionsResponse> listAvailableExtensionsAsync();
    
    /**
    * The List Extensions operation lists all of the extensions that were added
    * to a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169561.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @throws MalformedURLException Thrown in case of an invalid request URL
    * @throws ProtocolException Thrown if invalid request method
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The List Extensions operation response.
    */
    HostedServiceListExtensionsResponse listExtensions(String serviceName) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException;
    
    /**
    * The List Extensions operation lists all of the extensions that were added
    * to a cloud service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn169561.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @return The List Extensions operation response.
    */
    Future<HostedServiceListExtensionsResponse> listExtensionsAsync(String serviceName);
    
    /**
    * The List Extension Versions operation lists the versions of an extension
    * that are available to add to a cloud service. In Azure, a process can
    * run as an extension of a cloud service. For example, Remote Desktop
    * Access or the Azure Diagnostics Agent can run as extensions to the cloud
    * service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn495437.aspx for
    * more information)
    *
    * @param providerNamespace Required. The provider namespace.
    * @param extensionType Required. The extension type name.
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
    * @return The List Available Extensions operation response.
    */
    HostedServiceListAvailableExtensionsResponse listExtensionVersions(String providerNamespace, String extensionType) throws MalformedURLException, ProtocolException, ServiceException, IOException, ParserConfigurationException, SAXException, URISyntaxException;
    
    /**
    * The List Extension Versions operation lists the versions of an extension
    * that are available to add to a cloud service. In Azure, a process can
    * run as an extension of a cloud service. For example, Remote Desktop
    * Access or the Azure Diagnostics Agent can run as extensions to the cloud
    * service.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/dn495437.aspx for
    * more information)
    *
    * @param providerNamespace Required. The provider namespace.
    * @param extensionType Required. The extension type name.
    * @return The List Available Extensions operation response.
    */
    Future<HostedServiceListAvailableExtensionsResponse> listExtensionVersionsAsync(String providerNamespace, String extensionType);
    
    /**
    * The Update Hosted Service operation can update the label or description
    * of a cloud service in Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441303.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Update Hosted
    * Service operation.
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
    * @throws InterruptedException Thrown when a thread is waiting, sleeping,
    * or otherwise occupied, and the thread is interrupted, either before or
    * during the activity. Occasionally a method may wish to test whether the
    * current thread has been interrupted, and if so, to immediately throw
    * this exception. The following code can be used to achieve this effect:
    * @throws ExecutionException Thrown when attempting to retrieve the result
    * of a task that aborted by throwing an exception. This exception can be
    * inspected using the Throwable.getCause() method.
    * @throws ServiceException Thrown if the server returned an error for the
    * request.
    * @throws URISyntaxException Thrown if there was an error parsing a URI in
    * the response.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    OperationResponse update(String serviceName, HostedServiceUpdateParameters parameters) throws MalformedURLException, ProtocolException, ParserConfigurationException, SAXException, TransformerException, ServiceException, IOException, InterruptedException, ExecutionException, URISyntaxException;
    
    /**
    * The Update Hosted Service operation can update the label or description
    * of a cloud service in Azure.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441303.aspx for
    * more information)
    *
    * @param serviceName Required. The name of the cloud service.
    * @param parameters Required. Parameters supplied to the Update Hosted
    * Service operation.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    Future<OperationResponse> updateAsync(String serviceName, HostedServiceUpdateParameters parameters);
}
