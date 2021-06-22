package br.com.pv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pv.service.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}
