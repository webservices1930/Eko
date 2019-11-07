package co.edu.javeriana.eko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.eko.iservice.ITestService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class TestServicesController {

	@Autowired
	ITestService testService;

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String test() {

		return testService.testAplication();
	}
}
