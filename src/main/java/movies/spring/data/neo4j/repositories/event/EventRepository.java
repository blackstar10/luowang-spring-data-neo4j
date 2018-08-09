package movies.spring.data.neo4j.repositories.event;

import movies.spring.data.neo4j.domain.Group;
import movies.spring.data.neo4j.domain.event.Event;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface EventRepository extends Neo4jRepository<Event,Long> {

    Collection<Event> findByEventName(@Param("eventName") String eventName);
}
