package br.com.farmacia.entities.enums;

public enum TipoCliente {

	PESSOAFISICA(1),
	PESSOAJURIDICA(2);
	
	private int cod;
	
	private TipoCliente(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())){
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido " + cod);
	}
}
