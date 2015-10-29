package com.tingtingma.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.tingtingma.common.WxContent;
import com.tingtingma.dao.wx.AccessToken;

public class WxInitTest {

	
	@Test
	public void testGetAccesstoken() throws Exception {
		String url = WxContent.ACCESSTOKENURL;
		url = url.replace("APPID", WxContent.APPID);
		url = url.replace("APPSECRET", WxContent.APPSECRET);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);
		int code = response.getStatusLine().getStatusCode();
		System.out.println(code);
		if(code >= 200 && code <=300){
			HttpEntity httpEntity =  response.getEntity();
			String  strHttpEntity =  EntityUtils.toString(httpEntity);
			System.out.println(strHttpEntity);
			AccessToken accessToken =  JSON.parseObject(strHttpEntity,  AccessToken.class);
			System.out.println(accessToken.getAccess_token()+","+accessToken.getExpires_in());
		}
		
	}
	
}
