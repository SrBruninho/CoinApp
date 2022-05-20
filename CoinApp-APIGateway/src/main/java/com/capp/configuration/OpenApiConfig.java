package com.capp.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OpenApiConfig {
	
  @Bean
  @Lazy(false)
  public List<GroupedOpenApi> getApis( SwaggerUiConfigParameters p_swaggerConfig,
		  RouteDefinitionLocator p_routeDefLocator){
		
	  var definitions = p_routeDefLocator.getRouteDefinitions().collectList().block();
		
		definitions.stream().filter(
				routeDefinition -> routeDefinition.getId()
				.matches(".*"))
		        .forEach(routeDefinition ->{
		        	String name = routeDefinition.getId();
		        	p_swaggerConfig.addGroup(name);
		        	GroupedOpenApi.builder()
		        	.pathsToMatch("/"+ name + "/**")
		        	.group(name).build();
		        });		
		return new ArrayList<>();
  }

}
