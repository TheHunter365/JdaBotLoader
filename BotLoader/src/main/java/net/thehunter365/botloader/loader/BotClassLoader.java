package net.thehunter365.botloader.loader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BotClassLoader extends URLClassLoader {

    private static Set<BotClassLoader> loaders = new CopyOnWriteArraySet<>();
    public BotClassLoader(URL[] urls) {
        super(urls);

    }
}
