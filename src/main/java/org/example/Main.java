package org.example;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // File address
        String filePath = "C:\\kafka_2.13-3.4.0\\tmp\\weather1.csv";
        // kafka topic
        String topic = "weather-topic";
        // Kafka borker address
        String broker = "localhost:9092";

        Stream.generate(new UserBehaviorCsvFileReader(filePath))
                .sequential()
                .forEachOrdered( new KafkaProducer(topic, broker));
    }
}