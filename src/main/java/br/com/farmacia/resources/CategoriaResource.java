package br.com.farmacia.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmacia.entities.Categoria;
import br.com.farmacia.entities.dto.CategoriaDTO;
import br.com.farmacia.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping
	public ResponseEntity <List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
