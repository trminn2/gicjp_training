package com.gic.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gic.ems.common.type.Role;
import com.gic.ems.entity.User;
import com.gic.ems.service.M01_Service;

@SpringBootApplication
public class EmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}

	// TODO to delete after developing phase
	@Autowired
	private M01_Service service;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public void run(String... args) throws Exception {
		if (null == this.service.findByEmail("admin@gmail.com")) {
			this.service.save(User.builder().email("admin@gmail.com").password(this.encoder.encode("admin"))
					.role(Role.ADMIN).build());
		}
	}
}