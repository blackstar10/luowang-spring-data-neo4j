package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Group;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Create on 2018/8/7 13:41
 *
 * @author sunqiu@cmss.chinamobile.com
 */
@Repository
public interface GroupRepository extends Neo4jRepository<Group,Long> {

    Collection<Group> findByGroupName(@Param("groupName") String groupName);
}
