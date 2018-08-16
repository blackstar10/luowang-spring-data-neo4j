package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.Location;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface LocationService extends Service<Location> {
    
    Collection<Location> findByLocationName(String locationName);
    Location getLocationByGeohash(String geoHashCode);
}
