package movies.spring.data.neo4j.application;


import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.domain.Group;
import movies.spring.data.neo4j.domain.Human;
import movies.spring.data.neo4j.domain.Location;
import movies.spring.data.neo4j.domain.event.AbnormalPowerOffEvent;
import movies.spring.data.neo4j.domain.event.CriminalCase;
import movies.spring.data.neo4j.domain.event.Event;
import movies.spring.data.neo4j.domain.event.SignTraceEvent;
import movies.spring.data.neo4j.geohash.GeoHashUtil;
import movies.spring.data.neo4j.geohash.LatLng;
import movies.spring.data.neo4j.repositories.GeoHashGridRepository;
import movies.spring.data.neo4j.repositories.HumanRepository;
import movies.spring.data.neo4j.repositories.IDCardRepository;
import movies.spring.data.neo4j.repositories.LocationRepository;
import movies.spring.data.neo4j.repositories.event.EventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class CriminalRingTest {

    @Autowired
    private IDCardRepository idCardRepository;
    @Autowired
    private HumanRepository humanRepository;
    @Autowired
    private GeoHashGridRepository geoHashGridRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocationRepository locationRepository;

    private final String geoHashCode = GeoHashUtil.getGeoHashBase32(GeoHashUtil.HASH_LENGTH, 39.949547, 116.411497);
    private final String idNumber1 = "01283210381";
    @Before
    public void setUp() {
        // 犯罪闭环，发现团伙作案可能性

        /**
        // 以39.949547, 116.411497为中心点，创建9个网格
        GeoHashGrid geoHashGrid = new GeoHashGrid(geoHashCode);
        List<String> list = GeoHashUtil.getGeoHashBase32For9(GeoHashUtil.HASH_LENGTH, 39.949547, 116.411497);
        for (String ghashcode : list) {
            if (!ghashcode.equals(geoHashCode)){
                geoHashGrid.addGeoHashGrid(new GeoHashGrid(ghashcode));
                GeoHashUtil.getMiddleLocation(ghashcode);
            }
        }
        geoHashGridRepository.save(geoHashGrid);
        // 创建中心点和周围8个网格中心点的location
        ArrayList<Location> locationArrayList = new ArrayList<>();
        LatLng latLng1 = GeoHashUtil.getMiddleLocation(geoHashGrid.getGeoHashCode());
        if(latLng1 != null){
            Location location = new Location(latLng1.toString(),latLng1);
            location.setGeoHashGrid(geoHashGrid);
            locationRepository.save(location);
            locationArrayList.add(location);
        }
        for (GeoHashGrid hashGrid : geoHashGrid.getGeoHashGridList()) {
            LatLng latLng = GeoHashUtil.getMiddleLocation(hashGrid.getGeoHashCode());
            if(latLng != null){
                Location location = new Location(latLng.toString(),latLng);
                location.setGeoHashGrid(hashGrid);
                locationRepository.save(location);
                locationArrayList.add(location);
            }
        }
        // 相关人员创建
        Group group1 = new Group("testCompany1");
        Group group2 = new Group("testCompany2");
        Human human1 = new Human("人员1", "1969-01-02", "", true, "male");
        Human human2 = new Human("人员2", "1979-04-07", "", true, "female");
        Human human3 = new Human("人员3", "1999-03-22", "", false, "female");
        Human human4 = new Human("人员4", "1999-02-12", "", false, "male");
        Human human5 = new Human("人员5", "1991-03-22", "", false, "female");
        Human human6 = new Human("人员6", "1992-02-12", "", false, "male");
        human1.addGroupList(group1);
        human2.addGroupList(group1);
        human3.addGroupList(group1);
        human1.addGroupList(group2);
        human5.addGroupList(group2);
        human6.addGroupList(group2);
        humanRepository.save(human1);
        humanRepository.save(human2);
        humanRepository.save(human3);
        humanRepository.save(human4);
        humanRepository.save(human5);
        humanRepository.save(human6);
        // 创建9个网格内的location和一个9个网格外的location
        Event e1= new CriminalCase("犯罪案件1");
        Event e2= new CriminalCase("犯罪案件2");
        AbnormalPowerOffEvent e11= new AbnormalPowerOffEvent("异常关机11");
        SignTraceEvent e12= new SignTraceEvent("信令用户轨迹12");
        SignTraceEvent e21= new SignTraceEvent("信令用户轨迹11");
        AbnormalPowerOffEvent e22= new AbnormalPowerOffEvent("异常关机12");
        e1.addEventRelated(e11);
        e1.addEventRelated(e12);
        e2.addEventRelated(e21);
        e2.addEventRelated(e22);
        // 创建事件与地点关系
        e1.setEventLocation(locationArrayList.get(0));
        e11.setEventLocation(locationArrayList.get(0));
        e12.addLocation(locationArrayList.get(0));
        e12.addLocation(locationArrayList.get(7));
        e12.addLocation(locationArrayList.get(5));
        e12.addLocation(locationArrayList.get(6));

        e2.setEventLocation(locationArrayList.get(1));
        e21.setEventLocation(locationArrayList.get(1));
        e21.addLocation(locationArrayList.get(1));
        e21.addLocation(locationArrayList.get(2));
        e21.addLocation(locationArrayList.get(4));
        e21.addLocation(locationArrayList.get(3));
        // 创建事件与人员关系
        e1.addHumanInvolved(human1);
        e1.addHumanInvolved(human3);
        e1.addHumanInvolved(human6);

        e2.addHumanInvolved(human2);
        e2.addHumanInvolved(human4);
        e2.addHumanInvolved(human5);

        e11.addHumanInvolved(human2);
        e11.addHumanInvolved(human3);
        e12.addHumanInvolved(human1);
        e12.addHumanInvolved(human3);
        e12.addHumanInvolved(human4);


        e21.addHumanInvolved(human4);
        e21.addHumanInvolved(human5);
        e22.addHumanInvolved(human6);
        e22.addHumanInvolved(human1);
        // 保存到neo4j
        eventRepository.save(e1);
        eventRepository.save(e2);
         **/
    }


    @Test
    public void testFindByIdNumber() {
        Collection<Human> humans = humanRepository.getHumanByIdNumber(idNumber1);
        Assert.assertNotNull(humans);
        Assert.assertNotEquals(0, humans.size());
    }

}
