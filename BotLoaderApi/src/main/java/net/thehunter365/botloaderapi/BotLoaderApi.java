package net.thehunter365.botloaderapi;

import net.thehunter365.botloaderapi.api.BotManager;
import org.slf4j.Logger;

import java.util.concurrent.ExecutorService;

public abstract class BotLoaderApi {

    public abstract ExecutorService getExecutor();

    public abstract BotManager getBotManager();

    public abstract Logger getLogger();
}
