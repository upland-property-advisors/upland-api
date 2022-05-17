package api.upland.me;

import api.upland.me.fetcher.PropertyApiFetcher;
import api.upland.me.fetcher.UplandApiFetcher;
import api.upland.me.fetcher.CitiesApiFetcher;
import api.upland.me.fetcher.CollectionsApiFetcher;
import api.upland.me.fetcher.NeighborhoodsApiFetcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public final class UplandApi {

    private final ExecutorService pool = Executors.newCachedThreadPool();
    public CitiesApiFetcher newCitiesFetcher() {
        return new CitiesApiFetcher(this);
    }
    public NeighborhoodsApiFetcher newNeighborhoodsFetcher() {
        return new NeighborhoodsApiFetcher(this);
    }
    public CollectionsApiFetcher newCollectionsFetcher() {
        return new CollectionsApiFetcher(this);
    }
    public PropertyApiFetcher newPropertyFetcher() {
        return new PropertyApiFetcher(this);
    }

    protected ExecutorService getPool() {
        return pool;
    }
}
