package com.mayara.spring.writer;

import com.mayara.spring.dominio.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

  @StepScope
  @Bean
  public FlatFileItemWriter<Cliente> escritaArquivoLarguraFixaWriter(
      @Value("#{jobParameters['arquivoClientesSaida']}")
          Resource resource) {
    return new FlatFileItemWriterBuilder()
        .name("escritaArquivoLarguraFixaWriter")
        .resource(resource)
        .formatted()
        .format("%-9s %-9s %-2s %-19s")
        .names("nome", "Sobrenome", "idade", "email")
        .build();
  }
}