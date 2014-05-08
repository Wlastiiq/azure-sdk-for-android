/**
 * Copyright Microsoft Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.microsoft.windowsazure.management.network;

import java.util.concurrent.Executors;

import com.microsoft.windowsazure.Configuration;

/**
 *
 * Access service management functionality.
 *
 */
public final class NetworkManagementService {
    private NetworkManagementService() {
        // class is not instantiated
    }

    /**
     * Creates an instance of the <code>VirtualNetworkManagementClient</code>
     * API.
     * @return An instance of the <code>VirtualNetworkManagementClient</code>
     * API.
     */
    public static NetworkManagementClient create() {
        return new NetworkManagementClientImpl(Configuration.getInstance(), Executors.newCachedThreadPool());
    }

    /**
     * Creates an instance of the <code>VirtualNetworkManagementClient</code>
     * API using the specified configuration.
     *
     * @param config A <code>Configuration</code> object that represents the
     * configuration for the service management.
     * @return An instance of the <code>VirtualNetworkManagementClient</code>
     * API.
     */
    public static NetworkManagementClient create(final Configuration config) {
        return new NetworkManagementClientImpl(config, Executors.newCachedThreadPool());
    }
}