public class GeolocatorFactory {
    private static Geolocator dependency = new UserGeolocator();

    public static Geolocator getDependency() {
        return dependency;
    }

    public static void setDependency(Geolocator dependency) {
        GeolocatorFactory.dependency = dependency;
    }
}
