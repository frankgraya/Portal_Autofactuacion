package com.autoporfact.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class PortalAutofacturacionApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PortalAutofacturacionApplication.class, args);
	}

	// El paquete de guía de ruta para configurar archivos de recursos estáticos aquí se importa directamente de forma predeterminada.


}
