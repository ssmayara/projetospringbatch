package com.mayara.spring.step;

import com.mayara.spring.dominio.GrupoLancamento;
import com.mayara.spring.reader.GrupoLancamentoReader;
import com.mayara.spring.writer.DemonstrativoOrcamentarioRodape;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemonstrativoOrcamentarioStepConfig {

  @Autowired
  public StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step demonstrativoOrcamentarioStep(
      // Esse aqui lê dos arquivos
      //MultiResourceItemReader<GrupoLancamento> demonstrativoOrcamentarioReader,
      // Esse aqui lê do banco de dados
      GrupoLancamentoReader demonstrativoOrcamentarioReader,
      ItemWriter<GrupoLancamento> demonstrativoOrcamentarioWriter,
      DemonstrativoOrcamentarioRodape rodapeCallback) {
    return stepBuilderFactory
        .get("demonstrativoOrcamentarioStep")
        .<GrupoLancamento, GrupoLancamento>chunk(100)
        .reader(demonstrativoOrcamentarioReader)
        .writer(demonstrativoOrcamentarioWriter)
        .listener(rodapeCallback)
        .build();
  }
}
