package net.thehunter365.botloaderapi.api;

import net.dv8tion.jda.core.JDA;
import net.thehunter365.botloaderapi.BotLoaderApi;

public interface Bot {

    void onEnable();

    BotLoaderApi getApi();

    JDA getJda();

}
