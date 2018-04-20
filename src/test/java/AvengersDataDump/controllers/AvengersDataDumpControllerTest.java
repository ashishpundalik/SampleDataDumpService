package AvengersDataDump.controllers;

import AvengersDataDump.models.Avenger;
import AvengersDataDump.models.Avengers;
import AvengersDataDump.services.AvengersDataDumpService;
import builders.AvengerBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AvengersDataDumpControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AvengersDataDumpController avengersDataDumpController;

    @Mock
    private AvengersDataDumpService avengersDataDumpServiceMock;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(avengersDataDumpController).build();
    }

    @Test
    public void shouldReturnAllTheAvengers() throws Exception {
        AvengerBuilder avengerBuilder = new AvengerBuilder();
        Avenger testAvenger = avengerBuilder.build();

        Avengers testAvengers = new Avengers();
        testAvengers.setAvengers(asList(testAvenger));

        when(avengersDataDumpServiceMock.getAllAvengers()).thenReturn(testAvengers);

        mockMvc.perform(get("/avengers/all"))
                .andExpect(status().isOk())
                .andExpect(content().json(testAvengers.toString()));
    }
}