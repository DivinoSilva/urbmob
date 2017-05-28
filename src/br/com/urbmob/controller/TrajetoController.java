package br.com.urbmob.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.urbmob.dao.TrajetoDao;
import br.com.urbmob.model.Rota;
import br.com.urbmob.model.Trajeto;
import br.com.urbmob.to.TrajetoTo;

@RestController
public class TrajetoController {
	
	@Autowired
	TrajetoDao trajetoDao;
	
	@Autowired
	TrajetoTo trajetoTo;


	@RequestMapping(value = "/trajeto", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Trajeto> listar() {
		return trajetoDao.listar();
	}
	
	@RequestMapping(value="/trajeto", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Rota>> inserir(@RequestBody Trajeto trajeto){
		try {
			
			List<Rota> rotasGeradas = new ArrayList<Rota>();
			rotasGeradas= trajetoTo.gerarCaminhos(trajeto);
			System.out.println("Lat ini:" +trajeto.getLatIni());
			System.out.println("Long ini:" +trajeto.getLongIni());
			System.out.println("Lat Fim:" +trajeto.getLatFim());
			System.out.println("Long ini:" +trajeto.getLongIni());
//			trajetoDao.inserir(trajeto);
			URI location = new URI("/trajeto/"+trajeto.getId()); //Cria o URI	
			return ResponseEntity.created(location).body(rotasGeradas);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
