package com.gic.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gic.ems.common.type.Gender;
import com.gic.ems.service.impl.M04_ServiceImpl;
import com.gic.ems.web.model.M04_EmpCreateModel;

/**
 * The Class EmsApplication.
 *
 * @author KYIMINHAN Jan 5, 2019 <BR>
 *         The Class EmsApplication.
 */
@SpringBootApplication
public class EmsApplication implements CommandLineRunner {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String... args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	/** The service. */
	private M04_ServiceImpl service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M04_ServiceImpl service) {
		this.service = service;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		String email = "admin@gmail.com";
		if (!service.hasAccount(email)) {
			M04_EmpCreateModel empCreateModel = M04_EmpCreateModel.builder().email(email).firstName("KyiMin")
					.lastName("Han").firstNameKana("チミン").lastNameKana("ハン").gender(Gender.MALE).build();
			service.save(empCreateModel);
		}
	}
}