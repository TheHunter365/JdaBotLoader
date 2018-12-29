package net.thehunter365.botloader;

import net.thehunter365.botloader.loader.BotLoader;
import net.thehunter365.botloaderapi.BotLoaderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BotLoaderApp extends BotLoaderApi {

    private Logger logger;

    private ExecutorService executor;

    private BotLoader botLoader;

    public BotLoaderApp() {
        this.logger = LoggerFactory.getLogger(BotLoaderApp.class);

        this.executor = Executors.newFixedThreadPool(2);
        this.botLoader = new BotLoader(this);

        logger.info("Starting Bots loading !");

        this.botLoader.loadBots();
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public Logger getLogger() {
        return logger;
    }

    public BotLoader getBotManager() {
        return botLoader;
    }
}
