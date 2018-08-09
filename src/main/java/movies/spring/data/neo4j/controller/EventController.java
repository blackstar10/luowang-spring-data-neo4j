package movies.spring.data.neo4j.controller;


import movies.spring.data.neo4j.domain.event.Event;
import movies.spring.data.neo4j.services.EventService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/event")
public class EventController extends Controller<Event> {

    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @Override
    public Service<Event> getService() {
        return eventService;
    }
}
