package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.domain.relationship.InstallSim;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2018/8/7 11:19
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class Phone extends Entity {
    private String imei;

    @Relationship(type = "installed")
    private List<InstallSim> installSims = new ArrayList<>();

    public Phone(){}
    public Phone(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public List<InstallSim> getInstallSims() {
        return installSims;
    }

    public void setInstallSims(List<InstallSim> installSims) {
        this.installSims = installSims;
    }

    public void addSimCard(InstallSim installSim) {
        installSims.add(installSim);
    }
}
