package movies.spring.data.neo4j.domain.event;

public class SignTraceEvent extends Event {

    public SignTraceEvent() {
    }

    public SignTraceEvent(String eventName) {
        super(eventName);
    }

    public SignTraceEvent(String eventName, Long startTime, Long endTime) {
        super(eventName, startTime, endTime);
    }
}
