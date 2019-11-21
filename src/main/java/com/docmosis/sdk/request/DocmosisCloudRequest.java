/*
 *   Copyright 2019 Docmosis.com or its affiliates.  All Rights Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *   or in the LICENSE file accompanying this file.
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.docmosis.sdk.request;

import com.docmosis.sdk.environment.Environment;
import com.docmosis.sdk.environment.EnvironmentBuilder;
import com.docmosis.sdk.handlers.DocmosisException;
import com.docmosis.sdk.response.DocmosisCloudResponse;

/**
 * The object holds the common instructions and data for a request to the Docmosis cloud.
 * This is an abstract super object with the minimum requirements to make a request.
 * @param <T> Request class
 */
public abstract class DocmosisCloudRequest<T> {
	
	private final String servicePath;
	private EnvironmentBuilder environmentBuilder;

    public DocmosisCloudRequest(final String servicePath) {
    	this(servicePath, Environment.getDefaultEnvironment());
    }
    
    public DocmosisCloudRequest(final String servicePath, final Environment environment) {
    	this.servicePath = servicePath;
    	
    	this.environmentBuilder = EnvironmentBuilder.copyFrom(environment);
    }

    public void setEnvironment(Environment environment) {
    	this.environmentBuilder = EnvironmentBuilder.copyFrom(environment);
    }

    
    public EnvironmentBuilder getEnvironment() {
		return environmentBuilder;
	}

	/**
     * The URL for the web service end point.
     * 
     * @return url of docmosis cloud or tornado endpoint.
     */
	public String getUrl() {
		return environmentBuilder.getUrl(servicePath);
	}
	
	@Override
	public String toString() {
		return "servicePath=" + servicePath + ", environment=" + environmentBuilder.toString();
	}


	/**
	 * Execute a request to the Docmosis cloud based on contained settings and using the default Environment.
     * 
	 * @return a response object giving status, possible error messages and optional
	 * document payload.
	 * 
	 * @throws DocmosisException if a problem occurs invoking the service. 
	 */
	public abstract DocmosisCloudResponse execute() throws DocmosisException;

	/**
	 * Execute a request to the Docmosis cloud based on contained settings.
     * 
     * @param url the service url
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, possible error messages and optional
	 * document payload.
	 * 
	 * @throws DocmosisException if a problem occurs invoking the service.
	 */
	public abstract DocmosisCloudResponse execute(String url, String accessKey) throws DocmosisException;

	/**
	 * Execute a request to the Docmosis cloud based on contained settings.
     * 
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, possible error messages and optional
	 * document payload.
	 * 
	 * @throws DocmosisException if a problem occurs invoking the service 
	 */
	public abstract DocmosisCloudResponse execute(String accessKey) throws DocmosisException;

	/**
	 * Execute a request to the Docmosis cloud based on contained settings.
     * 
     * @param environment the environment configuration
     * 
	 * @return a response object giving status, possible error messages and optional
	 * document payload.
	 * 
	 * @throws DocmosisException if a problem occurs invoking the service 
	 */
	public abstract DocmosisCloudResponse execute(Environment environment) throws DocmosisException;
}
