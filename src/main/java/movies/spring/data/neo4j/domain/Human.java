package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2018/7/30 10:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */
@NodeEntity
public class Human {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String birthday;
    private String comments;
    private boolean isResident;
    private String gender; // todo 枚举

    @Relationship(type = "owns", direction = Relationship.INCOMING)
    private IDCard movies;

}
