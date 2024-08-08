package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.configuration.TwilionConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class OTPservice {
	
	@Autowired
	TwilionConfiguration twilioconfig;
	
	
	public void sendOtp(String mobileNo,String otp) {
		try {
		Message.creator(
				new PhoneNumber(mobileNo),
				new PhoneNumber(twilioconfig.getContactNo()),
				"your otp is "+otp
				).create();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}