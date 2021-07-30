package com.mayara.spring.processor;

import com.mayara.spring.dominio.Cliente;
import java.util.HashSet;
import java.util.Set;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessadorValidacaoProcessorConfig {

  private Set<String> emails = new HashSet<>();

  @Bean
  public ItemProcessor<Cliente, Cliente> processadorValidacaoProcessor() {
//    BeanValidatingItemProcessor<Cliente> processor = new BeanValidatingItemProcessor<>();
//    processor.setFilter(true);
    ValidatingItemProcessor<Cliente> processor = new ValidatingItemProcessor<>();
    processor.setValidator(validator());
    processor.setFilter(true);
    return processor;

  }

  private Validator<Cliente> validator() {
    return new Validator<Cliente>() {
      @Override
      public void validate(Cliente cliente) throws ValidationException {
        if(emails.contains(cliente.getEmail()))
          throw new ValidationException(String.format("O cliente %s já foi processado!" , cliente.getEmail()));
        emails.add(cliente.getEmail());
      }
    };
  }

}
