/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.cibertec.web;

import java.util.ArrayList;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.cibertec.Dao.PersonaDao;
import pe.com.cibertec.domain.Persona;
import pe.com.cibertec.servicio.PersonaService;

/**
 *
 * @author jaimePC
 */

//@RestController
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
  
    private PersonaService personaService;
    
    
    @GetMapping("/")
    public String inicio(Model model , @AuthenticationPrincipal User user){
        
        
        var personas = personaService.listarPersonas();
       
        log.info("ejecutando el controlador spring MVC");
        log.info("Usuario que hizo login" + user);

        model.addAttribute("personas" , personas) ;



            return "index";
    }
    
    
    
    
    @GetMapping("/agregar")
    public String agregar(Persona persona){
    
    return "modificar";
    }
    
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        
        if (errores.hasErrors()) {
            return "modificar";
        }
        
        
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
    
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona" , persona);
        
        return "modificar";
    }
    
    
    
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    
}
