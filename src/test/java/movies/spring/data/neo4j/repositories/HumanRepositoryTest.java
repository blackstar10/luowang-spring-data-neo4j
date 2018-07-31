package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.common.GenderTypes;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.IDCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
@Transactional
public class HumanRepositoryTest {
    private final String idNumber1 = "809312801x";
    @Autowired
    private HumanRepository humanRepository;
    @Before
    public void setUp(){
        Human human = new Human();
        //todo 判断是否为空
        Collection<Human> humans = humanRepository.getHumanByIdNumber(idNumber1);
        if(humans != null && humans.size() > 0){
            human = humans.iterator().next();
        }
        human.setName("testjava1");
        human.setBirthday("1992-11-20");
        //todo 不对,
        // 测试 1. 能否写一个id对应一个human，2.尝试取出idNumber再更新idCard如果需要的话
        human.addIdCard(new IDCard(idNumber1));
        human.setGender(GenderTypes.getGenderType(1).getMessage());
        humanRepository.save(human);
    }
    @Test
    public void testFindByIdNumber(){
        Collection<Human> human = humanRepository.getHumanByIdNumber(idNumber1);
    }
}
