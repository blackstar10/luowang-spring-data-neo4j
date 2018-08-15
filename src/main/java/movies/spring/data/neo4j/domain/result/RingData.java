package movies.spring.data.neo4j.domain.result;

import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.Set;

@QueryResult
public class RingData {
    private Set<String> humanNames;
    private Set<String> otherNodeLabels;
    private int ringSize;

    public Set<String> getHumanNames() {
        return humanNames;
    }

    public RingData setHumanNames(Set<String> humanNames) {
        this.humanNames = humanNames;
        return this;
    }

    public Set<String> getOtherNodeLabels() {
        return otherNodeLabels;
    }

    public RingData setOtherNodeLabels(Set<String> otherNodeLabels) {
        this.otherNodeLabels = otherNodeLabels;
        return this;
    }

    public int getRingSize() {
        return ringSize;
    }

    public RingData setRingSize(int ringSize) {
        this.ringSize = ringSize;
        return this;
    }

}
