package com.pallen.diary.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pallen.diary.entity.user.User;
import com.pallen.diary.entity.user.UserRepository;
import com.pallen.diary.service.UserService;
import com.pallen.diary.service.api.KakaoAPI;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserRepository userRepository;
	
	@Autowired
	private KakaoAPI kakaoAPI;

	@Override
	public void register(User user) {
		userRepository.save(user);
	}

	@Override
	public User get(String email) {
		return userRepository.findById(email).get();
	}
	@Override
	public User getByName(String name) {
		log.info(name);
		log.info(userRepository.findByName(name).toString());
		return userRepository.findByName(name).get(0);
	}
	@Override
	public boolean exist(String email, String name) {
		return userRepository.countByEmailOrName(email, name)>0;
	}

	@Override
	public Map<String, Object> snsLogin(String sns_key, Map<String, Object> paramInfo) {
		// TODO Auto-generated method stub
		Map<String ,Object> rs = getInfo(sns_key, paramInfo);
		if(rs == null) {
		rs = new HashMap<String, Object>();
		rs.put("email", "");
		} 
		log.info("email:{}",rs.get("email").toString());
			
		return getInfo(sns_key, paramInfo);
	}
	
	private Map<String, Object> getInfo(String sns_key, Map<String, Object> paramInfo) {
		switch (sns_key) {
		case "kakao":
			String code = (String)paramInfo.get("code");
			String access_Token = kakaoAPI.getAccessToken(code);
			Map<String, Object> rs = kakaoAPI.getUserInfo(access_Token);
			log.info("rs:{}",rs);
		    return rs;

		default:
			break;
		}
		return null;
	}
	
}
