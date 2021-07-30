package com.mayara.spring.dominio;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Cliente {

  @NotNull
  @Size(min=1, max=100)
  //@Pattern(regexp="[a-zA-Z\\s]+", message = "Nome deve ser alfabetico")
  private String nome;
  @NotNull
  @Range(min = 18, max=200)
  private String idade;
  @NotNull
  @Size(min=1, max=50)
  private String email;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "nome='" + nome + "'" +
        ", idade='" + idade + "'" +
        ", email='" + email + "'" +
        '}';
  }
}
