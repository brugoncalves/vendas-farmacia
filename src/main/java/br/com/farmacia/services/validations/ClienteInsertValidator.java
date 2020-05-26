package br.com.farmacia.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.farmacia.entities.Cliente;
import br.com.farmacia.entities.dto.ClienteNewDto;
import br.com.farmacia.entities.enums.TipoCliente;
import br.com.farmacia.repositories.ClienteRepository;
import br.com.farmacia.resources.exceptions.FieldMessage;
import br.com.farmacia.services.validations.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	 @Override
	 public void initialize(ClienteInsert ann) {
		 
	 }
	 
	 @Override
	 public boolean isValid(ClienteNewDto objDto, ConstraintValidatorContext context) {
	 List<FieldMessage> list = new ArrayList<>();

	if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
		list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
	}
	
	if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
		list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
	}
	
	Cliente aux = clienteRepository.findByEmail(objDto.getEmail());
	
	if(aux != null) {
		list.add(new FieldMessage("email", "Email já cadastrado"));
	}

	 for (FieldMessage e : list) {
	 context.disableDefaultConstraintViolation();
	 context.buildConstraintViolationWithTemplate(e.getMessage())
	 .addPropertyNode(e.getFieldName()).addConstraintViolation();
	 }
	 return list.isEmpty();
	 }
	}