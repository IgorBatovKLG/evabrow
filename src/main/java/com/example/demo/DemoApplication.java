package com.example.demo;

import com.example.demo.Models.EvaReportModelList;
import com.example.demo.Services.GetEva;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		GetEva getEva = new GetEva();
		EvaReportModelList signatureExam = getEva.getSignatureExam();
		signatureExam.getTotal();
		SpringApplication.run(DemoApplication.class, args);

	}

}
