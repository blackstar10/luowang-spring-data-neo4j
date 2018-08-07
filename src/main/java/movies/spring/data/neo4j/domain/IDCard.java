package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2018/7/30 10:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class IDCard extends Entity {
    private String idNumber;
    @Relationship(type = "owns", direction = Relationship.INCOMING)
    private Human human;

    @Relationship(type = "applied")
    private List<SIMCard> simCards = new ArrayList<>();
    public IDCard(String idNumber) {
        this.idNumber = idNumber;
    }

    public IDCard() {
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    //加注解@JsonBackReference避免json无限循环报错
    @JsonBackReference
    public Human getHuman() {
        return human;
    }

    @JsonBackReference
    public void setHuman(Human human) {
        this.human = human;
    }

    public List<SIMCard> getSimCards() {
        return simCards;
    }

    public void setSimCards(List<SIMCard> simCards) {
        this.simCards = simCards;
    }
    public void addSimCard(SIMCard simCard){
        this.simCards.add(simCard);
    }
}
