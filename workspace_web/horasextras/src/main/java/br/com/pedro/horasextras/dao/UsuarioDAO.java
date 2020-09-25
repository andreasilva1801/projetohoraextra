package br.com.pedro.horasextras.dao;

import org.springframework.data.repository.CrudRepository;


import br.com.pedro.horasextras.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	
	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByRacf(String racf);
		

}
