package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Create on 2018/7/30 10:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class IDCard {
    @Id
    @GeneratedValue
    private Long id;

    private String idNumber;
    @Relationship(type = "owns", direction = Relationship.INCOMING)
    private Human human;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    @JsonBackReference
    public Human getHuman() {
        return human;
    }
    @JsonBackReference
    public void setHuman(Human human) {
        this.human = human;
    }
}
