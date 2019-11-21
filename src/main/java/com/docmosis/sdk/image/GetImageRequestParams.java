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
package com.docmosis.sdk.image;

import java.util.List;

import com.docmosis.sdk.request.param.RequestParameters;

/**
 * The object holds the parameters for a request to the Get Image service.
 * See the Web Services Developer guide at <a href="https://www.docmosis.com/support">https://www.docmosis.com/support</a>
 * for details about the settings for the request.  The properties set in this class 
 * are parameters for the Get Image request.
 *
 */
public class GetImageRequestParams extends RequestParameters {
	
	private static final String IMAGE_NAME			= "imageName";
	
	private static final String[] REQUIRED_PARAMS	= {IMAGE_NAME};

	public GetImageRequestParams() {
		super(REQUIRED_PARAMS);
	}

	/**
	 * Get the currently set Image Names
	 * @return The image names list.
	 */
	public List<String> getImageNames() {
		return getStringListParam(IMAGE_NAME);
	}

	/**
	 * Add the name of an Image to get.
	 * 
	 * @param imageName The name of the Image on the Docmosis server. Should include path, eg "HeaderImages/companyLogo.png"
	 */
	public void setImageName(String imageName) {
		super.addParam(IMAGE_NAME, imageName);
	}

	/**
	 * Set the names of the Images to get.
	 * 
	 * @param imageNames The name of the Image(s) on the Docmosis server. Should include path, eg "HeaderImages/companyLogo.png"
	 */
	public void setImageNames(List<String> imageNames) {
		super.setParam(IMAGE_NAME, imageNames);
	}
}
