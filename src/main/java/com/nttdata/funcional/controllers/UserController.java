package com.nttdata.funcional.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.funcional.models.Usuario;

@RestController
public class UserController {

	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	
	public UserController() {
		listaUsuarios.add(new Usuario("Alin", "alin", "1234"));
		listaUsuarios.add(new Usuario("Juan", "juan", "1111"));
		listaUsuarios.add(new Usuario("Manuel", "manuel", "2222"));
	}
	
	@PostMapping(path="/login")
	public String login(String username, String password) {
		List<Usuario> usuario = listaUsuarios.stream().filter(usr -> (usr.getUsername().equals(username)) && (usr.getPassword().equals(password))).collect(Collectors.toList());
		return "Hola " + usuario.get(0).getNombre();
	}
	
}
