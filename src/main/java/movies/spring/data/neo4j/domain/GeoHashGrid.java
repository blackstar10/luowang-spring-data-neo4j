package movies.spring.data.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class GeoHashGrid extends Entity {

    private String geoHashCode;

    public GeoHashGrid() {
    }

    public GeoHashGrid(String geoHashCode) {
        this.geoHashCode = geoHashCode;
    }

    // todo 导入所有GeoHash和adjacentTo规则
    @Relationship(type = "adjacentTo", direction = Relationship.UNDIRECTED)
    private List<GeoHashGrid> geoHashGridList = new ArrayList<>();


    public String getGeoHashCode() {
        return geoHashCode;
    }

    public void setGeoHashCode(String geoHashCode) {
        this.geoHashCode = geoHashCode;
    }
}
