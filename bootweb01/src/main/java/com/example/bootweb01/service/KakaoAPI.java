package com.example.bootweb01.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoAPI {

	public String getAccessToken(String authorize_code) {
		String access_Token = "";
		String refresh_Token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// POST요청을 위해 setDoOutput을 true로
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuffer sb = new StringBuffer();
			// https://kauth.kakao.com/oauth/authorize?client_id=cd38b0930f04cc1506e2a3beecf1923c&redirect_uri=http://localhost:8007/login&response_type=code
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=cd38b0930f04cc1506e2a3beecf1923c");
			sb.append("&redirect_uri=http://localhost:8007/login");
			sb.append("&code=" + authorize_code);
			bw.write(sb.toString());
			bw.flush();

			int responseCode = conn.getResponseCode();
			log.info("response code:{}", responseCode);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			StringBuffer rsSb = new StringBuffer();
			String result = "";
			
			while ((line = br.readLine()) != null) {
				rsSb.append(line);
			}
			result = rsSb.toString();
			log.info("response body:{}", result);

			//Json 파싱
			
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			access_Token  = element.getAsJsonObject().get("access_token").getAsString();
			refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
			
			br.close();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return access_Token;
	}

	public Map<String, Object> getUserInfo(String access_Token) {
	    //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 Map사용
	    Map<String, Object> userInfo = new HashMap<>();
	    String reqURL = "https://kapi.kakao.com/v2/user/me";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        
	        //    요청에 필요한 Header에 포함될 내용
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
	        
	        int responseCode = conn.getResponseCode();
	        log.info("responseCode : {}" , responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String line = "";
	        String result = "";
	        StringBuffer rsSb = new StringBuffer();
	        while ((line = br.readLine()) != null) {
	            rsSb.append(line);
	        }
	        result = rsSb.toString();
	        log.info("response body : {}" , result);
	        
	        JsonParser parser = new JsonParser();
	        JsonElement element = parser.parse(result);
	        
	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
	        
	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	        String email = kakao_account.getAsJsonObject().get("email").getAsString();
	         
	        userInfo.put("nickname", nickname);
	        userInfo.put("email", email);
	        
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    return userInfo;
	}
	public void kakaoLogout(String access_Token) {
	    String reqURL = "https://kapi.kakao.com/v1/user/logout";
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer " + access_Token);
	        
	        int responseCode = conn.getResponseCode();
	        log.info("responseCode : {}" , responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String line = "";
	        StringBuffer rsSb = new StringBuffer();
	        while ((line = br.readLine()) != null) {
	            rsSb.append(line);
	        }
	        String result = rsSb.toString();
	        log.info(result);
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

}
