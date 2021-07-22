package com.mayara.spring.writer;

import com.mayara.spring.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosWriterConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public ItemWriter leituraArquivoMultiplosFormatosWriter() {
    return items -> items.forEach(System.out::println);
  }
}
