package com.proyecto.android.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.android.api.entities.Monumento;

public interface MonumentoRepository extends JpaRepository <Monumento, Integer>{
	
	List<Monumento> findByNombre(String nombre);
	
}
