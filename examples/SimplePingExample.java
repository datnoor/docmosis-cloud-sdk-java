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

import com.docmosis.sdk.environment.InvalidEnvironmentException;
import com.docmosis.sdk.ping.Ping;

/**
 * This example shows how to use the Docmosis Ping service.
 *
 */
public class SimplePingExample {

	public static void main(String args[]) throws InvalidEnvironmentException
	{		
		if (!Ping.execute()) {
			throw new RuntimeException("Could not reach the service");
		}
	}
}
