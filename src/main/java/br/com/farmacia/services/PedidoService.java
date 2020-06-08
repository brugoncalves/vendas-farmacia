package br.com.farmacia.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.farmacia.entities.ItemPedido;
import br.com.farmacia.entities.PagamentoComBoleto;
import br.com.farmacia.entities.Pedido;
import br.com.farmacia.entities.enums.EstadoPagamento;
import br.com.farmacia.repositories.ItemPedidoRepository;
import br.com.farmacia.repositories.PagamentoRepository;
import br.com.farmacia.repositories.PedidoRepository;
import br.com.farmacia.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemRepository;
	
	public Pedido findById(Long id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow( () -> new ObjectNotFoundException("Pedido não encontrado. ID: " + id
				+ ", Tipo: " + Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setData(new Date());
		obj.setCliente(clienteService.findById(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getData());
		}
		
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for (ItemPedido item : obj.getItens()) {
			item.setDesconto(0.00);
			item.setProduto(produtoService.findById(item.getProduto().getId()));
			item.setPreco(item.getProduto().getPreco());
			item.setPedido(obj);
		}
		
		itemRepository.saveAll(obj.getItens());
		return obj;
		
		
	}
}
