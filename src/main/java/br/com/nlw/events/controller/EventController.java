package br.com.nlw.events.controller;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.service.EventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    //@Transactional
    public Event addNewEvent(@RequestBody Event newEvent){
        return eventService.addNewEvent(newEvent);
    }

    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/{prettyName}")
    public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName){
        Event evt = eventService.getByPrettyname(prettyName);
        if (evt != null){
            return ResponseEntity.ok().body(evt);
        }
        return ResponseEntity.notFound().build();
        //return eventService.getByPrettyname(prettyName);
    }
}
