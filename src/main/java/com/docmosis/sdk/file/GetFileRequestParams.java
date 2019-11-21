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
package com.docmosis.sdk.file;

import com.docmosis.sdk.request.param.RequestParameters;

/**
 * The object holds the parameters for a request to the Get File service.
 * See the Web Services Developer guide at <a href="https://www.docmosis.com/support">https://www.docmosis.com/support</a>
 * for details about the settings for the request.  The properties set in this class 
 * are parameters for the Get File request.
 *
 */
public class GetFileRequestParams extends RequestParameters {

	private static final String FILE_NAME			= "fileName";
	
	private static final String[] REQUIRED_PARAMS	= {FILE_NAME};

	public GetFileRequestParams() {
		super(REQUIRED_PARAMS);
	}

	/**
	 * The name of the file, optionally including its path.
	 * @return file name
	 */
	public String getFileName() {
		return getStringParam(FILE_NAME);
	}

	/**
	 * Set the name of the file, optionally including its path.
	 * @param fileName name and path of the file
	 */
	public void setFileName(String fileName) {
		super.setParam(FILE_NAME, fileName);
	}
}
