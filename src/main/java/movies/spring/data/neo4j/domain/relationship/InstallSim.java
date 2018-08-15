package movies.spring.data.neo4j.domain.relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import movies.spring.data.neo4j.domain.Entity;
import movies.spring.data.neo4j.domain.Phone;
import movies.spring.data.neo4j.domain.SIMCard;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "installed")
public class InstallSim extends Entity {
    @JsonIgnore
    @StartNode
    private Phone phone;
    @EndNode
    private SIMCard simCard;

    public Phone getPhone() {
        return phone;
    }

    public InstallSim setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public SIMCard getSimCard() {
        return simCard;
    }

    public InstallSim setSimCard(SIMCard simCard) {
        this.simCard = simCard;
        return this;
    }


}
