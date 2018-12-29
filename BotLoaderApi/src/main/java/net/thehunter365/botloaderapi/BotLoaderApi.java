package net.thehunter365.botloaderapi;

import org.slf4j.Logger;

import java.util.concurrent.ExecutorService;

public abstract class BotLoaderApi {

    public abstract ExecutorService getExecutor();

    public abstract Logger getLogger();
}
