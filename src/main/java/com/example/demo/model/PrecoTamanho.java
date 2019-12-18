package com.example.demo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "preco_tamanho")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PrecoTamanho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "id_sabor")
	private Sabor sabor;
	
	@ManyToOne
	@JoinColumn(name = "id_tamanho")
	private Tamanho tamanho;
	
}
