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

import com.docmosis.sdk.environment.Environment;
import com.docmosis.sdk.request.DocmosisCloudFileRequest;

/**
 * The object holds the instructions and data for a request to the Get Image service.
 * See the Web Services Developer guide at <a href="https://www.docmosis.com/support">https://www.docmosis.com/support</a>
 * for details about the settings for the request.  The properties set in this class 
 * are parameters for the Get Image request.
 * 
 * Typically, you would use the Image class to get an instance of this class, then
 * set the specifics you require using method chaining:
 * 
 * 
 * <pre>
 *  GetImageResponse response = Image
 *                                .get()
 *                                .addImageName(imageToGet)
 *                                .sendTo(outputFileOrStream)
 *                                .execute();
 *  if (response.hasSucceeded()) {
 *      //File saved to outputFileOrStream
 *  }
 * </pre>
 */
public class GetImageRequest extends DocmosisCloudFileRequest<GetImageRequest> {

	private static final String SERVICE_PATH = "getImage";
	
	private GetImageRequestParams params = new GetImageRequestParams();

	public GetImageRequest() {
		super(SERVICE_PATH);
	}
	
	public GetImageRequest(final Environment environment) {
		super(SERVICE_PATH, environment);
	}
	
	public GetImageRequestParams getParams()
    {
    	return params;
    }

	/**
	 * Set the names of the Images to get.
	 * 
	 * @param imageNames The name of the Image(s) on the Docmosis server. Should include path, eg "HeaderImages/companyLogo.png"
	 * @return this request for method chaining
	 */
	public GetImageRequest imageNames(List<String> imageNames) {
		params.setImageNames(imageNames);
		return this;
	}
	
	/**
	 * Add the name of an Image to get.
	 * 
	 * @param imageName The name of the Image on the Docmosis server. Should include path, eg "HeaderImages/companyLogo.png"
	 * @return this request for method chaining
	 */
	public GetImageRequest imageName(String imageName) {
		params.setImageName(imageName);
		return this;
	}

	/**
	 * Execute a get image request based on contained settings and using the default Environment.
     * 
	 * @return a response object giving status, success message or possible error messages.
	 * 
	 * @throws ImageException if a problem occurs invoking the service 
	 */
	@Override
	public GetImageResponse execute() throws ImageException {
		return Image.executeGetImage(this);
	}

	/**
	 * Execute a get image request based on contained settings.
     * 
     * @param url the service url
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, success message or possible error messages.
	 * 
	 * @throws ImageException if a problem occurs invoking the service 
	 */
	@Override
	public GetImageResponse execute(String url, String accessKey) throws ImageException {
		getEnvironment().setBaseUrl(url).setAccessKey(accessKey);
		return Image.executeGetImage(this);
	}

	/**
	 * Execute a get image request based on contained settings.
     * 
     * @param accessKey your unique Docmosis accesskey
     * 
	 * @return a response object giving status, success message or possible error messages.
	 * 
	 * @throws ImageException if a problem occurs invoking the service 
	 */
	@Override
	public GetImageResponse execute(String accessKey) throws ImageException {
		getEnvironment().setAccessKey(accessKey);
		return Image.executeGetImage(this);
	}

	/**
	 * Execute a get image request based on contained settings.
     * 
     * @param environment the environment configuration
     * 
	 * @return a response object giving status, success message or possible error messages.
	 * 
	 * @throws ImageException if a problem occurs invoking the service 
	 */
	@Override
	public GetImageResponse execute(Environment environment) throws ImageException {
		super.setEnvironment(environment);
		return Image.executeGetImage(this);
	}

	@Override
	protected GetImageRequest getThis()
	{
		return this;
	}

	@Override
	public String toString() {
		return params.toString();
	}
}
