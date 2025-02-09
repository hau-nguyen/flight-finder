package com.flight.application.controller;

import com.flight.application.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/count")
    public String countFlightForm() {
        return "count-form";
    }

    @PostMapping("/count")
    public String countFlightResult(
            @RequestParam(name="flight-string", required=false) String flightString,
            Model model
    ) {
        model.addAttribute("count", flightService.countFlight(flightString));
        return "count-result";
    }
}