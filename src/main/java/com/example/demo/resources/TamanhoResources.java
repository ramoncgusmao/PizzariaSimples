package com.example.demo.resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.tamanhoDTO;
import com.example.demo.model.Tamanho;
import com.example.demo.service.TamanhoService;

@RestController
@RequestMapping(value = "/api/tamanho")
public class TamanhoResources {

	@Autowired
	private TamanhoService service;

	@PostMapping
	public ResponseEntity salvar(@RequestBody @Valid tamanhoDTO dto) {

		try {
			Tamanho tamanho = converterDto(dto);
			tamanho = service.salvar(tamanho);
			return new ResponseEntity(tamanho, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity findAll() {

		try {
			List<Tamanho> lista = service.findAll();
			return new ResponseEntity(lista, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	private Tamanho converterDto(@Valid tamanhoDTO dto) {

		return Tamanho.builder().nome(dto.getTamanho()).build();
	}
}
