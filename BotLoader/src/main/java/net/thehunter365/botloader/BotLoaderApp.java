package net.thehunter365.botloader;

import com.google.gson.Gson;
import net.thehunter365.botloaderapi.BotLoaderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BotLoaderApp extends BotLoaderApi {

    private Logger logger;

    private ExecutorService executor;

    private Gson gson;

    public BotLoaderApp() {
        this.logger = LoggerFactory.getLogger(BotLoaderApp.class);

        this.executor = Executors.newFixedThreadPool(2);
    }


    public ExecutorService getExecutor() {
        return executor;
    }

    public Logger getLogger() {
        return logger;
    }
}
