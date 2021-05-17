package com.proyecto.android.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.android.api.entities.Favorito;
import com.proyecto.android.api.entities.Monumento;
import com.proyecto.android.api.entities.Usuario;
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

	@GetMapping("/favoritos/usuario/{idUsuario}")
	List<Favorito> getFavoritosUsuario(@PathVariable int idUsuario) {
		List<Favorito> favoritos = favoritoRepository.findAll();
		List<Favorito> favoritosUsuario = new ArrayList<Favorito>();
		for (Favorito favorito : favoritos) {
			if (favorito.getUsuario().getId() ==idUsuario) {
				favoritosUsuario.add(favorito);
			}
		}
		return favoritosUsuario;
	}

	@PostMapping("/favoritos")
	public ResponseEntity<Favorito> anyadirFavoritoUsuario(@RequestBody Favorito fav) {
		return new ResponseEntity<Favorito>(favoritoRepository.save(fav), HttpStatus.OK);
	}
	
	@DeleteMapping("/favoritos/{idMonumento}/usuario/{idUsuario}")
	void borrarFavorito(@PathVariable int idMonumento, @PathVariable int idUsuario) {
		List<Favorito> favoritos = favoritoRepository.findAll();
		for (Favorito favorito : favoritos) {
			if (favorito.getUsuario().getId() == idUsuario && favorito.getMonumento().getIdnotes() == idMonumento) {
				favoritoRepository.deleteById(favorito.getId());
				break;
			}
		}

	}
}
