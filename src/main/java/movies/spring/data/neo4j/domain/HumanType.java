package movies.spring.data.neo4j.domain;

/**
 * Create on 2018/8/6 16:26
 *
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class HumanType extends Entity {

    private int humanTypeEnum;

    private String humanTypeName;

    public HumanType(){
    }

    public HumanType(int humanTypeEnum, String humanTypeName){
        this.humanTypeEnum = humanTypeEnum;
        this.humanTypeName = humanTypeName;
    }
    public int getHumanTypeEnum() {
        return humanTypeEnum;
    }

    public void setHumanTypeEnum(int humanTypeEnum) {
        this.humanTypeEnum = humanTypeEnum;
    }

    public String getHumanTypeName() {
        return humanTypeName;
    }

    public void setHumanTypeName(String humanTypeName) {
        this.humanTypeName = humanTypeName;
    }

}
