package com.mayara.spring.processor;


import com.mayara.spring.dominio.Cliente;
import org.springframework.batch.item.ItemProcessor;

public class ClienteProcessor implements ItemProcessor<Cliente, Cliente> {


  @Override
  public Cliente process(Cliente cliente) throws Exception {
    System.out.println(String.format("\n Aplicando regras de negócio no cliente %s", cliente.getEmail()));
    return cliente;

  }
}
