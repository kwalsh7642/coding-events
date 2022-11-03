package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        ArrayList<String> events = new ArrayList<>();
        events.add ("Code With Pride");
        events.add("Strange Loop");
        events.add("Apple WWDC");
        events.add("SpringOne Platform");
        model.addAttribute("events" , events);

        return "events/index";

    }

    @GetMapping("create") //lives at /events/create
    public String renderCreateEventForm (){
        return "events/create"; //returns static events form
    }

    @PostMapping //this method will add a user event to our list
    public String createEvent(@RequestParam String eventName) {
        events.add(eventName);
        return "redirect:"; // redirects to the root path controller, which is "/events"

    }
}
