package movies.spring.data.neo4j.controller;


import movies.spring.data.neo4j.domain.*;
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
import movies.spring.data.neo4j.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

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
    @RequestMapping("/testRing1")
    public String testRing1() {
        return "Done";
    }
}
