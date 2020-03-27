public class location {
    private int streetNumber;
    private String streetName;
    private String cityName;
    private String stateAcronym;
    private int zipCode;
    private String countryName;

    public location(int streetNumber, String streetName, String cityName, String stateAcronym,
                   int zipCode, String countryName) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.stateAcronym = stateAcronym;
        this.zipCode = zipCode;
        this.countryName = countryName;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setStateAcronym(String stateAcronym) {
        this.stateAcronym = stateAcronym;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateAcronym() {
        return stateAcronym;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getFullAddress() {
        return streetNumber + streetName + "," + cityName + stateAcronym + zipCode + "," + countryName;
    }
}