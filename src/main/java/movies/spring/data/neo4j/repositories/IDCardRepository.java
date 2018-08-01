package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.IDCard;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Create on 2018/7/31 17:09
 *
 * @author sunqiu@cmss.chinamobile.com
 */
@Repository
public interface IDCardRepository extends Neo4jRepository<IDCard, Long> {

    Collection<IDCard> findIDCardByIdNumber(@Param("idNumber") String idNumber);
}
