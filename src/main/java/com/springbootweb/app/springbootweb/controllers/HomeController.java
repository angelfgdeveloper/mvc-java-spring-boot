package com.springbootweb.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/") // Ruta inicial
  public String home() {
    // #1
    // Redireccionar a páginas externas
    // return "redirect:https://www.google.com"; // Para redireccionar al index

    // #2
    // return "redirect:/app/index"; // Para redireccionar al index o nueva ruta
    
    // #3
    // Se mantiene estatica => http://localhost:8081/
    // Rutas propias de spring
    return "forward:/app/index"; // Sin reiniciar y sin recargar la página
  }
  
}
