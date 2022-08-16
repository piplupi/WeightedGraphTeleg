package sr.unasat.entity;

public class Hubs {

    public String name;

    public String geoLocation;

    public Hubs(String name, String geoLocation) {
        this.name = name;
        this.geoLocation = geoLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public String toString() {
        return "Hubs{" +
                "name='" + name + '\'' +
                ", geoLocation=" + geoLocation +
                '}';
    }
}
