package com.copart.springboot2;

import com.copart.springboot2.model.Lot;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import reactor.core.publisher.Flux;

import java.time.Duration;

@SpringBootApplication
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(MongoOperations mongo) {
        return (String... args) -> {

            mongo.dropCollection(Lot.class);
            mongo.createCollection(Lot.class, CollectionOptions.empty().size(1000000).capped());

            Flux.range(1, 100)
                    .map(i -> new Lot("Ford","Mustang"+i, 2019-i,"New mustang coming next Year!"))
                    .doOnNext(mongo::save)
                    .blockLast(Duration.ofSeconds(5));
        };
    }
}
