package com.mayara.spring.step;

import com.mayara.spring.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraDelimitadaStepConfig {

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step leituraArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoDelimitadoReader,
      ItemWriter<Cliente> LeituraArquivoLarguraDelimitadoWriter) {
    return stepBuilderFactory.get("leituraArquivoDelimitadoReader")
        .<Cliente, Cliente>chunk(1)
        .reader(leituraArquivoDelimitadoReader)
        .writer(LeituraArquivoLarguraDelimitadoWriter)
        .build();
  }

}
