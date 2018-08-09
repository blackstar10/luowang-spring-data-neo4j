package movies.spring.data.neo4j.domain.event;

import movies.spring.data.neo4j.domain.Entity;
import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.Location;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public abstract class Event extends Entity {
    private String eventName;
    private Long startTime;
    private long endTime;
    @Relationship(type = "occurredIn")
    private Location eventLocation;

    @Relationship(type = "involve")
    private List<Human> humanListInvolved = new ArrayList<>();


    @Relationship(type = "relatedTo", direction = Relationship.UNDIRECTED)
    private List<Event> eventListRelated = new ArrayList<>();

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Location getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(Location eventLocation) {
        this.eventLocation = eventLocation;
    }

    public List<Human> getHumanListInvolved() {
        return humanListInvolved;
    }

    public void addHumanInvolved(Human human) {
        humanListInvolved.add(human);
    }

    public List<Event> getEventListRelated() {
        return eventListRelated;
    }

    public void addEventRelated(Event event) {
        eventListRelated.add(event);
    }
}