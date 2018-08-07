package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;

/**
 * Create on 2018/8/7 11:20
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class SIMCard {
    private String imsi;
    private String simCardNumber;

    public String getSimCardNumber() {
        return simCardNumber;
    }

    public void setSimCardNumber(String simCardNumber) {
        this.simCardNumber = simCardNumber;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }
}
