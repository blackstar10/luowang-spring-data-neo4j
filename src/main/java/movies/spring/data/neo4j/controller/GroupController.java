package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.Group;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.services.GroupService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * Create on 2018/8/7 14:15
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RestController
@RequestMapping("/api/group")
public class GroupController extends Controller<Group> {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Service<Group> getService() {
        return groupService;
    }

    @RequestMapping("/getByGroupName")
    public Collection<Group> GetGroupByName(@RequestParam(value = "name") String name, final HttpServletResponse response) {
        setHeaders(response);
        return groupService.findByGroupName(name);
    }
}
