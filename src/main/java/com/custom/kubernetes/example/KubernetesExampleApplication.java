package com.custom.kubernetes.example;

import com.custom.kubernetes.example.config.CustomConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/kubernetes/")
public class KubernetesExampleApplication {

	private static final Logger logger = LoggerFactory.getLogger(KubernetesExampleApplication.class);

	@Autowired
	private CustomConfiguration customConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(KubernetesExampleApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void afterStartup() {

		logger.info("SpringBoot Application Started : Now doing custom Configuration ");

		setResponse(new CustomResponse(customConfiguration.getUsername(),customConfiguration.getPwd()));
		logger.info(" Get configuration info from Kubernetes And Set into one Inner Class."+response.toString());

	}

	@GetMapping("/getConfig")
	public CustomResponse getConfig(){
		return response;
	}

	public CustomResponse getResponse() {
		return response;
	}

	public void setResponse(CustomResponse response) {
		this.response = response;
	}

	private CustomResponse response;



	private  class CustomResponse {
	String username;
	String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public CustomResponse(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public CustomResponse() {
		}

		@Override
		public String toString() {
			return "CustomResponse{" +
					"username='" + username + '\'' +
					", password='" + password + '\'' +
					'}';
		}
	}
}
