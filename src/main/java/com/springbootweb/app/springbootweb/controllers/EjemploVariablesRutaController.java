package com.springbootweb.app.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {


  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");

    return "variables/index";
  }

  // Agregar la variable en la ruta
  // @PathVariable(name = "texto") => igual que el nombre de la ruta
  @GetMapping("/string/{texto}")
  public String variables(@PathVariable(name = "texto") String texto, Model model) {
    model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
    model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
    return "variables/ver"; // Ruta del html 
  }

  // Parametros con {...}
  @GetMapping("/string/{texto}/{numero}")
  public String variables(
    @PathVariable(name = "texto") String texto, 
    @PathVariable(name = "numero") String numero, 
    Model model
  ) {
    model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
    model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto 
    + " y el número enviado en el path es: " + numero);
    return "variables/ver"; // Ruta del html 
  }
  
}
