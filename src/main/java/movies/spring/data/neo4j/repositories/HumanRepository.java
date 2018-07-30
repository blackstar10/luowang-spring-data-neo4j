package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.result.GenderTypes;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Human节点
 * Create on 2018/7/30 15:39
 *
 * @author sunqiu@cmss.chinamobile.com
 */
@Repository
public interface HumanRepository extends Neo4jRepository<Human,Long> {

    Collection<Human> findByGender(@Param("gender") GenderTypes gender);
    Collection<Human> findByName(@Param("name") String name);
    @Query("match (n:Human)-[:owns]-(i:IdCard) where i.idNumber = {idNumber} return n")
    Collection<Human> getHumanByIdNumber(@Param("idNumber") String idNumber);
}
