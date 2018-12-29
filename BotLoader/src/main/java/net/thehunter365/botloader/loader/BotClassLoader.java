package net.thehunter365.botloader.loader;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class BotClassLoader extends URLClassLoader {

    private static Set<BotClassLoader> loaders = new CopyOnWriteArraySet<>();

    static {
        ClassLoader.registerAsParallelCapable();
    }

    public BotClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return loadClass(name, resolve, true);
    }

    private Class<?> loadClass(String name, boolean resolve, boolean checkOther) throws ClassNotFoundException {
        try {
            return super.loadClass(name, resolve);
        } catch (ClassNotFoundException ignored) {}

        if (checkOther) {
            for (BotClassLoader loader : loaders) {
                if (loader != this) {
                    try {
                        return loader.loadClass(name, resolve, false);
                    } catch (ClassNotFoundException ignored) {}
                }
            }
        }
        throw new ClassNotFoundException(name);
    }
}
