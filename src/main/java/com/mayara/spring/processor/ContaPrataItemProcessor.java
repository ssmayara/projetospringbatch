package com.mayara.spring.processor;

import com.mayara.spring.dominio.Cliente;
import com.mayara.spring.dominio.Conta;
import com.mayara.spring.dominio.TipoConta;
import org.springframework.batch.item.ItemProcessor;

public class ContaPrataItemProcessor implements ItemProcessor<Cliente, Conta> {

	@Override
	public Conta process(Cliente cliente) throws Exception {
		Conta conta = new Conta();
		conta.setClienteId(cliente.getEmail());
		conta.setTipo(TipoConta.PRATA);
		conta.setLimite(500.0);
		return conta;
	}

}
