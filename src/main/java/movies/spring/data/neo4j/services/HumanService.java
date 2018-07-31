package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.repositories.HumanRepository;
import movies.spring.data.neo4j.result.GenderTypes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

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

    @Transactional
    public Collection<Human> findByName(String name) {
        return humanRepositiory.findByName(name);
    }


    @Transactional
    public Human createHuman(String name){
        Human human = new Human();
        human.setName(name);
        human.setBirthday("1992-12-12");
        human.setGender(GenderTypes.getGenderType(0).getMessage());
        humanRepositiory.save(human);
        return human;
    }
}
