package api.upland.me.response;

import api.upland.me.world.UplandCity;
import api.upland.me.world.UplandFeatures;

import java.util.List;

public class UplandCityFetcherResponse {

    private final List<UplandCity> cities;
    private final UplandFeatures features;

    public UplandCityFetcherResponse(List<UplandCity> cities, UplandFeatures features) {
        this.cities = cities;
        this.features = features;
    }

    public List<UplandCity> getCities() {
        return cities;
    }

    public UplandFeatures getFeatures() {
        return features;
    }
}
