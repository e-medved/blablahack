package org.project.blablahack.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@ConfigurationProperties(locations = "classpath:mongodb.properties", ignoreUnknownFields = false, prefix = "mongodb")
public class SpringMongoConfig extends AbstractMongoConfiguration {

  private String url;
  private String database;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfig() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Override
  protected String getDatabaseName() {
    return database;
  }

  @Override
  public Mongo mongo() throws Exception {
    return new MongoClient(url);
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDatabase() {
    return database;
  }

  public void setDatabase(String database) {
    this.database = database;
  }
}
