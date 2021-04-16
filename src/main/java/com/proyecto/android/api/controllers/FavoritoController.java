package com.proyecto.android.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.android.api.entities.Favorito;
import com.proyecto.android.api.entities.Monumento;
import com.proyecto.android.api.repository.FavoritoRepository;
import com.proyecto.android.api.repository.MonumentoRepository;

@RestController
public class FavoritoController {

	@Autowired
	FavoritoRepository favoritoRepository;

	FavoritoController(FavoritoRepository repository) {
		this.favoritoRepository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	
	@GetMapping("/favoritos")
	List<Favorito> all() {
		return favoritoRepository.findAll();
	}
}
