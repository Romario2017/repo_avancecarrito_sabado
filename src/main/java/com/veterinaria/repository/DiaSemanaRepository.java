package com.veterinaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.entity.DiaSemana;

public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Integer> {

	@Query("Select ds from DiaSemana ds")
	public abstract List<DiaSemana> listaDiaSemana();

}