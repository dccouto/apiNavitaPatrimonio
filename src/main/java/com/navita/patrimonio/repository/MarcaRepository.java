package com.navita.patrimonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.navita.patrimonio.entities.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	boolean existsByNomeIgnoreCase(String nome);

	
}
