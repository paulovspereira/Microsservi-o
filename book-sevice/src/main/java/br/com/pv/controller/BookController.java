package br.com.pv.controller;

import java.util.Date;
import java.util.HashMap;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.pv.proxy.CambioProxy;
import br.com.pv.repository.BookRepository;
import br.com.pv.response.Cambio;
import br.com.pv.service.model.Book;

@RestController
@RequestMapping("book-service")
public class BookController {

	@Autowired
	private Environment enviroment;

	@Autowired
	private BookRepository repository;

	@Autowired
	private CambioProxy proxy;

	/*
	 * @GetMapping(value = "/{id}/{currency}") public Book
	 * getBook(@PathVariable("id") Long id, @PathVariable("currency") String
	 * currency) {
	 * 
	 * var book = repository.getById(id);
	 * 
	 * if (book == null) throw new RuntimeErrorException(null, "Book not fund");
	 * 
	 * HashMap<String, String> params = new HashMap<>(); params.put("amout",
	 * book.getPrice().toString()); params.put("from", "USD"); params.put("to",
	 * currency);
	 * 
	 * var response = new RestTemplate()
	 * .getForEntity("http://localhost:8000/cambio-service/" +
	 * "{amout}/{from}/{to}", Cambio.class, params);
	 * 
	 * var cambio = response.getBody();
	 * 
	 * var port = enviroment.getProperty("local.server.port");
	 * 
	 * book.setEnviroment(port); book.setPrice(cambio.getConvertedValue());
	 * 
	 * return book; }
	 */

	@GetMapping(value = "/{id}/{currency}")
	public Book getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {

		var book = repository.getById(id);

		if (book == null)
			throw new RuntimeErrorException(null, "Book not fund");

		HashMap<String, String> params = new HashMap<>();
		params.put("amout", book.getPrice().toString());
		params.put("from", "USD");
		params.put("to", currency);

		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

		var port = enviroment.getProperty("local.server.port");// consegue pegar proprieda do enviroments

		book.setEnviroment(port + " FEign");
		book.setPrice(cambio.getConvertedValue());

		return book;
	}
}
