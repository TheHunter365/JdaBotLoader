JdaBotLoader
============

This is a small java application to load your jda bots without compiling jda in all your bots !

Usage !
-------
Run JdaBotLoader app in your dedicated server, use the Api to create your bot module and compile it without jda, you can run it in the bot folder like a Spigot plugins !
 
 Bot creation
------
Create new project and add BotLoaderApi
 
 you need a bot.json file like plugin.yml(Spigot Dev)
 
bot.json
```json
{
  "name": "BotName",
  "author": "Author",
  "token": "bot token",
  "mainClass": "path.to.bot.MainClass"
}
```

Bot

Main class 

```java

public class YourBot implements Bot {
    
    @Override
    public void onEnable() {
        
        //Jda instance ^^
        JDA jda = getJda();
        
    }
}
```