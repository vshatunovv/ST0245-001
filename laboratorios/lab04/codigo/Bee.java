
public class Bee
{
    private double latitude;
    private double longitude;
    private double altitude;
    /**
     * This is the constructor method of the class
     * @param latitude: latitud in degrees
     * @param longitude: longitude in degrees
     * @param @altitude: altitude in meters
     */
    public Bee (double latitude, double longitude, double altitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }

    /**
     * Returns the latitude
     * @return latitude
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * Returns the longitude
     * @return longitude
     */
    public double getLongitude(){
        return longitude;
    }

    /**
     * Returns the altitude
     * @return altitude
     */
    public double getAltitude(){
        return altitude;
    }
}