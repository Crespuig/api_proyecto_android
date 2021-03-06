package com.proyecto.android.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.android.api.entities.Usuario;
import com.proyecto.android.api.exceptions.UserNotFoundException;
import com.proyecto.android.api.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	public UsuarioController(UsuarioRepository repository) {
		this.repository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@CrossOrigin
	@GetMapping("/usuarios")
	@ResponseBody
	public List<Usuario> all() {
		return repository.findAll();
	}
	// end::get-aggregate-root[]

	// Single item

	@GetMapping("/usuarios/{id}")
	@ResponseBody
	public Usuario one(@PathVariable int id) {
		return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@CrossOrigin
	@PutMapping("/usuarios/{id}")
	@ResponseBody
	Usuario actualizarUsuario(@RequestBody Usuario newUser, @PathVariable int id) {

		return repository.findById(id).map(user -> {
			user.setEmail(newUser.getEmail());
			user.setNombre(newUser.getNombre());
			user.setApellidos(newUser.getApellidos());
			user.setPassword(newUser.getPassword());
			return repository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return repository.save(newUser);
		});
	}

	@CrossOrigin
	@DeleteMapping("/usuarios/{id}")
	@ResponseBody
	public ResponseEntity<Usuario> borrarUsuario(@PathVariable int id) {
		final String USER_EMAIL = "admin@admin.es";
		Optional<Usuario> userFromDatabase = repository.findById(id);
		if (userFromDatabase.isPresent()) {
			if (userFromDatabase.get().getEmail().equals(USER_EMAIL)) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@CrossOrigin
	@PostMapping("/usuarios/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario user) {

		Usuario userInDatabase = repository.findByEmail(user.getEmail())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Login incorrecto"));
		if (!userInDatabase.getPassword().equals(user.getPassword())) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Login incorrecto");

		}
		return new ResponseEntity<Usuario>(userInDatabase, HttpStatus.OK);
	}

	// @PostMapping("/usuarios/registro")

	@PostMapping("/usuarios/registro")
	public ResponseEntity<Usuario> registrar(@RequestBody Usuario user) {
		return new ResponseEntity<Usuario>(repository.save(user), HttpStatus.OK);
	}

	public Optional<Usuario> buscarPorEmal(String email) {
		return repository.findByEmail(email);
	}

}
