package com.mayara.spring.reader;

import com.mayara.spring.dominio.Cliente;
import javax.sql.DataSource;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Configuration
public class JdbcPagingReaderConfig {

  @Bean
  public JdbcPagingItemReader<Cliente> jdbcPagingReader(@Qualifier("appDataSource")DataSource dataSource, PagingQueryProvider pagingQueryProvider){
    return new JdbcPagingItemReaderBuilder<Cliente>()
        .name("jdbcPagingReader")
        .dataSource(dataSource)
        .queryProvider(pagingQueryProvider)
        .pageSize(1)
        .rowMapper(new BeanPropertyRowMapper<Cliente>(Cliente.class))
        .build();
  }

  @Bean
  public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("appDataSource") DataSource dataSource){
    SqlPagingQueryProviderFactoryBean queryProviderFactoryBean = new SqlPagingQueryProviderFactoryBean();
    queryProviderFactoryBean.setDataSource(dataSource);
    queryProviderFactoryBean.setSelectClause("select *");
    queryProviderFactoryBean.setFromClause("from cliente");
    queryProviderFactoryBean.setSortKey("email");

    return queryProviderFactoryBean;

  }

}
