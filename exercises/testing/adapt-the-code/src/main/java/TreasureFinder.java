public class TreasureFinder {

    public String getHint(Position treasurePos) {
        Position userPos = GeolocatorFactory.getDependency().getPosition();
        if (userPos.latitude > 70) {
            return "Nope, the treasure is not at the North Pole.";
        }

        // Not accurate because of the Earth's curvature. Better calculation coming next sprint!
        double diff = Math.sqrt(Math.pow(treasurePos.latitude - userPos.latitude, 2) + Math.pow(treasurePos.longitude - userPos.longitude, 2));

        if (diff < 0.005) {
            return "You're right there!";
        }

        if (diff < 0.05) {
            return "Close...";
        }

        if (diff < 0.5) {
            return "Not too far.";
        }

        return "Far away.";
    }
}
