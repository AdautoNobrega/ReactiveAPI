package com.reactive.project.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.function.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;

import com.reactive.project.reactive.repository.ItemRepository;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

/**
 * DatabaseConfiguration
 */
@Configuration
@EnableR2dbcRepositories
public class DatabaseConfiguration extends AbstractR2dbcConfiguration {

	@Override
	public PostgresqlConnectionFactory connectionFactory() {
		PostgresqlConnectionConfiguration config = PostgresqlConnectionConfiguration.builder().port(5432)
				.host("127.0.0.1").database("reactive").username("postgres").password("root").build();
		return new PostgresqlConnectionFactory(config);
	}

	@Bean
	public ItemRepository repository(R2dbcRepositoryFactory factory) {
		return factory.getRepository(ItemRepository.class);
	}

	@Bean
	public R2dbcRepositoryFactory factory(DatabaseClient client) {
		RelationalMappingContext context = new RelationalMappingContext();
		context.afterPropertiesSet();
		return new R2dbcRepositoryFactory(client, context,
				reactiveDataAccessStrategy(context, r2dbcCustomConversions()));
	}

	@Bean
	public DatabaseClient databaseClient(ConnectionFactory factory) {
		return DatabaseClient.builder().connectionFactory(factory).build();
	}

}