package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.domain.Location;
import movies.spring.data.neo4j.geohash.GeoHashUtil;
import movies.spring.data.neo4j.geohash.LatLng;
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
 * Create on 2018/8/9 15:30
 *
 * @author sunqiu@cmss.chinamobile.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class LocationRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(LocationRepositoryTest.class);
    @Autowired
    private LocationRepository locationRepository;
    private final String geoHashCode = GeoHashUtil.getGeoHashBase32(GeoHashUtil.HASH_LENGTH, 39.949547, 116.411497);
    private final String locationName1 = "地点1";

    @Before
    public void setUp() {
        Location location = new Location(locationName1, 39.949547, 116.411497);
        GeoHashGrid geoHashGrid = new GeoHashGrid(geoHashCode);
        location.setGeoHashGrid(geoHashGrid);
        locationRepository.save(location);
    }

    @Test
    public void getLocationByGeohash() {
        Location location = locationRepository.getLocationByGeohash(geoHashCode);
        Assert.assertEquals(locationName1, location.getLocationName());
        Assert.assertEquals(new LatLng(39.949547, 116.411497), location.getLatLng());
    }
}
