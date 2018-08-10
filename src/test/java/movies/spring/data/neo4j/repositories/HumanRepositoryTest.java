package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.common.GenderTypes;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.IDCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


/**
 * Create on 2018/7/31 17:59
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class HumanRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(HumanRepositoryTest.class);
    private final String idNumber1 = "01283210381";
    private final String name1 = "testjava1";
    @Autowired
    private HumanRepository humanRepository;

    @Before
    public void setUp() {
        Human human = new Human();
        Collection<Human> humans = humanRepository.getHumanByIdNumber(idNumber1);
        if (humans != null && humans.size() > 0) {
            human = humans.iterator().next();
        }
        human.setName(name1);
        human.setBirthday("1992-11-20");
        human.setGender(GenderTypes.getGenderType(1).getMessage());
        // 测试 1. 能否写一个id对应一个human，2.尝试取出idNumber再更新idCard如果需要的话
        if (human.getIdCardList().size() == 0) {
            IDCard idCard1 = new IDCard(idNumber1);
            human.addIdCard(idCard1);
            idCard1.setHuman(human);
        }
        humanRepository.save(human);
        logger.info(human.getId().toString());
        Collection<Human> humans2 = humanRepository.getHumanByIdNumber(idNumber1);

        logger.info(String.valueOf(humans2.size()));
    }

    @Test
    public void testFindByIdNumber() {
        Collection<Human> humans = humanRepository.getHumanByIdNumber(idNumber1);
        Assert.assertNotNull(humans);
        Assert.assertNotEquals(0, humans.size());
    }

    @Test
    public void testFindByName() {
        Collection<Human> humans = humanRepository.findByName(name1);
        Assert.assertNotNull(humans);
        Assert.assertNotEquals(0, humans.size());
    }
}
