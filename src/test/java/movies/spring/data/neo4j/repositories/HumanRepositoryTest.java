package movies.spring.data.neo4j.repositories;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Create on 2018/7/31 17:59
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class HumanRepositoryTest {
    @Autowired
    private HumanRepository humanRepository;
    @Before
    public void setUp(){

    }
    @Test
    public void testFindByIdNumber(){

    }
}
