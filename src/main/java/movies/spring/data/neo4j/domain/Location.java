package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.geohash.GeoHashUtil;
import movies.spring.data.neo4j.geohash.LatLng;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author sunqiu
 */
public class Location extends Entity {

    private String locationName;
    private double lat;
    private double lng;

    @Relationship(type = "locatedOn")
    private GeoHashGrid geoHashGrid;

    public Location() {
    }

    public Location(String locationName, double lat, double lng) {
        this.locationName = locationName;
        this.lat = lat;
        this.lng = lng;
    }

    public Location(String locationName, LatLng ll) {
        this.locationName = locationName;
        this.lat = ll.getLat();
        this.lng = ll.getLng();
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public GeoHashGrid getGeoHashGrid() {
        return geoHashGrid;
    }

    public void setGeoHashGrid(GeoHashGrid geoHashGrid) {
        this.geoHashGrid = geoHashGrid;
    }

}
