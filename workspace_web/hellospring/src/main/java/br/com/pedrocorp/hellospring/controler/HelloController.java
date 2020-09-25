package br.com.pedrocorp.hellospring.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrocrop.hellospring.model.Produto;

@RestController
public class HelloController {
	
	//o GetMapping vai ser o caminho que indico após a URL, nesse caso http://localhost:8088/hello
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World from SpringBoot";
		
	}
	
	@GetMapping("/produto")
	public Produto exibir() {
		Produto p= new Produto();
		p.setId(1234);
		p.setDescricao("Computador");
		p.setPreco(2000.0);
		p.setQtdeEstoque(3);
		
		return p;
	}


}
