package com.mayara.spring.writer;

import com.mayara.spring.dominio.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {
  @Bean
  public ItemWriter<Cliente> leituraArquivoLarguraFixaWriter() {
    return items -> items.forEach(System.out::println);
  }
}
