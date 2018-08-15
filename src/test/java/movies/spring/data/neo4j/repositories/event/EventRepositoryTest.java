package movies.spring.data.neo4j.repositories.event;

import movies.spring.data.neo4j.domain.event.AbnormalPowerOffEvent;
import movies.spring.data.neo4j.domain.event.CriminalCase;
import movies.spring.data.neo4j.domain.event.Event;
import movies.spring.data.neo4j.domain.event.SignTraceEvent;
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

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class EventRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(EventRepositoryTest.class);
    @Autowired
    private EventRepository eventRepository;

    @Before
    public void setUp() {
        Event e1= new CriminalCase("犯罪案件a");
        Event e11= new AbnormalPowerOffEvent("犯罪案件aa");
        Event e12= new AbnormalPowerOffEvent("犯罪案件ab");
        Event e13= new SignTraceEvent("犯罪案件ac");
        e1.addEventRelated(e11);
        e1.addEventRelated(e12);
        e1.addEventRelated(e13);
        eventRepository.save(e1);
    }

    @Test
    public void testEventRelationShip() {
        Collection<Event> event1 = eventRepository.findByEventName("犯罪案件a");
        Assert.assertEquals(1,event1.size());
        Assert.assertEquals(3,event1.iterator().next().getEventListRelated().size());
        Collection<Event> event12 = eventRepository.findByEventName("犯罪案件ab");
        Assert.assertEquals(1,event12.size());
        Assert.assertEquals(1,event12.iterator().next().getEventListRelated().size());
    }
}