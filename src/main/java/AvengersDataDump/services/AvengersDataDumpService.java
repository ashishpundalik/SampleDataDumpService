package AvengersDataDump.services;

import AvengersDataDump.models.Avengers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class AvengersDataDumpService {

    public Avengers getAllAvengers() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        File avengersJson = new File(classLoader.getResource("avengers.json").getFile());

        Avengers avengers = new ObjectMapper().readValue(avengersJson, Avengers.class);

        return avengers;
    }
}
