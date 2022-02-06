package ftn.eObrazovanjeProjekat.EObrazivanjeProjekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import ftn.eObrazovanjeProjekat.EObrazivanjeProjekat.security.SecurityConfiguration;

@SpringBootApplication
public class EObrazivanjeProjekatApplication {

	public static void main(String[] args) {
		SpringApplication.run(EObrazivanjeProjekatApplication.class, args);
	}

}