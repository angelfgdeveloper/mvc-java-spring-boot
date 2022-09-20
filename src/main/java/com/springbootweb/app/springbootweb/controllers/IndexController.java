package com.springbootweb.app.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbootweb.app.springbootweb.models.Usuario;

@Controller
@RequestMapping("/app") // Path inicial http://localhost:8081/app...
public class IndexController {

  // Para hacer referencias desde el "application.properties"
  @Value("${texto.indexcontroller.index.titulo}") // Llave creada 
  private String textoIndex;

  @Value("${texto.indexcontroller.perfil.titulo}")
  private String textoPerfil;

  @Value("${texto.indexcontroller.listar.titulo}")
  private String textoListar;

  // @RequestMapping(value = "/index", method = RequestMethod.GET)
  // @GetMapping(value = "/index")
  @GetMapping({ "", "/", "/index", "/home" })
  public ModelAndView index(
    Model model, 
    ModelMap modelMap,
    Map<String, Object> map,
    ModelAndView mv
  ) {
    // #1 pasar datos a la vista HTML
    model.addAttribute("titulo", textoIndex);
    // #2
    modelMap.addAttribute("welcome", "Bienvenidos!");

    // #3
    map.put("seccion", "Estamos en la primera sección del curso");

    // #4
    mv.addObject("name", "Luis Angel");
    mv.setViewName("index");
    return mv;
  }

  @RequestMapping("/perfil") // Por default es un GET
  public String perfil(Model model) {
    Usuario usuario = new Usuario();
    usuario.setNombre("Luis");
    usuario.setApellido("Angel");
    usuario.setEmail("angel@test.com");

    String titulo = textoPerfil.concat(usuario.getNombre());
    model.addAttribute("usuario", usuario);
    model.addAttribute("titulo", titulo);

    return "perfil";
  }

  @RequestMapping("/listar") // Por default es un GET
  public String listar(Model model) {
    // List<Usuario> usuarios = new ArrayList<>();
    // usuarios.add(new Usuario("Test", "Uno", "test1@test.com"));
    // usuarios.add(new Usuario("Test", "Dos", "test2@test.com"));
    // usuarios.add(new Usuario("Test", "Tres", "test3@test.com"));

    model.addAttribute("titulo", textoListar);
    // model.addAttribute("usuarios", usuarios);

    return "listar";
  }

  // Podemos reutilizarlo en cualquier Thymeleaf
  @ModelAttribute("usuarios")
  public List<Usuario> poblarUsuarios() {
     // Otra manera para agrupar arreglos
     List<Usuario> usuarios = Arrays.asList(
      new Usuario("Test", "Uno", "test1@test.com"),
      new Usuario("Test", "Dos", "test2@test.com"),
      new Usuario("Test", "Tres", "test3@test.com"),
      new Usuario("Test", "Cuatro", "test4@test.com"),
      new Usuario("Test", "Cinco", "test5@test.com")
    );

    return usuarios;
  }
  
}
