package com.mongo.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {


    private final SimpleConfigurationMongoDbProvider simpleConfigurationMongoDbProvider;

    public MongoConfig(SimpleConfigurationMongoDbProvider simpleConfigurationMongoDbProvider) {
        this.simpleConfigurationMongoDbProvider = simpleConfigurationMongoDbProvider;
    }


    @Override
    protected String getDatabaseName() {
        return simpleConfigurationMongoDbProvider.getDataBaseName();
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(simpleConfigurationMongoDbProvider.getMongoDbConnectionString());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.mongo");
    }
}
