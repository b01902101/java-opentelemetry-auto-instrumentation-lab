package net.smkz.springbootpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	@Bean
	public OpenAPI configureOpenAPI() {
		return new OpenAPI()
				.info(getInfo());
	}
	
	private Info getInfo() {
		Info info = new Info();
		info.setTitle("JVM Monitoring Lab");
		info.setDescription("JVM Monitoring Lab");
		info.setVersion("0.0.1");
		
		return info;
	}
}
