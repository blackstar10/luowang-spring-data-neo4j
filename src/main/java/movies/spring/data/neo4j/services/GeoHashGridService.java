package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.domain.GeoHashGrid;

public interface GeoHashGridService extends Service<GeoHashGrid> {

    GeoHashGrid findByGeoHashCode(String geoHashCode);
}
