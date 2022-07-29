package com.ap.portfoil.PortfoilBracciale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PortfoilBraccialeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfoilBraccialeApplication.class, args);
	}
        
        @Configuration
        public class WebConfiguration implements WebMvcConfigurer {
                    @Override
                    public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**").allowedMethods("GET","PUT","POST","DELETE");
        }
                }

}
