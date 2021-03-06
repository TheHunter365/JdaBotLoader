package net.thehunter365.botloaderapi.api;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.thehunter365.botloaderapi.BotLoaderApi;
import net.thehunter365.botloaderapi.loader.BotDescription;

import javax.security.auth.login.LoginException;
import java.io.File;

public abstract class Bot {

    private BotLoaderApi api;
    private JDA jda;
    private File dataFolder;

    public void onEnable() {

    }

    public void init(BotLoaderApi api, BotDescription description, File dataFolder) {
        this.api = api;
        this.dataFolder = dataFolder;
        try {
            this.jda = new JDABuilder(AccountType.BOT)
                    .setToken(description.getToken()).build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
    public BotLoaderApi getApi() {
        return this.api;
    }

    public JDA getJda() {
        return jda;
    }

    public File getDataFolder() {
        return dataFolder;
    }
}
