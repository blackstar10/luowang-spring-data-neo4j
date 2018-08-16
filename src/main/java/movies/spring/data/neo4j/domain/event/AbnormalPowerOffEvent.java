package movies.spring.data.neo4j.domain.event;

import java.util.Date;

public class AbnormalPowerOffEvent extends Event {
    public AbnormalPowerOffEvent() {
    }

    public AbnormalPowerOffEvent(String eventName) {
        super(eventName);
    }

    public AbnormalPowerOffEvent(String eventName, Date startTime, Date endTime) {
        super(eventName, startTime, endTime);
    }
}
