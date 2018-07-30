package movies.spring.data.neo4j.result;

/**
 * Create on 2018/7/30 15:25
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public enum GenderTypes {

    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    private final String message;

    GenderTypes(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
