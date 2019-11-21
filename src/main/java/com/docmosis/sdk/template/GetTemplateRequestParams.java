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

import java.util.List;

import com.docmosis.sdk.request.param.RequestParameters;

/**
 * The object holds the parameters for a request to the Get Template service.
 * See the Web Services Developer guide at <a href="https://www.docmosis.com/support">https://www.docmosis.com/support</a>
 * for details about the settings for the request.  The properties set in this class 
 * are parameters for the Get Template request.
 *
 */
public class GetTemplateRequestParams extends RequestParameters {

	private static final String TEMPLATE_NAME		= "templateName";
	
	private static final String[] REQUIRED_PARAMS	= {TEMPLATE_NAME};

	public GetTemplateRequestParams() {
		super(REQUIRED_PARAMS);
	}
	
	/**
	 * Get the currently set templateNames.
	 * 
	 * @return List of the name of the Templates on the docmosis server.
	 */
	public List<String> getTemplateNames() {
		return getStringListParam(TEMPLATE_NAME);
	}

	/**
	 * Add the name of a Template to get.
	 * 
	 * @param templateName The name of the Template on the docmosis server. Should include path, eg "samples/WelcomeTemplate.docx"
	 */
	public void setTemplateName(String templateName) {
		super.addParam(TEMPLATE_NAME, templateName);
	}
	
	/**
	 * Set the names of the Templates to get.
	 * 
	 * @param templateNames The name(s) of the Template on the docmosis server. Should include path, eg "samples/WelcomeTemplate.docx"
	 */
	public void setTemplateNames(List<String> templateNames) {
		super.setParam(TEMPLATE_NAME, templateNames);
	}
}
