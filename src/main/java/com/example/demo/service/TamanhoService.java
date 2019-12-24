package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.error.RegistroNaoEncontrado;
import com.example.demo.model.Tamanho;
import com.example.demo.repository.TamanhoRepository;

public class TamanhoService {

	@Autowired
	private TamanhoRepository repository;

	public Tamanho salvar(Tamanho tamanho) {

		return repository.save(tamanho);
	}

	public List<Tamanho> findAll() {

		return repository.findAll();
	}

	public Tamanho findById(int idTamanho) {

		Optional<Tamanho> tamanho = repository.findById(idTamanho);

		if (tamanho.isPresent()) {
			return tamanho.get();
		}
		throw new RegistroNaoEncontrado("não existe tamanho com id = " + idTamanho);
	}

}
