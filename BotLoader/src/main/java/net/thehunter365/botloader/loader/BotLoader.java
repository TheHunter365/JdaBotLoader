package net.thehunter365.botloader.loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.thehunter365.botloaderapi.BotLoaderApi;
import net.thehunter365.botloaderapi.api.Bot;
import net.thehunter365.botloaderapi.api.BotManager;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class BotLoader implements BotManager {

    private BotLoaderApi botLoaderApi;
    private Gson gson;
    private File botsFolder;

    private Map<String, BotDescription> botsToLoad;
    private Map<String, Bot> bots;


    public BotLoader(BotLoaderApi botLoaderApi) {
        this.botLoaderApi = botLoaderApi;
        this.botsFolder = new File("./bots/");
        if (!botsFolder.exists()) {
            botsFolder.mkdir();
        }

        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        this.botsToLoad = new HashMap<>();
        this.bots = new LinkedHashMap<>();
    }

    public Collection<Bot> getBots() {
        return this.bots.values();
    }

    private void detectBots() {
        for (File file : Objects.requireNonNull(botsFolder.listFiles())) {
            if (file.isFile() && file.getName().endsWith(".jar")) {
                try (JarFile jar = new JarFile(file)) {
                    JarEntry info = jar.getJarEntry("bot.json");

                    if (info != null) {
                        this.botLoaderApi.getLogger().error("Failed to load bot.json file in " + file.getName());
                    } else {
                        try (InputStream is = jar.getInputStream(info)) {
                            BotDescription description = load(is, BotDescription.class);

                            assert description != null;
                            description.setFile(file);
                            botsToLoad.put(description.getName(), description);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void loadBot(BotDescription description) {
        try {
            URLClassLoader loader = new BotClassLoader(new URL[] {description.getFile().toURI().toURL()});

            Class<?> main = ((BotClassLoader) loader).loadClass(description.getMainClass());
            net.thehunter365.botloader.loader.Bot botClass = (net.thehunter365.botloader.loader.Bot) main.getDeclaredConstructor().newInstance();

            botClass.init(this.botLoaderApi, description);

            botLoaderApi.getLogger().info("Succesfully loaded " + description.getName() + " Bot !");
            botLoaderApi.getExecutor().submit(botClass::onEnable);
            bots.put(description.getName(), botClass);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void loadBots() {
        detectBots();
        this.botsToLoad.values().parallelStream().forEach(this::loadBot);
    }

    private <T> T load(InputStream is, Class<T> tClass) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return this.gson.fromJson(reader, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
