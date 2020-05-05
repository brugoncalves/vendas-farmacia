package br.com.farmacia;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.farmacia.api.repositories.CategoriaRepository;
import br.com.farmacia.api.repositories.ProdutoRepository;
import br.com.farmacia.entities.Categoria;
import br.com.farmacia.entities.Produto;

@SpringBootApplication
public class VendasFarmaciaApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasFarmaciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Categoria cat1 = new Categoria(null, "Medicamentos");
		Categoria cat2 = new Categoria(null, "Genéricos");
		Categoria cat3 = new Categoria(null, "Saúde");
		Categoria cat4 = new Categoria(null, "Beleza");
		Categoria cat5 = new Categoria(null, "Dermocosméticos");
		Categoria cat6 = new Categoria(null, "Cuidados diários");
		Categoria cat7 = new Categoria(null, "Infantil");
		
		
		Produto p1 = new Produto(null, "Batom hidratante", 27.00);
		Produto p2 = new Produto(null, "Fralda RN", 30.00);
		Produto p3 = new Produto(null, "Anticonceptional", 34.00);
		Produto p4 = new Produto(null, "Protetor Solar PS 50", 53.00);
		Produto p5 = new Produto(null, "Anticoagulante GN", 200.00);
		Produto p6 = new Produto(null, "Desodorante Spray", 18.00);
		Produto p7 = new Produto(null, "Polivitamínico", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p3, p5));
		cat2.getProdutos().addAll(Arrays.asList(p5));
		cat3.getProdutos().addAll(Arrays.asList(p7));
		cat4.getProdutos().addAll(Arrays.asList(p1, p4));
		cat5.getProdutos().addAll(Arrays.asList(p4));
		cat6.getProdutos().addAll(Arrays.asList(p6, p4));
		cat7.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat4));
		p2.getCategorias().addAll(Arrays.asList(cat7));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat4, cat5, cat6));
		p5.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p6.getCategorias().addAll(Arrays.asList(cat6));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		
	}

}
