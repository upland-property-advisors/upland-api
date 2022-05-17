package api.upland.me.fetcher;

import api.upland.me.concurrency.InstantFuture;
import api.upland.me.UplandApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

abstract class UplandApiFetcher<T> {
    /**
     * A general purpose {@link Gson} instance.
     */
    public static final Gson GSON = new GsonBuilder().disableHtmlEscaping().disableInnerClassSerialization().
            setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    private final ExecutorService pool;
    private final String link;
    private volatile boolean async;

    protected UplandApiFetcher(ExecutorService pool, String link) {
        this.pool = pool;
        this.link = link;
    }

    public final Future<T> fetch() {
        if (async) {
            return pool.submit(this::handleSynchronous);
        } else {
            return new InstantFuture<>(handleSynchronous());
        }
    }

    public UplandApiFetcher<T> setAsynchronous() {
        async = true;
        return this;
    }

    private T handleSynchronous() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(link).openStream())) {
            return handle(GSON.fromJson(new String(in.readAllBytes()), JsonElement.class).getAsJsonObject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public abstract T handle(JsonObject object);
}
