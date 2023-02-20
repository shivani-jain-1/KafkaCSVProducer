package org.example;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;

import java.util.Properties;
import java.util.function.Consumer;

public class KafkaProducer implements Consumer<Weather> {

    private final String topic;
    private final org.apache.kafka.clients.producer.KafkaProducer<byte[], byte[]> producer;
    private final JsonSerializer serializer;

    public KafkaProducer(String kafkaTopic, String kafkaBrokers) {
        this.topic = kafkaTopic;
        this.producer = new org.apache.kafka.clients.producer.KafkaProducer<>(createKafkaProperties(kafkaBrokers));
        this.serializer = new JsonSerializer();
    }

    @Override
    public void accept(Weather record) {
        // Serialize the object into a byte array
        byte[] data = serializer.toJSONBytes(record);
        // package
        ProducerRecord<byte[], byte[]> kafkaRecord = new ProducerRecord<>(topic, data);
        // send
        producer.send(kafkaRecord);
        System.out.println("Message sent successfully");

        // Control the speed of messages through sleep, please adjust according to your own kafka configuration and flink server configuration
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Kafka configuration
     * @param brokers The brokers to connect to.
     * @return A Kafka producer configuration.
     */
    private static Properties createKafkaProperties(String brokers) {
        Properties kafkaProps = new Properties();
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getCanonicalName());
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class.getCanonicalName());
        return kafkaProps;
    }
}
