package movies.spring.data.neo4j.services.impl;


import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.repositories.GeoHashGridRepository;
import movies.spring.data.neo4j.services.GenericService;
import movies.spring.data.neo4j.services.GeoHashGridService;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Service;

@Service("geoHashGridService")
public class GeoHashGridServiceImpl extends GenericService<GeoHashGrid> implements GeoHashGridService {
    private final GeoHashGridRepository geoHashGridRepository;

    public GeoHashGridServiceImpl(GeoHashGridRepository geoHashGridRepository){
        this.geoHashGridRepository = geoHashGridRepository;
    }
    @Override
    public Neo4jRepository<GeoHashGrid, Long> getRepository() {
        return geoHashGridRepository;
    }

    @Override
    public GeoHashGrid findByGeoHashCode(String geoHashCode) {
        return geoHashGridRepository.findByGeoHashCode(geoHashCode);
    }
}
