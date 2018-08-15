package movies.spring.data.neo4j.repositories;


import movies.spring.data.neo4j.domain.Location;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LocationRepository extends Neo4jRepository<Location,Long> {

    @Query("match (n:Location)-[:locatedOn]->(i:GeoHashGrid) " +
            "where i.geoHashCode = {geoHashCode} " +
            "return n")
    Location getLocationByGeohash(@Param("geoHashCode") String geoHashCode);
}
