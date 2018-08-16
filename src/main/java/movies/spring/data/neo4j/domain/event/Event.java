package movies.spring.data.neo4j.domain.event;

import movies.spring.data.neo4j.domain.Entity;
import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.Location;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Event extends Entity {
    private String eventName;
    @DateLong
    private Date startTime = Calendar.getInstance().getTime();
    @DateLong
    private Date endTime = Calendar.getInstance().getTime();
    @Relationship(type = "occurredIn")
    private Location eventLocation;

    @Relationship(type = "involve")
    private List<Human> humanListInvolved = new ArrayList<>();


    @Relationship(type = "relatedTo", direction = Relationship.UNDIRECTED)
    private List<Event> eventListRelated = new ArrayList<>();


    public Event(){}
    public Event(String eventName){
        this.eventName = eventName;
    }

    public Event(String eventName, Date startTime, Date endTime){
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
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
