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
package com.docmosis.sdk.template;

import com.docmosis.sdk.environment.Environment;
import com.docmosis.sdk.request.DocmosisCloudRequest;

/**
 * The object holds the instructions and data for a request to the Get Template Structure service.
 * See the Web Services Developer guide at <a href="https://www.docmosis.com/support">https://www.docmosis.com/support</a>
 * for details about the settings for the request.  The properties set in this class 
 * are parameters for the Get Template Structure request.
 * 
 * Typically, you would use the Template class to get an instance of this class, then
 * set the specifics you require using method chaining:
 * 
 * 
 * <pre>
 *   GetTemplateStructureResponse response = Template
 *                                             .getStructure()
 *                                             .templateName("MasterTemplates/MyMasterTemplate.docx")
 *                                             .execute();
 *   if (response.hasSucceeded()) {
 *       response.getTemplateStructureString();
 *   }
 * </pre>
 */
public class GetTemplateStructureRequest extends DocmosisCloudRequest<GetTemplateStructureRequest> {

	private static final String SERVICE_PATH = "getTemplateStructure";

	private GetTemplateStructureRequestParams params = new GetTemplateStructureRequestParams();

	public GetTemplateStructureRequest() {
		super(SERVICE_PATH);
	}
	
	public GetTemplateStructureRequest(final Environment environment) {
		super(SERVICE_PATH, environment);
	}
	
	public GetTemplateStructureRequestParams getParams()
    {
    	return params;
    }

	/**
	 * Set the Template Name.
	 * 
	 * @param templateName The name of the Template on the docmosis server. Should include path, eg "samples/WelcomeTemplate.docx"
	 * @return this request for method chaining
	 */
	public GetTemplateStructureRequest templateName(String templateName) {
		params.setTemplateName(templateName);
		return this;
	}

	/**
	 * Execute a get template structure request based on contained settings and using the default Environment.
     * 
	 * @return a response object giving status, template structure in json format and possible error messages.
	 * 
	 * @throws TemplateException if a problem occurs invoking the service 
	 */
	@Override
	public GetTemplateStructureResponse execute() throws TemplateException {
		return Template.executeGetTemplateStructure(this);
	}

	/**
	 * Execute a get template structure request based on contained settings.
     * 
     * @param url the service url
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, template structure in json format and possible error messages.
	 * 
	 * @throws TemplateException if a problem occurs invoking the service 
	 */
	@Override
	public GetTemplateStructureResponse execute(String url, String accessKey) throws TemplateException {
		getEnvironment().setBaseUrl(url).setAccessKey(accessKey);
		return Template.executeGetTemplateStructure(this);
	}

	/**
	 * Execute a get template structure request based on contained settings.
     * 
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, template structure in json format and possible error messages.
	 * 
	 * @throws TemplateException if a problem occurs invoking the service 
	 */
	@Override
	public GetTemplateStructureResponse execute(String accessKey) throws TemplateException {
		getEnvironment().setAccessKey(accessKey);
		return Template.executeGetTemplateStructure(this);
	}

	/**
	 * Execute a get template structure request based on contained settings.
     * 
     * @param environment the environment configuration
     * 
	 * @return a response object giving status, template structure in json format and possible error messages.
	 * 
	 * @throws TemplateException if a problem occurs invoking the service 
	 */
	@Override
	public GetTemplateStructureResponse execute(Environment environment) throws TemplateException {
		super.setEnvironment(environment);
		return Template.executeGetTemplateStructure(this);
	}

	@Override
	public String toString() {
		return params.toString();
	}
}
