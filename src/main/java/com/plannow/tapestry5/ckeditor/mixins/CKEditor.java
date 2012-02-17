// Copyright 2011 Plannow Technologies
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.plannow.tapestry5.ckeditor.mixins;

import java.util.HashMap;
import java.util.Map;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

@Import(library = "ckeditor/ckeditor.js")
public class CKEditor
{
	@Parameter
	private Map<String, ?> parameters;

	@InjectContainer
	private TextArea textArea;

	@Inject
	private JavaScriptSupport javaScriptSupport;

	Map<String, ?> defaultParameters()
	{
		return new HashMap<String, String>()
		{
			{
				put("toolbar", "Full");
			}
		};
	}

	void afterRender(MarkupWriter writer)
	{
		String name = textArea.getControlName();
		String id = textArea.getClientId();

		JSONObject json = new JSONObject();
		if (parameters != null)
			for (String paramName : parameters.keySet())
				json.put(paramName, parameters.get(paramName));

		javaScriptSupport.addScript("CKEDITOR.replace('%s', %s);", name, json.toCompactString());
		javaScriptSupport.addScript("document.observe(Tapestry.FORM_PREPARE_FOR_SUBMIT_EVENT, function(){"
				+ "CKEDITOR.instances.%s.updateElement()})", id);		
	}
}
