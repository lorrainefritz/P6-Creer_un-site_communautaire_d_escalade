package com.openclassrooms.LesAmisDeLEscaladeApplication.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration

public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/home").setViewName("home");
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		Path climbingSiteUploadDir = Paths.get("./src/main/webapp/imagesAndLogos/images/imagesSiteEscalade/");
//		String climbingSiteUploadPath = climbingSiteUploadDir.toFile().getAbsolutePath();
//		registry.addResourceHandler("/src/main/webapp/imagesAndLogos/images/imagesSiteEscalade/**").addResourceLocations("file:/" + climbingSiteUploadPath + "/");
//	}

}
