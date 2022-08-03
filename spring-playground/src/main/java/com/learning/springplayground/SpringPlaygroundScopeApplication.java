package com.learning.springplayground;

import com.learning.springplayground.Module01.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.learning.springplayground") // this is only required when there are multiple packages and you want to instruct the right package to be scan for components
public class SpringPlaygroundScopeApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringPlaygroundScopeApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringPlaygroundScopeApplication.class, args);

		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

		LOGGER.info("{}", personDAO);
		LOGGER.info("{}", personDAO.getJdbcConnection());

		LOGGER.info("{}", personDAO2);
		LOGGER.info("{}", personDAO2.getJdbcConnection());

	}

}




