package com.mayara.spring.step;

import com.mayara.spring.dominio.Cliente;
import com.mayara.spring.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class LeituraArquivoMultiplosFormatosStepConfig {
  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @SuppressWarnings({"rawtypes", "unchecked"})
  @Bean
  public Step leituraArquivoMultiplosFormatosStep(
      MultiResourceItemReader<Cliente> multiplosArquivosClienteTransacaoReader,
      ItemWriter leituraArquivoMultiplosFormatosItemWriter) {
    return stepBuilderFactory
        .get("leituraArquivoMultiplosFormatosStep")
        .chunk(1)
        .reader(multiplosArquivosClienteTransacaoReader)
        .writer(leituraArquivoMultiplosFormatosItemWriter)
        .build();
  }
}