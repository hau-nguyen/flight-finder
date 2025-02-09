package com.flight.application;

import com.flight.application.service.FlightService;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FlightServiceTest {

    @Test
    public void countFlight() {
        FlightService flightService = new FlightService();
        assertThat(flightService.countFlight(null), equalTo(0));
        assertThat(flightService.countFlight(""), equalTo(0));
        assertThat(flightService.countFlight("flight"), equalTo(1));
        assertThat(flightService.countFlight("lightf"), equalTo(1));
        assertThat(flightService.countFlight("flightflight"), equalTo(2));
        assertThat(flightService.countFlight("fflliigghhtt"), equalTo(2));
        assertThat(flightService.countFlight("lightfabc"), equalTo(1));
        assertThat(flightService.countFlight("abc"), equalTo(0));
        assertThat(flightService.countFlight("fff"), equalTo(0));
    }
}
