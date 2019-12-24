package com.example.demo.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PrecoDTO {

	@NotNull
	private int idTamanho;
	
	@DecimalMin(value = "0.0", inclusive = false)
	private BigDecimal preco;
}
