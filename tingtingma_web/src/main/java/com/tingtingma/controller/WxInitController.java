package com.tingtingma.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WxInitController {

	private static final String TOKEN = "tingtingma";
	
	@RequestMapping("/wxInit")
	public void wxInit(HttpServletRequest request,HttpServletResponse response) throws IOException{
/*		signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		timestamp	时间戳
		nonce	随机数
		echostr	随机字符串*/
		String  timestamp = request.getParameter("timestamp");
		String  nonce = request.getParameter("nonce");
		
		
		String  signature = request.getParameter("signature");
		String  echostr = request.getParameter("echostr");
		
		String[] arrayStr = new String[]{TOKEN,timestamp,nonce};
		Arrays.sort(arrayStr);
		StringBuffer str = new StringBuffer();
		for (String string : arrayStr) {
			str.append(string);
		}
		
		String sha1Str =  DigestUtils.sha1Hex(str.toString());
		
		if(sha1Str.equals(signature)){
			response.getWriter().println(echostr);
		}
		
		
	}
	
}
