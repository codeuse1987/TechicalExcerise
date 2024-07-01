package com.example.exercise.cmn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.exercise.model.HttpResponseModel;


@Service
public class ResponsePacker {

	private static final Logger logger = LoggerFactory.getLogger(ResponsePacker.class);

	public ResponseEntity<?> processResult(Object body) {
		if (body instanceof Exception) {
			if (!(body instanceof ApplicationException)) {
				logger.error(((Exception) body).getMessage());
			}
			return this.processFailResult((Exception) body);
		}
		return this.processSuccessResult(body);
	}

	private ResponseEntity<?> processSuccessResult(Object body) {
		HttpResponseModel response = new HttpResponseModel();
		response.setResult(true);
		response.setBody(body);
		return ResponseEntity.ok(response);
	}

	private ResponseEntity<?> processFailResult(Exception e) {
		System.out.println(e.getClass());
		if (e instanceof ApplicationException) {
			HttpResponseModel response = new HttpResponseModel();
			response.setResult(false);
			response.setMsgCode(((ApplicationException) e).getErrCode());
			response.setMessage(((ApplicationException) e).getErrMsg());
			return ResponseEntity.ok(response);
		}
		return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
	}

}