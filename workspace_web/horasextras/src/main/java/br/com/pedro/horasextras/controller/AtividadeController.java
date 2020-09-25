package br.com.pedro.horasextras.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedro.horasextras.dao.AtividadeDAO;
import br.com.pedro.horasextras.model.Atividades;
@CrossOrigin("*")
@RestController
public class AtividadeController {
	
	//
	
	@Autowired
	AtividadeDAO dao;


	@GetMapping("/atividades")
	public ArrayList<Atividades> buscarTodas(){
		ArrayList<Atividades> lista;
		lista = (ArrayList<Atividades>)dao.findAll();
		return lista;
	}
}
