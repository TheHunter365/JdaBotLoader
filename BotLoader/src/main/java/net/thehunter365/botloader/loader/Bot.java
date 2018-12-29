package net.thehunter365.botloader.loader;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.thehunter365.botloaderapi.BotLoaderApi;

import javax.security.auth.login.LoginException;

public class Bot implements net.thehunter365.botloaderapi.api.Bot {

    private BotLoaderApi api;

    private JDA jda;

    void init(BotLoaderApi api, BotDescription description) {
        this.api = api;
        try {
            this.jda = new JDABuilder(AccountType.BOT)
                    .setToken(description.getToken()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void onEnable() {

    }

    public BotLoaderApi getApi() {
        return api;
    }

    @Override
    public JDA getJda() {
        return this.jda;
    }
}
