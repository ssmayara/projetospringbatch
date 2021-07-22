package com.mayara.spring.step;

import com.mayara.spring.dominio.Cliente;
import com.mayara.spring.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step leituraArquivoMultiplosFormatostep(
      FlatFileItemReader arquivoMultiplosFormatosItemReader,
      ItemWriter leituraArquivoMultiplosFormatosWriter) {
    return stepBuilderFactory
        .get("leituraArquivoMultiplosFormatostep")
        .<Cliente, Cliente>chunk(1)
        .reader(new ArquivoClienteTransacaoReader(arquivoMultiplosFormatosItemReader))
        .writer(leituraArquivoMultiplosFormatosWriter)
        .build();
  }

}
