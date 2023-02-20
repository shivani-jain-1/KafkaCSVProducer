package org.example;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;


import java.util.Properties;



public class KafkaStreamsDemo {

    public static final String INPUT_TOPIC = "weather-topic";

    public static final String OUTPUT_TOPIC = "weather-topic-output";

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "Example-Counter");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());


        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<Integer,String> kStream = streamsBuilder.stream(INPUT_TOPIC);
        kStream.foreach((k,v) -> System.out.println("key : " +k + "  "+"value : " +v));

        Topology topology =streamsBuilder.build();

        KafkaStreams streams =new KafkaStreams(topology,props);
        System.out.println("Staring Streams");
        streams.start();

        /*Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Shutting down Streams");
            streams.close();
        }));*/
        Thread.sleep(30000);
        streams.close();


    }
}