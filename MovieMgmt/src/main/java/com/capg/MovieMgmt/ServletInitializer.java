package com.capg.MovieMgmt;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializer extends SpringApplicationBuilder{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MovieShowManagementApplication.class);
	}

}
