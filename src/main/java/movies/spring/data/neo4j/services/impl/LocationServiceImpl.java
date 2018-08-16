package movies.spring.data.neo4j.services.impl;


import movies.spring.data.neo4j.domain.Location;
import movies.spring.data.neo4j.repositories.LocationRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.LocationService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("locationService")
public class LocationServiceImpl extends GenericService<Location>
        implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Neo4jRepository<Location, Long> getRepository() {
        return locationRepository;
    }

    @Override
    public Collection<Location> findByLocationName(String locationName) {
        return locationRepository.findByLocationName(locationName);
    }

    @Override
    public Location getLocationByGeohash(String geoHashCode) {
        return locationRepository.getLocationByGeohash(geoHashCode);
    }
}
