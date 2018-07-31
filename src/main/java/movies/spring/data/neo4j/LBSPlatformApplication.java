package movies.spring.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Create on 2018/7/30 9:54
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@SpringBootApplication
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
public class LBSPlatformApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(LBSPlatformApplication.class, args);
    }
}
