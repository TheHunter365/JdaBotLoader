package net.thehunter365.botloader;

import net.thehunter365.botloaderapi.loader.BotLoader;
import net.thehunter365.botloaderapi.BotLoaderApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BotLoaderApp extends BotLoaderApi {

    private ExecutorService executor;

    private BotLoader botLoader;

    private Logger logger;

    public BotLoaderApp() {

        this.logger = LoggerFactory.getLogger(BotLoaderApp.class);

        this.executor = Executors.newFixedThreadPool(2);
        this.botLoader = new BotLoader(this);

    }

    public void loadBots() {
        logger.info("Starting bot loader !");
        this.botLoader.loadBots();
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public BotLoader getBotManager() {
        return botLoader;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
