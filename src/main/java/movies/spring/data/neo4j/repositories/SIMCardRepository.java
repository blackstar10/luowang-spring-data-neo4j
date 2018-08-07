package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.SIMCard;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Create on 2018/8/7 13:46
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Repository
public interface SIMCardRepository extends Neo4jRepository<SIMCard,Long> {
    SIMCard findByImsi(@Param("imsi") String imsi);
    SIMCard findBySimCardNumber(@Param("simCardNumber") String simCardNumber);
}
