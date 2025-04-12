package com.cp.qmeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@RestController
public class HomeController
{
    @RequestMapping("/")
    public String greeting()
    {
        return "Hello from qme";
    }

    @RequestMapping("/time")
    public String time()
    {
        LocalTime now = LocalTime.now();

        // Format the time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);

        // Print the current time
        return "Current Time: " + formattedTime;
    }
}

