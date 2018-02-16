package com.sistemasoee.test.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sistemasoee.test.beans.Usuario;
import com.sistemasoee.test.services.UsuarioService;
import com.sistemasoee.test.validation.UsuarioValidation;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/alta", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("usuarioData", new Usuario());
		return "alta/alta";
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("usuarioData") @Valid Usuario usuario, BindingResult br, HttpSession session) {
		UsuarioValidation usuarioValidation = new UsuarioValidation();
		usuarioValidation.validate(usuarioValidation, br);
		if (br.hasErrors()) {
			return "alta/alta";
		} else {
			usuarioService.altaUsuario(usuario);
			session.setAttribute("usuario", usuario);
			return "redirect:lista";
		}	
	}
	
	@RequestMapping(value = "/autenticacion", method = RequestMethod.GET)
	public String showLogin(ModelMap model, HttpSession session) {
		if(session.getAttribute("usuario")==null) {
			model.put("usuarioData", new Usuario());
			return "autenticacion/autenticacion";
		} else {
			return "redirect:lista";
		}
	}
	
	@RequestMapping(value = "/autenticacion", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("usuarioData") Usuario usuario, HttpSession session) {
		if(usuario.getEmail() != null && usuario.getContrasena() != null && session.getAttribute("usuario")==null) {
			usuario = usuarioService.autenticarUsuario(usuario);
			if(usuario!=null) {
				session.setAttribute("usuario", usuario);
				return "redirect:lista";
			} else {
				model.put("failed", "Inicio de Sesion Fallido");
				return "autenticacion/autenticacion";
			}
		} else {
			return "redirect:lista";
		}				
	}
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(ModelMap model, HttpSession session) {
		session.removeAttribute("usuario");
		return "redirect:autenticacion";		
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String showSuccess(ModelMap model) {
		model.put("lista", new Usuario());
		model.put("usuarioList", usuarioService.list());
		return "lista";		
	}
}
