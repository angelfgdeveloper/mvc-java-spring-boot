package com.springbootweb.app.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

// Volver ejecutar para que se muestren los datos correctamente
@Configuration
@PropertySources({
  @PropertySource("classpath:textos.properties") // Agregamos nuestros propies properties
  // @PropertySource("classpath:textos.properties"),
})
public class TextosPropertiesConfig {
  
}
