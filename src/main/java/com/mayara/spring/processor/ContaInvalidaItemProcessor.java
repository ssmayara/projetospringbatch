package com.mayara.spring.processor;

import com.mayara.spring.dominio.Cliente;
import com.mayara.spring.dominio.Conta;
import org.springframework.batch.item.ItemProcessor;

public class ContaInvalidaItemProcessor implements ItemProcessor<Cliente, Conta> {

  @Override
  public Conta process(Cliente cliente) throws Exception {
    Conta conta = new Conta();
    conta.setClienteId(cliente.getEmail());
    return conta;
  }
}
