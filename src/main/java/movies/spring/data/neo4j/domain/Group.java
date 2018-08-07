package movies.spring.data.neo4j.domain;

/**
 * Create on 2018/8/7 10:05
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class Group extends Entity {
    private String groupName;

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
