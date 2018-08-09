package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.geohash.GeoHashUtil;
import movies.spring.data.neo4j.geohash.LatLng;
import org.neo4j.ogm.annotation.Relationship;

public class Location extends Entity {

    private String locationName;
    private LatLng latLng;
    @Relationship(type = "locatedOn")
    private GeoHashGrid geoHashGrid;

    public Location() {
    }

    public Location(String locationName, double lat, double lng) {
        this.locationName = locationName;
        this.latLng = new LatLng(lat, lng);
        this.geoHashGrid = new GeoHashGrid(GeoHashUtil.getGeoHashBase32(GeoHashUtil.HASH_LENGTH, lat, lng));
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
}
