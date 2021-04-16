package com.proyecto.android.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.android.api.entities.Favorito;

public interface FavoritoRepository extends JpaRepository <Favorito, Integer>{
	
}

