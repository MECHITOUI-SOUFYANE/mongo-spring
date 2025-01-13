package com.mongo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:mongo.properties")
public class SimpleConfigurationMongoDbProvider {
    @Value("${mongo.db.name}")
    private String dataBaseName;

    @Value("${mongo.db.url}")
    private String mongoDbConnectionString;

    public String getDataBaseName() {
        return dataBaseName;
    }

    public String getMongoDbConnectionString() {
        return mongoDbConnectionString;
    }
}
