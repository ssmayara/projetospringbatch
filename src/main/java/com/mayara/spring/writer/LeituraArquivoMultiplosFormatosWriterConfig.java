package com.mayara.spring.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoMultiplosFormatosWriterConfig {

  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public ItemWriter leituraArquivoMultiplosFormatosWriter() {
    return items -> items.forEach(System.out::println);
//    return items -> {
//      for(Cliente cliente : items){
//        if (cliente.getNome().equals("Maria"))
//          throw new Exception();
//        else {
//          System.out.println(cliente);
//        }
//      }
//    };
  }
}
