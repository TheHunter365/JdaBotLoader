package net.thehunter365.botloaderapi.api.command;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;

public abstract class Command {

    public abstract String getBotName();

    public abstract String getLabel();

    public abstract Member getSender();

    public abstract TextChannel getChannel();

    public abstract String[] getArgs();


}
