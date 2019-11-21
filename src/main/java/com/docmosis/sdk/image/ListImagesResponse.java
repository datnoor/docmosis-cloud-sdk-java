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

import com.docmosis.sdk.response.DocmosisCloudResponse;

/**
 * This class encapsulates a response to a list images request.
 * 
 * Typically you would use this response to check for success, then access the returned list of 
 * ImageDetails objects.  For example:
 * 
 * 
 * <pre>
 *   ListImagesResponse response = Image.list().execute();
 *   List&lt;ImageDetails&gt; list = response.list();
 *   for(ImageDetails id : list) {
 *       System.out.println(id.toString());
 *   }
 * </pre>
 */
public class ListImagesResponse extends DocmosisCloudResponse {

	private boolean imageListStale;
	private List<ImageDetails> images = null;
	
	protected ListImagesResponse(DocmosisCloudResponse other) {
		super(other);
	}

	/**
	 * The list of images having the following attributes for each image:
	 * name - the image file name
	 * lastModifiedMillisSinceEpoch - last modified in milliseconds
	 * lastModifiedISO8601 - last modified yyyy-MM-dd'T'HH:mm:ssZ
	 * sizeBytes - the size in bytes
	 * md5 - the md5 hash code for the image
	 * @return List of ImageDetails Objects
	 */
	public List<ImageDetails> getImages() {
		return images;
	}
	
	/**
	 * The list of images having the following attributes for each image:
	 * name - the image file name
	 * lastModifiedMillisSinceEpoch - last modified in milliseconds
	 * lastModifiedISO8601 - last modified yyyy-MM-dd'T'HH:mm:ssZ
	 * sizeBytes - the size in bytes
	 * md5 - the md5 hash code for the image
	 * @return List of ImageDetails Objects
	 */
	public List<ImageDetails> list() {
		return images;
	}

	protected void setImages(List<ImageDetails> images) {
		this.images = images;
	}

	/**
	 * If Docmosis detects changes to the image list are in progress (such
	 * as updates or deletions) this flag will be set to true to indicate
	 * the list is not necessarily up to date. This is only ever expected
	 * to be true for a short period after deletes or updates.
	 * @return image list stale state
	 */
	public boolean getImageListStale() {
		return imageListStale;
	}

	protected void setImageListStale(boolean imageListStale) {
		this.imageListStale = imageListStale;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("imageListStale: " + getImageListStale());
		if (images != null) { //Build formatted String to return.
			for(ImageDetails id : images) {
				sb.append(System.getProperty("line.separator"));
				sb.append(id.toString());
			}
		}
		return sb.toString();
	}
}
