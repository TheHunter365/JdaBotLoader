package net.thehunter365.botloader.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonManager {

    private Gson gson;

    public JsonManager() {
        this.gson = new GsonBuilder().setPrettyPrinting()
                .serializeNulls()
                .create();
    }

    public Gson getGson() {
        return gson;
    }

    public <T> T fromGson(String json, Class<T> tClass) {
        return this.gson.fromJson(json, tClass);
    }

    public String toJson(GsonSerializable gsonSerializable) {
        return this.gson.toJson(gsonSerializable);
    }
}
