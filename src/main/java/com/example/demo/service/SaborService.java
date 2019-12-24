package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.example.demo.model.Sabor;
import com.example.demo.repository.SaborRepository;

public class SaborService {

	@Autowired
	private SaborRepository repository;
	
	public Sabor salvar(Sabor sabor) {
		
		return repository.save(sabor);
	}

	public List<Sabor> listarSabores(Sabor sabor) {
		
		Example example = Example.of(sabor, ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		
		return repository.findAll(example);
	
	}

}
