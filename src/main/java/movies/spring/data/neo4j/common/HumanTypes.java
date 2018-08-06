package movies.spring.data.neo4j.common;

/**
 * Create on 2018/8/6 16:29
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public enum HumanTypes {

    UNDEFINEDLIST(0),
    BLACKLIST(1),
    WHITELIST(2),
    REDLIST(3),
    PORN_PERSON_LIST(4),
    GAMBLE_PERSON_LIST(5),
    DRAG_PERSON_LIST(6);

    private int humanType;

    HumanTypes(final int humanType) {
        this.humanType = humanType;
    }

    public int val(){
        return this.humanType;
    }
}
