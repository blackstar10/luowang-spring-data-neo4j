package movies.spring.data.neo4j.domain.event;

public class AbnormalPowerOffEvent extends Event {
    public AbnormalPowerOffEvent() {
    }

    public AbnormalPowerOffEvent(String eventName) {
        super(eventName);
    }

    public AbnormalPowerOffEvent(String eventName, Long startTime, Long endTime) {
        super(eventName, startTime, endTime);
    }
}
