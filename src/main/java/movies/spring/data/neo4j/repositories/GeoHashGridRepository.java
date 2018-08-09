package movies.spring.data.neo4j.repositories;


import movies.spring.data.neo4j.domain.GeoHashGrid;
import movies.spring.data.neo4j.domain.event.Event;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface GeoHashGridRepository extends Neo4jRepository<GeoHashGrid,Long> {

    GeoHashGrid findByGeoHashCode(@Param("geoHashCode") String geoHashCode);

}
