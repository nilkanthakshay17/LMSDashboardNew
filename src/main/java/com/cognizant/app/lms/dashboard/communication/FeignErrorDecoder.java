//package com.cognizant.app.lms.dashboard.communication;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ResponseStatusException;
//
//import feign.Response;
//import feign.codec.ErrorDecoder;
//
//@Component
//public class FeignErrorDecoder implements ErrorDecoder{
//
//	@Override
//	public Exception decode(String methodKey, Response response) {
//		switch(response.status()) {
//		case 400:
//			break;
//		case 404:
//			return new ResponseStatusException(HttpStatus.valueOf(response.status()),response.reason());
//		}
//		return null;
//	}
//	
//}
