package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Group;
import movies.spring.data.neo4j.domain.Human;
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

/**
 * Create on 2018/8/7 15:30
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class GroupRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(GroupRepositoryTest.class);
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private HumanRepository humanRepository;

    @Before
    public void setUp() {
        Group group1 = new Group("testCompany");
        Human human1 = new Human("human1","1999-01-02","",true,"male");
        Human human2 = new Human("human2","1999-04-07","",true,"female");
        Human human3 = new Human("human3","1999-03-22","",false,"female");
        Human human4 = new Human("human4","1999-02-12","",false,"male");
        human1.addGroupList(group1);
        human2.addGroupList(group1);
        human3.addGroupList(group1);
        humanRepository.save(human1);
        humanRepository.save(human2);
        humanRepository.save(human3);
        humanRepository.save(human4);
    }


    @Test
    public void testRelationship(){
        int count = 0;
        for (Human human : humanRepository.findByName("human1")){
            Assert.assertEquals(1,human.getGroupList().size());
            Assert.assertEquals("testCompany",human.getGroupList().get(0).getGroupName());
            count +=1;
        }
        Assert.assertEquals(1,count);
    }

    @Test
    public void testAddRelationship(){
        for (Human human : humanRepository.findByName("human1")) {
            Group group2 = new Group("testCompany2");
            human.addGroupList(group2);
            humanRepository.save(human);
        }

        int count = 0;
        for (Human human : humanRepository.findByName("human1")) {
            Assert.assertEquals(2,human.getGroupList().size());
            for (Group group : human.getGroupList()) {
                logger.info(group.getGroupName());
            }
            count +=1;
        }
        Assert.assertEquals(1,count);
    }
}
