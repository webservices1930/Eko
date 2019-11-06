package co.edu.javeriana.eko.service;

import org.springframework.stereotype.Service;

import co.edu.javeriana.eko.iservice.ITestService;


@Service
public class TestService implements  ITestService {

	@Override
	public String testAplication() {
		return "{\"value\": \"ok\"}";
	}

}
