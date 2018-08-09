package movies.spring.data.neo4j.controller;


import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.services.GeoHashGridService;
import movies.spring.data.neo4j.services.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/geo")
public class GeoHashGridController extends Controller<GeoHashGrid> {
    private final GeoHashGridService geoHashGridService;

    public GeoHashGridController(GeoHashGridService geoHashGridService) {
        this.geoHashGridService = geoHashGridService;
    }

    @Override
    public Service<GeoHashGrid> getService() {
        return geoHashGridService;
    }


    @RequestMapping("/getByGeoHash")
    public GeoHashGrid findByGeoHashCode(String geohash, final HttpServletResponse response) {
        setHeaders(response);
        return geoHashGridService.findByGeoHashCode(geohash);
    }
}
