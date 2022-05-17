package api.upland.me.world;

public final class UplandCity {
    private final int cityId;
    private final String cityName;
    private final String stateName;
    private final String countryName;

    public UplandCity(int cityId, String cityName, String stateName, String countryName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
    }

    public int getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return countryName;
    }
}
