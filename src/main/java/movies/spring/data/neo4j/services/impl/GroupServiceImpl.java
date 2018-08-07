package movies.spring.data.neo4j.services.impl;

import movies.spring.data.neo4j.domain.Group;
import movies.spring.data.neo4j.repositories.GroupRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.GroupService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Create on 2018/8/7 14:02
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Service("groupService")
public class GroupServiceImpl extends GenericService<Group> implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Neo4jRepository<Group, Long> getRepository() {
        return groupRepository;
    }

    @Override
    public Collection<Group> findByGroupName(String groupName) {
        return groupRepository.findByGroupName(groupName);
    }
}
