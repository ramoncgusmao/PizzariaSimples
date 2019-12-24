package com.example.demo.resources;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PrecoDTO;
import com.example.demo.dto.SaborDTO;
import com.example.demo.model.PrecoTamanho;
import com.example.demo.model.Sabor;
import com.example.demo.model.Tamanho;
import com.example.demo.service.SaborService;
import com.example.demo.service.TamanhoService;

@RestController
@RequestMapping(value = "/api/sabor")
public class SaborResources {

	@Autowired
	private SaborService service;
	
	@Autowired
	private TamanhoService tamanhoService;
	
	@PostMapping
	private ResponseEntity salvar(@RequestBody @Valid SaborDTO dto) {
		
		try {
			Sabor sabor = converterDto(dto);
			sabor = service.salvar(sabor);
			return new ResponseEntity(sabor, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	private ResponseEntity buscar(@RequestParam("nome") String nome, @RequestParam("igredientes") String igrediente) {
		
		try {
			Sabor sabor = Sabor.builder().nome(nome).igredientes(igrediente).build();
			List<Sabor> sabores= service.listarSabores(sabor);
			return new ResponseEntity(sabores, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	private Sabor converterDto(@Valid SaborDTO dto) {
		
		List<PrecoTamanho> precosTamanhos = dto.getPreco().stream().map( preco ->  carregarPrecoTamanho(preco)).collect(Collectors.toList());
		
		return Sabor.builder()
					.nome(dto.getNome())
					.igredientes(dto.getIngredientes())
					.precoTamanhos(precosTamanhos)
					.build();
	}

	private PrecoTamanho carregarPrecoTamanho(PrecoDTO preco) {
		return  PrecoTamanho
									.builder()
									.tamanho(tamanhoService.findById(preco.getIdTamanho()))
									.preco(preco.getPreco()).build();
				
		
	}
}
