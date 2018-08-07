package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Phone;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Create on 2018/8/7 13:44
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Repository
public interface PhoneRepository extends Neo4jRepository<Phone,Long> {
    Phone findByImei(@Param("imei") String imei);
}
