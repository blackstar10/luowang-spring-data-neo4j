package movies.spring.data.neo4j.geohash;

/**
 * Created by libenrong on 2018/7/19.
 *
 * @Description 存储经纬度信息
 */

public class LatLng {
    private double lat;//纬度[-90,90]
    private double lng;//经度[-180,180]

    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatLng ll = (LatLng) o;
        return ll.lat == lat && ll.lng == lng;
    }

    @Override
    public String toString() {
        return "[lat: " + String.valueOf(lat) + " ,lng: " + String.valueOf(lng) + "]";
    }
}
