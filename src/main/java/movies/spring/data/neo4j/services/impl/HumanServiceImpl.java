package movies.spring.data.neo4j.services.impl;

import movies.spring.data.neo4j.common.GenderTypes;
import movies.spring.data.neo4j.common.HumanTypes;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.IDCard;
import movies.spring.data.neo4j.domain.result.RingData;
import movies.spring.data.neo4j.repositories.HumanRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.HumanService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Create on 2018/7/30 17:48
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@Service("humanService")
public class HumanServiceImpl extends GenericService<Human> implements HumanService {
    private final HumanRepository humanRepositiory;

    public HumanServiceImpl(HumanRepository humanRepositiory) {
        this.humanRepositiory = humanRepositiory;
    }

    @Override
    @Transactional
    public Collection<Human> findByName(String name) {
        return humanRepositiory.findByName(name);
    }

    @Override
    @Transactional
    public Collection<Human> findByIdNumber(String idNumber) {
        return humanRepositiory.getHumanByIdNumber(idNumber);
    }

    @Override
    @Transactional
    public Human createHuman(String name) {
        Human human = new Human();
        human.setName(name);
        human.setBirthday("1982-07-10");
        human.addIdCard(new IDCard("99912313211"));
        human.setGender(GenderTypes.getGenderType(1).getMessage());
        human.addLabels(HumanTypes.BLACKLIST.getType());
        human.addLabels(HumanTypes.UNDEFINEDLIST.getType());
        human.addLabels("TestHumanList1");
        humanRepositiory.save(human);
        return human;
    }

    @Override
    public Collection<Human> findBySIMCardNumber(String simCardNumber) {
        return humanRepositiory.getHumanBySIMCardNumber(simCardNumber);
    }

    @Override
    public Collection<RingData> getRingDataGenerated() {
        return humanRepositiory.getRingDataGenerated();
    }

    @Override
    public Neo4jRepository<Human, Long> getRepository() {
        return humanRepositiory;
    }
}
