package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Phone;
import org.springframework.data.repository.query.Param;

/**
 * Create on 2018/8/7 13:54
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public interface PhoneService extends Service<Phone> {
    Phone findByImei(@Param("imei") String imei);
}
