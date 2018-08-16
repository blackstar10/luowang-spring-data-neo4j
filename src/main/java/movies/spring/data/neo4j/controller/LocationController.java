package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.IDCard;
import movies.spring.data.neo4j.domain.Location;
import movies.spring.data.neo4j.services.LocationService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/api/location")
public class LocationController extends Controller<Location> {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Service<Location> getService() {
        return locationService;
    }

    @RequestMapping("/getByGeoHash")
    public Location GetHumanByIdNumber(@RequestParam(value = "geohash") String geohash,
                                       final HttpServletResponse response) {
        setHeaders(response);
        return locationService.getLocationByGeohash(geohash);
    }
}
