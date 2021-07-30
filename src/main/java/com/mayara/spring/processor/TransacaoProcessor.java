package com.mayara.spring.processor;

import com.mayara.spring.dominio.Transacao;
import org.springframework.batch.item.ItemProcessor;

public class TransacaoProcessor implements ItemProcessor<Transacao, Transacao> {

  @Override
  public Transacao process(Transacao transacao) throws Exception {
    System.out.println(String.format("\n Aplicando regras de negócio na transacao %s", transacao.getId()));
    return transacao;
  }
}
