package br.com.farmacia.entities.enums;

public enum EstadoPagamento {

	PENDENTE(1),
	QUITADO(2),
	CANCELADO(3);
	
	int cod;
	
	private EstadoPagamento(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
	
}
