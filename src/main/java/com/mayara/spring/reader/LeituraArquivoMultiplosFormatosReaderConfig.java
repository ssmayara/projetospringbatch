package com.mayara.spring.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoMultiplosFormatosReaderConfig {

  @StepScope
  @Bean
  public FlatFileItemReader arquivoMultiplosFormatosItemReader(
      @Value("#{jobParameters['arquivoClienteMultiplosFormatos']}") Resource arquivoClienteMultiplosFormatos, LineMapper lineMapper) {

    return new FlatFileItemReaderBuilder<>()
        .name("arquivoMultiplosFormatosItemReader")
        .resource(arquivoClienteMultiplosFormatos)
        .lineMapper(lineMapper)
        .build();
  }

}
