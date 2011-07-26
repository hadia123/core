/*
 * Copyright 2011 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.extensions.application;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;

/**
 * {@link ResourceHandlerWrapper} which wraps PrimeFaces Extensions resources and
 * apends the version of Primefaces Extensions in the {@link PrimeFacesExtensionsResource}.
 *
 * @author Thomas Andraschko
 * @since 0.1
 */
public class PrimeFacesExtensionsResourceHandler extends ResourceHandlerWrapper {

	public static final String VERSION = "0.2-SNAPSHOT";
	public static final String LIBRARY = "primefaces-extensions";

	private ResourceHandler resourceHandler;

	public PrimeFacesExtensionsResourceHandler(final ResourceHandler resourceHandler) {
		this.resourceHandler = resourceHandler;
	}

	@Override
	public ResourceHandler getWrapped() {
		return resourceHandler;
	}

	@Override
	public Resource createResource(final String resourceName, final String libraryName) {
		Resource resource = super.createResource(resourceName, libraryName);

		if (resource != null && libraryName != null
				&& libraryName.equalsIgnoreCase(LIBRARY)) {
			return new PrimeFacesExtensionsResource(resource);
		} else {
			return resource;
		}
	}
}
