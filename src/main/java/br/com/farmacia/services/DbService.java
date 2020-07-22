package br.com.farmacia.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farmacia.entities.Categoria;
import br.com.farmacia.entities.Cidade;
import br.com.farmacia.entities.Cliente;
import br.com.farmacia.entities.Endereco;
import br.com.farmacia.entities.Estado;
import br.com.farmacia.entities.ItemPedido;
import br.com.farmacia.entities.Pagamento;
import br.com.farmacia.entities.PagamentoComBoleto;
import br.com.farmacia.entities.PagamentoComCartao;
import br.com.farmacia.entities.Pedido;
import br.com.farmacia.entities.Produto;
import br.com.farmacia.entities.enums.EstadoPagamento;
import br.com.farmacia.entities.enums.TipoCliente;
import br.com.farmacia.repositories.CategoriaRepository;
import br.com.farmacia.repositories.CidadeRepository;
import br.com.farmacia.repositories.ClienteRepository;
import br.com.farmacia.repositories.EnderecoRepository;
import br.com.farmacia.repositories.EstadoRepository;
import br.com.farmacia.repositories.ItemPedidoRepository;
import br.com.farmacia.repositories.PagamentoRepository;
import br.com.farmacia.repositories.PedidoRepository;
import br.com.farmacia.repositories.ProdutoRepository;

@Service
public class DbService {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemRepository;
	
	
	public void instantiateTestDatabase() throws ParseException {
		

		Categoria cat1 = new Categoria(null, "Medicamentos");
		Categoria cat2 = new Categoria(null, "Genéricos");
		Categoria cat3 = new Categoria(null, "Saúde");
		Categoria cat4 = new Categoria(null, "Beleza");
		Categoria cat5 = new Categoria(null, "Dermocosméticos");
		Categoria cat6 = new Categoria(null, "Cuidados diários");
		Categoria cat7 = new Categoria(null, "Infantil");
		
		
		Produto p1 = new Produto(null, "Batom hidratante", 27.00);
		Produto p2 = new Produto(null, "Fralda RN", 30.00);
		Produto p3 = new Produto(null, "Anticoncepcional", 34.00);
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
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Franca", est1);
		Cidade cid3 = new Cidade(null, "Uberaba", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "José Mattos", "jose@gmail.com", "11122233344", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("16 37205555", "16 983001000"));
		Cliente cli2 = new Cliente(null, "Maria Diniz", "maria@gmail.com", "22233344455", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("35 993658888"));
		Cliente cli3 = new Cliente(null, "Laranja Lima S/A", "laranjalima@gmail.com", "010895411000236", TipoCliente.PESSOAJURIDICA);
		cli3.getTelefones().addAll(Arrays.asList("11 36020000"));
		
		Endereco end1 = new Endereco(null, "Avenida Paulista", "3000", "Sala 31", "Bela Vista", "25000000", cli3, cid1);
		Endereco end2 = new Endereco(null, "Rua Chile", "1500", null, "Jardim Consolação", "14403000", cli1, cid2);
		Endereco end3 = new Endereco(null, "Avenida Brasil", "200", null, "Centro", "352000000", cli2, cid3);
		
		cli1.getEnderecos().addAll(Arrays.asList(end2));
		cli2.getEnderecos().addAll(Arrays.asList(end3));
		cli3.getEnderecos().addAll(Arrays.asList(end1));
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("11/05/2020 13:04"), cli3, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("12/05/2020 09:35"), cli1, end2);
		
		Pagamento pgto1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped1, sdf.parse("20/05/2020 00:00"), null);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped2, 4);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped2));
		cli3.getPedidos().addAll(Arrays.asList(ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));
		
		ItemPedido it1 = new ItemPedido(ped1, p6, 30.00, 18, 17.00);
		ItemPedido it2 = new ItemPedido(ped1, p4, 50.00, 30, 39.00);
		ItemPedido it3 = new ItemPedido(ped2, p2, 2.50, 3, 35.00);
		
		ped1.getItens().addAll(Arrays.asList(it1, it2));
		ped2.getItens().addAll(Arrays.asList(it3));
		
		itemRepository.saveAll(Arrays.asList(it1, it2, it3));			
		
	
	}
}
