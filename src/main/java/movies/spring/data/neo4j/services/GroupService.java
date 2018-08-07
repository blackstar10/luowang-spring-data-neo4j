package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Group;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Create on 2018/8/7 13:53
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public interface GroupService  extends Service<Group> {

    Collection<Group> findByGroupName(@Param("groupName") String groupName);
}
