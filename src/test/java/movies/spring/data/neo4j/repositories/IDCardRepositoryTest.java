package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.common.GenderTypes;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.IDCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Create on 2018/8/1 10:32
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class IDCardRepositoryTest {

    private final String idNumberExist = "01283210381";
    private final String idNumber1 = "01283210111";
    private final String name1 = "testjava2";
    @Autowired
    private IDCardRepository idCardRepository;

    @Before
    public void setUp() {
    }


    @Test
    public void testFindByIdNumber() {
        Collection<IDCard> idCards = idCardRepository.findIDCardByIdNumber(idNumberExist);
        Assert.assertNotNull(idCards);
        Assert.assertNotEquals(0,idCards.size());
        Assert.assertNotNull(idCards.iterator().next().getHuman());
    }


    @Test
    public void testCreateLinkExistHumanFindByIdNumber() {
        //确定idNumber1的idcard不存在
        Collection<IDCard> idCards = idCardRepository.findIDCardByIdNumber(idNumber1);
        Assert.assertNotNull(idCards);
        Assert.assertEquals(0,idCards.size());
        //创建新的idNumber1的idcard
        IDCard idCard = new IDCard(idNumber1);
        // 从已有的idCard link取得已存在的human
        idCard.setHuman(idCardRepository.findIDCardByIdNumber(idNumberExist).iterator().next().getHuman());
        idCard.getId();
        idCardRepository.save(idCard);
        idCard.getId();
        Collection<IDCard> idCards2 = idCardRepository.findIDCardByIdNumber(idNumber1);
        Assert.assertNotNull(idCards2);
        Assert.assertNotEquals(0,idCards2.size());
        Assert.assertNotNull(idCards2.iterator().next().getHuman());
    }


    @Test
    public void testCreateLinkNotExistHumanFindByIdNumber() {
        //确定idNumber1的idcard不存在
        Collection<IDCard> idCards = idCardRepository.findIDCardByIdNumber(idNumber1);
        Assert.assertNotNull(idCards);
        Assert.assertEquals(0,idCards.size());
        //创建新的idNumber1的idcard
        IDCard idCard = new IDCard(idNumber1);

        //创建新的的human

        Human human = new Human();
        human.setName(name1);
        human.setBirthday("1992-11-20");
        human.setGender(GenderTypes.getGenderType(1).getMessage());
        idCard.setHuman(human);
        idCardRepository.save(idCard);
        idCard.getId();
        Collection<IDCard> idCards2 = idCardRepository.findIDCardByIdNumber(idNumber1);
        Assert.assertNotNull(idCards2);
        Assert.assertNotEquals(0,idCards2.size());
        Assert.assertNotNull(idCards2.iterator().next().getHuman());
    }
}
