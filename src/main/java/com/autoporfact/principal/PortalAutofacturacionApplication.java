package com.autoporfact.principal;

import com.autoporfact.principal.model.Mail;
import com.autoporfact.principal.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.autoporfact"
})
public class PortalAutofacturacionApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(PortalAutofacturacionApplication.class, args);
	}

	// El paquete de guía de ruta para configurar archivos de recursos estáticos aquí se importa directamente de forma predeterminada.
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").resourceChain(false);
		registry.addResourceHandler("/json/**").addResourceLocations("/json/").resourceChain(false);
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").resourceChain(false);
		registry.addResourceHandler("/fragments/**").addResourceLocations("/fragments/").resourceChain(false);
		registry.addResourceHandler("/resources/**", "/css/**")
				.addResourceLocations("/WEB-INF/resources/", "/WEB-INF/css/");
		super.addResourceHandlers(registry);

	}


}
