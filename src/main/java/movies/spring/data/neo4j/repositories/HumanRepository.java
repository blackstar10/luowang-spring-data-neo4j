package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.common.GenderTypes;
import movies.spring.data.neo4j.domain.result.RingData;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

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

    @Query("match (n:Human)-[:owns]->(i:IDCard) where i.idNumber = {idNumber} return n")
    Collection<Human> getHumanByIdNumber(@Param("idNumber") String idNumber);
    @Query("match (n:Human)-[:owns]->(i:Phone)-[:installed]->(j:SIMCard) where j.simCardNumber = {simCardNumber} return n")
    Collection<Human> getHumanBySIMCardNumber(@Param("simCardNumber") String simCardNumber);

    @Query("  Match (human:Human) <-[*..]-(othernode) " +
            " WITH othernode, count(othernode) as RingSize " +
            " MATCH (othernode) - [*..] -> (human) " +
            " WITH collect(human.name) AS Humans, othernode, RingSize " +
            " WHERE RingSize > 1 " +
            " RETURN Humans AS humanNames, labels(othernode) AS otherNodeLabels ,RingSize as ringSize" +
            " Order by RingSize DESC")
    Collection<RingData> getRingDataGenerated();

}
