package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tamanho")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tamanho {

	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "tamanho")
	private List<PrecoTamanho> precoTamanhos;
}
