package api.upland.me.fetcher;

import api.upland.me.UplandApi;
import api.upland.me.response.CollectionsApiResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public final class CollectionsApiFetcher extends UplandApiFetcher<CollectionsApiResponse> {
    protected CollectionsApiFetcher(UplandApi api) {
        super(api, "https://api.upland.me/collections");
    }

    @Override
    public CollectionsApiResponse handle(JsonObject object) {
        Map<String, CityCollection> collections = new HashMap<>();
        for (JsonElement element : data) {
            JsonObject object = element.getAsJsonObject();
            int id = object.get("id").getAsInt();
            String name = object.get("name").getAsString();
            int category = object.get("category").getAsInt();
            String requirements = object.get("name").getAsString();
            collections.put(name, new CityCollection(id, name, requirements, category));
        }
        return new CollectionsApiResponse();
    }
}
