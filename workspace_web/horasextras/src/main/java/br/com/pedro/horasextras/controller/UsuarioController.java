package br.com.pedro.horasextras.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.horasextras.dao.UsuarioDAO;
import br.com.pedro.horasextras.model.Usuario;

//vamos definir que a classe é RestController para expor URLs(nossa API)
@CrossOrigin("*")
@RestController
public class UsuarioController {

	// esse cara precisar acessar o banco
	/*
	 * Injeção de Dependencia AutoWired -
	 * 
	 */
	@Autowired
	private UsuarioDAO dao;

	@GetMapping("/usuarios")
	public ArrayList<Usuario> buscarTodos() {
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>) dao.findAll();
		return lista;
	}

	/*
	 * @PostMapping("/usuarios/login") public Usuario logarUsuario(@RequestBody
	 * Usuario dadosLogin) { Usuario resultado =
	 * dao.findByRacfAndSenha(dadosLogin.getRacf(), dadosLogin.getSenha()); return
	 * resultado;
	 */
	
	
	@PostMapping("/usuarios/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario dadosLogin) {
		Usuario res = dao.findByRacf(dadosLogin.getRacf());
		if (res != null) { 													//ele existe na base com o RACF informado"
				if (res.getSenha().equals(dadosLogin.getSenha())) {
					return ResponseEntity.ok(res); 						//retorno 200, com o objeto no corpo da resposta
				}
				else {
					return ResponseEntity.status(401).build();
				}
		}
		else {
			return ResponseEntity.notFound().build();
		}
			
		}
	
			

}
