// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.core.http;

import java.util.concurrent.TimeUnit;

/**
 * The type that enables {@link HttpPipelinePolicy} implementations to access the {@link HttpRequest}
 * and the corresponding {@link HttpResponse} flowing through the pipeline.
 *
 * <p>
 * Additionally policy implementations uses {@link HttpPipelinePolicyChain} to:
 *   <ul>
 *     <li>signal the completion of request-response interception.
 *     <li>check whether the http call is cancelled.
 *   </ul>
 * </p>
 */
public interface HttpPipelinePolicyChain {
    /**
     * Gets the {@link HttpRequest} object.
     *
     * @return The HTTP request object.
     */
    HttpRequest getRequest();

    /**
     * Signal that the pipeline can proceed with the execution of the next policy.
     * <p>
     * A policy implementation calls this method to indicate its completion of request
     * interception and to signal that the next policy can be executed.
     * </p>
     * @param request The HTTP Request.
     */
    void processNextPolicy(HttpRequest request);

    /**
     * Signal that the pipeline can proceed with the execution of the next policy.
     * <p>
     * A policy implementation calls this method to indicate its completion of request
     * interception and to signal that the next policy can be executed.
     * </p>
     * @param request The HTTP Request.
     * @param callback The callback to receive the {@link HttpResponse} or the error from
     *     the next policy once its completes the execution.
     */
    void processNextPolicy(HttpRequest request, HttpCallback callback);


    /**
     * Signal that, after the specified delay the pipeline can proceed with the execution of the next policy.
     * <p>
     * A policy implementation calls this method to indicate its completion of request
     * interception and to signal that the next policy can be executed.
     * </p>
     * @param request The HTTP Request.
     * @param delay The time from now to delay the execution of next policy.
     * @param timeUnit The time unit of the {@code delay}.
     */
    void processNextPolicy(HttpRequest request, long delay, TimeUnit timeUnit);

    /**
     * Signal that, after the specified delay the pipeline can proceed with the execution of the next policy.
     * <p>
     * A policy implementation calls this method to indicate its completion of request
     * interception and to signal that the next policy can be executed.
     * </p>
     * @param request The HTTP Request.
     * @param callback The callback to receive the {@link HttpResponse} or the error from
     *     the next policy once its completes the execution.
     * @param delay The time from now to delay the execution of next policy.
     * @param timeUnit The time unit of the {@code delay}.
     */
    void processNextPolicy(HttpRequest request, HttpCallback callback, long delay, TimeUnit timeUnit);

    /**
     * Signal that the policy execution is successfully finished.
     * <p>
     * A policy implementation calls this method to indicate its completion of response
     * interception and to signal that response should be given to the previous policy
     * in the pipeline.
     * </p>
     * @param response The HTTP Response.
     */
    void finishedProcessing(HttpResponse response);

    /**
     * Signal that the policy execution is finished with failure.
     * <p>
     * A policy implementation calls this method to signal that its execution is failed
     * and the failure should be propagated to the previous policy in the pipeline.
     * </p>
     * @param error The failure.
     */
    void finishedProcessing(Throwable error);
}
