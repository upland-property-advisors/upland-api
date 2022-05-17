package api.upland.me.fetcher;

import api.upland.me.UplandApi;
import api.upland.me.response.UplandCityFetcherResponse;
import api.upland.me.world.UplandCity;
import api.upland.me.world.UplandFeatures;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class CitiesApiFetcher extends UplandApiFetcher<UplandCityFetcherResponse> {

    public CitiesApiFetcher(UplandApi api) {
        super(api, "https://api.upland.me/feature/city");
    }

    @Override
    public UplandCityFetcherResponse handle(JsonObject object) {
        List<UplandCity> cities = new ArrayList<>();
        for (JsonElement element : object.get("cities").getAsJsonArray()) {
            JsonObject city = element.getAsJsonObject();
            int cityId = city.get("city_id").getAsInt();
            String cityName = city.get("city_name").getAsString();
            String stateName = city.get("state_name").getAsString();
            String countryName = city.get("country_name").getAsString();
            cities.add(new UplandCity(cityId, cityName, stateName, countryName));
        }
        List<Integer> treasures = Arrays.asList(GSON.fromJson(object.get("treasures"), Integer[].class));
        List<Integer> standardTreasures = Arrays.asList(GSON.fromJson(object.get("standard_treasure"), Integer[].class));
        List<Integer> collections = Arrays.asList(GSON.fromJson(object.get("collections"), Integer[].class));
        List<Integer> riotMode = Arrays.asList(GSON.fromJson(object.get("riot_mode"), Integer[].class));
        List<Integer> construction = Arrays.asList(GSON.fromJson(object.get("construction"), Integer[].class));
        List<String> nftSwap = Arrays.asList(GSON.fromJson(object.get("nft_swap"), String[].class));
        return new UplandCityFetcherResponse(Collections.unmodifiableList(cities), new UplandFeatures(treasures, standardTreasures, collections, riotMode, construction, nftSwap));
    }
}
