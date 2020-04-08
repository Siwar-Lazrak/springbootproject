package com.pfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PfeProjectPfeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfeProjectPfeApplication.class, args);
	}
	
	  @Bean
	  public CorsFilter corsFilter() { UrlBasedCorsConfigurationSource source
	  = new UrlBasedCorsConfigurationSource(); 
	  CorsConfiguration config = new
	  CorsConfiguration();
	  config.setAllowCredentials(true);
	  config.addAllowedOrigin("*"); 
	  config.addAllowedHeader("*");
	  config.addAllowedMethod("OPTIONS"); 
	  config.addAllowedMethod("GET");
	  config.addAllowedMethod("POST"); 
	  config.addAllowedMethod("PUT");
	  config.addAllowedMethod("DELETE"); source.registerCorsConfiguration("/**",config); 
	  return new CorsFilter(source); }
	 

}
