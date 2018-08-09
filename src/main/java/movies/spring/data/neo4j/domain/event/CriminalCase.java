package movies.spring.data.neo4j.domain.event;

import movies.spring.data.neo4j.domain.Human;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class CriminalCase extends Event {

    public CriminalCase() {
    }

    public CriminalCase(String eventName, Long startTime, Long endTime) {
        super(eventName, startTime, endTime);
    }

    public CriminalCase(String eventName) {
        super(eventName);
    }
}
