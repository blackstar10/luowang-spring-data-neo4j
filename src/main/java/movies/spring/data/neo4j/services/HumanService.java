package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.repositories.HumanRepository;
import org.springframework.stereotype.Service;

/**
 * Create on 2018/7/30 17:48
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Service
public class HumanService {

    private final HumanRepository humanRepositiory;

    public HumanService(HumanRepository humanRepositiory) {
        this.humanRepositiory = humanRepositiory;
    }
}
