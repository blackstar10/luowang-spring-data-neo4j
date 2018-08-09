package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Location;
import org.springframework.data.repository.query.Param;

public interface LocationService extends Service<Location> {

    Location getLocationByGeohash(@Param("geoHashCode") String geoHashCode);
}
