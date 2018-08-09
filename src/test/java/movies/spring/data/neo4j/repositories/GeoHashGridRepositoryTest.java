package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.GeoHashGrid;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableNeo4jRepositories("movies.spring.data.neo4j.repositories")
@Transactional
public class GeoHashGridRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(GeoHashGridRepositoryTest.class);
    @Autowired
    private GeoHashGridRepository geoHashGridRepository;
    private final String geoHashCode = GeoHashUtil.getGeoHashBase32(GeoHashUtil.HASH_LENGTH, 39.949547, 116.411497);

    @Before
    public void setUp() {
        GeoHashGrid geoHashGrid = new GeoHashGrid(geoHashCode);
        List<String> list = GeoHashUtil.getGeoHashBase32For9(GeoHashUtil.HASH_LENGTH, 39.949547, 116.411497);
        for (String ghashcode : list) {
            if (!ghashcode.equals(geoHashCode))
                geoHashGrid.addGeoHashGrid(new GeoHashGrid(ghashcode));
        }
        geoHashGridRepository.save(geoHashGrid);
    }

    @Test
    public void findByGeoHashCode() {
        GeoHashGrid geoHashGrid = geoHashGridRepository.findByGeoHashCode(geoHashCode);
        Assert.assertEquals(geoHashCode, geoHashGrid.getGeoHashCode());
        Assert.assertEquals(8, geoHashGrid.getGeoHashGridList().size());
    }
}