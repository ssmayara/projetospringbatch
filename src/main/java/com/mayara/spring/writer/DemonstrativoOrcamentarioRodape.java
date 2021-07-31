package com.mayara.spring.writer;

import com.mayara.spring.dominio.GrupoLancamento;
import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.List;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

@Component
public class DemonstrativoOrcamentarioRodape implements
    FlatFileFooterCallback {

  private Double totalGeral = 0.0;

  @Override
  public void writeFooter(Writer writer) throws IOException {
    writer.append("\n");
    writer.append(String.format("\t\t\t\t\t\t\t  Total: %s",
        NumberFormat.getCurrencyInstance().format(totalGeral)));
    writer.append(
        String.format("\t\t\t\t\t\t\t  Código de Autenticação: %s", "fkyew6868fewjfhjjewf"));
  }

  @BeforeWrite
  public void beforWrite(List<GrupoLancamento> grupos){
    for (GrupoLancamento grupoLancamento : grupos
    ) { totalGeral += grupoLancamento.getTotal();

    }
  }
}
