package com.springbootweb.app.springbootweb.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

  @GetMapping("/")
  public String index() {
    return "params/index";
  }

  // http://localhost:8081/params/string?texto=hola
  // Obtener el params con RequestParam
  // Se puede usar el name o value
  @GetMapping("/string")
  public String param(
    @RequestParam(name = "texto", required = false, defaultValue = "Valor default..") String texto, 
    Model model
  ) {
    model.addAttribute("resultado", "EL texto enviado es: " + texto);
    return "params/ver";
  }

  @GetMapping("/mix-params")
  public String param(
    @RequestParam String saludo,
    @RequestParam Integer numero,
    Model model
  ) {
    model.addAttribute("resultado", "EL texto enviado es: '" + saludo + "' y el número es: '" + numero + "'");
    return "params/ver";
  }
  

  @GetMapping("/mix-params-request")
  public String param(
    HttpServletRequest request, // Manera para obtener datos por url (params)
    Model model
  ) {
    String saludo = request.getParameter("saludo"); // Asi lo obtenemos
    Integer numero = null;

    try {
      numero = Integer.parseInt(request.getParameter("numero"));
    } catch (Exception e) {
      numero = 0;
    }

    model.addAttribute("resultado", "EL texto enviado es: '" + saludo + "' y el número es: '" + numero + "'");
    return "params/ver";
  }
  
}
