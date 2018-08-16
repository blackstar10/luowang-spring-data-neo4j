package movies.spring.data.neo4j.common;

/**
 * Create on 2018/8/6 16:29
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public enum HumanTypes {
    UNDEFINEDLIST("UndefinedList"),
    BLACKLIST("BlackList"),
    WHITELIST("WhiteList"),
    REDLIST("RedList"),
    PORN_PERSON_LIST("PornPersonList"),
    GAMBLE_PERSON_LIST("GamblePersonList"),
    DRAG_PERSON_LIST("DragPersonList");


    private final String humanType;

    HumanTypes(String humanType) {
        this.humanType = humanType;
    }

    public String getType() {
        return humanType;
    }
}
