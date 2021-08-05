package com.mayara.spring.processor;

import com.mayara.spring.dominio.Cliente;
import com.mayara.spring.dominio.Conta;
import com.mayara.spring.dominio.TipoConta;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;


@SuppressWarnings("serial")
public class GeracaoContaClassifier implements Classifier<Cliente, ItemProcessor<?, ? extends Conta>> {
	// Padrão de projeto para evitar o uso de if's no classificador.
	private static final Map<TipoConta, ItemProcessor<Cliente, Conta>> processadores = new HashMap<TipoConta, ItemProcessor<Cliente, Conta>>() {{
		put(TipoConta.PRATA, new ContaPrataItemProcessor());
		put(TipoConta.OURO, new ContaOuroItemProcessor());
		put(TipoConta.PLATINA, new ContaPlatinaItemProcessor());
		put(TipoConta.DIAMANTE, new ContaDiamanteItemProcessor());
		put(TipoConta.INVALIDA, new ContaInvalidaItemProcessor());
	}};

	@Override
	public ItemProcessor<Cliente, Conta> classify(Cliente cliente) {
		TipoConta tipoConta = TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial());
		return processadores.get(tipoConta);
	}

}
