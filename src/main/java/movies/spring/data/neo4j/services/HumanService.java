package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Human;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Create on 2018/7/31 15:23
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public interface HumanService extends Service<Human> {
    Collection<Human> findByName(String name);
    Collection<Human> findByIdNumber(String idNumber);
    Human createHuman(String name);
    Collection<Human> findBySIMCardNumber(String simCardNumber);
}
