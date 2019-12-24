package com.example.demo.error;

import com.example.demo.model.Tamanho;

public class RegistroNaoEncontrado extends RuntimeException {

	public RegistroNaoEncontrado(String msg) {
		super(msg);
	}
}
