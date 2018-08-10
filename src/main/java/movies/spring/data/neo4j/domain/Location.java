package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.geohash.GeoHashUtil;
import movies.spring.data.neo4j.geohash.LatLng;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author sunqiu
 */
public class Location extends Entity {

    private String locationName;
    // todo
    private LatLng latLng;

    @Relationship(type = "locatedOn")
    private GeoHashGrid geoHashGrid;

    public Location() {
    }

    public Location(String locationName, double lat, double lng) {
        this.locationName = locationName;
    }
    public Location(String locationName, LatLng ll) {
        this.locationName = locationName;
//        this.latLng = ll;
//        this.geoHashGrid = new GeoHashGrid(GeoHashUtil.getGeoHashBase32(GeoHashUtil.HASH_LENGTH, ll.getLat(), ll.getLng()));
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public GeoHashGrid getGeoHashGrid() {
        return geoHashGrid;
    }

    public void setGeoHashGrid(GeoHashGrid geoHashGrid) {
        this.geoHashGrid = geoHashGrid;
    }

}
