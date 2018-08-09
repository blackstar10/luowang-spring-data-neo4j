package movies.spring.data.neo4j.services.impl.event;


import movies.spring.data.neo4j.domain.event.Event;
import movies.spring.data.neo4j.repositories.event.EventRepository;
import movies.spring.data.neo4j.services.EventService;
import movies.spring.data.neo4j.services.GenericService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service("eventService")
public class EventServiceImpl extends GenericService<Event> implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Neo4jRepository<Event, Long> getRepository() {
        return eventRepository;
    }
}
