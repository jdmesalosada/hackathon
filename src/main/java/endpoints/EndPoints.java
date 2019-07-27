package endpoints;

public enum EndPoints {

    Login("/api/token"),
    Recommendations("/v1/recommendations?market=US&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_tracks=0c6xIDDpzE81m2q797ordA&min_energy=0.4&min_popularity=50"),
    TopPreferences("/v1/me/top/{type}")
    ;

    private final String path;

    EndPoints(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
