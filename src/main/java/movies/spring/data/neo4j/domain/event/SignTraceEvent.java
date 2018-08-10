package movies.spring.data.neo4j.domain.event;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.Location;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class SignTraceEvent extends Event {

    @Relationship(type = "traceOn")
    private List<Location> locationList = new ArrayList<>();

    public SignTraceEvent() {
    }

    public SignTraceEvent(String eventName) {
        super(eventName);
    }

    public SignTraceEvent(String eventName, Long startTime, Long endTime) {
        super(eventName, startTime, endTime);
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public void addLocation(Location location) {
        this.locationList.add(location);
    }
}
