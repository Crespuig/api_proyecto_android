package com.proyecto.android.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.android.api.entities.Monumento;

public interface MonumentoRepository extends JpaRepository <Monumento, Integer>{
	
}
