package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SaborDTO {

	@NotEmpty(message = "precisa do nome da pizza")
	private String nome;
	
	@NotEmpty(message = "precisa dos ingredientes da pizza")
	private String ingredientes;
	
	@NotNull(message = "precisa do preço das pizza")
	private List<PrecoDTO> preco = new ArrayList<PrecoDTO>();
	
}
