package org.example;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class UserBehaviorCsvFileReader implements Supplier<Weather> {

    private final String filePath;
    private CsvReader csvReader;

    public UserBehaviorCsvFileReader(String filePath) throws IOException {

        this.filePath = filePath;
        try {
            csvReader = new CsvReader(filePath);
            csvReader.readHeaders();
        } catch (IOException e) {
            throw new IOException("Error reading TaxiRecords from file: " + filePath, e);
        }
    }

    @Override
    public Weather get() {
        Weather userBehavior = null;
        try{
            if(csvReader.readRecord()) {

                String[] s = csvReader.getValues();
                userBehavior = new Weather(
                       csvReader.get(0),
                        csvReader.get(1),
                        csvReader.get(2),
                        csvReader.get(3),
                        csvReader.get(4),
                        csvReader.get(5),
                        csvReader.get(6),
                        csvReader.get(7),
                       csvReader.get(8),
                        csvReader.get(9),
                       csvReader.get(10),
                       csvReader.get(11),
                       csvReader.get(12),
                       csvReader.get(13),
                        csvReader.get(14),
                       csvReader.get(15),
                        csvReader.get(16),
                        csvReader.get(17),
                        csvReader.get(18),
                        csvReader.get(19),
                       csvReader.get(20),
                        csvReader.get(21)
                );
            }
        } catch (IOException e) {
            throw new NoSuchElementException("IOException from " + filePath);
        }

        if (null==userBehavior) {
            throw new NoSuchElementException("All records read from " + filePath);
        }

        return userBehavior;
    }
}
