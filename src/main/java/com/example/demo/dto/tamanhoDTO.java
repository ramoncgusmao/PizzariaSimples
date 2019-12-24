package com.example.demo.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class tamanhoDTO {

	@NotNull(message = "necessario adicionar o tamanho")
	private String tamanho;
	
}
