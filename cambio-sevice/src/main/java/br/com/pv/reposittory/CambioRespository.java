package br.com.pv.reposittory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pv.model.Cambio;


public interface CambioRespository extends JpaRepository<Cambio, Long> {

	
	Cambio findByFromAndTo(String form, String to); // Sql usando a coluna From e a coluna To

}
