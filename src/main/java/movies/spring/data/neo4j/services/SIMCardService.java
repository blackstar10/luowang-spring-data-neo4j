package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.SIMCard;
import org.springframework.data.repository.query.Param;

/**
 * Create on 2018/8/7 13:55
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public interface SIMCardService extends Service<SIMCard> {
    SIMCard findByImsi(@Param("imsi") String imsi);
    SIMCard findBySimCardNumber(@Param("simCardNumber") String simCardNumber);
}
