package com.sbhima.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@ResponseBody
	@RequestMapping(value = "getData")
	public String getResponse(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		return "Sample Response";
	}
}
