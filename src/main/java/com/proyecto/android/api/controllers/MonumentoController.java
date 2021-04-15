package com.proyecto.android.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.proyecto.android.api.entities.Monumento;
import com.proyecto.android.api.repository.MonumentoRepository;

@RestController
public class MonumentoController {

	@Autowired
	MonumentoRepository monumentoRepository;

	MonumentoController(MonumentoRepository repository) {
		this.monumentoRepository = repository;
	}

	// Aggregate root
	// tag::get-aggregate-root[]
	@CrossOrigin
	@GetMapping("/monumentos")
	List<Monumento> all() {
		return monumentoRepository.findAll();
	}
	
}
