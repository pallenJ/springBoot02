package com.example.bootweb01.service;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class KakaoAPI {

	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();
			
			//POST요청을 위해 setDoOutput을 true로
			conn.setRequestMethod("POST");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return access_Token;
	}

}
