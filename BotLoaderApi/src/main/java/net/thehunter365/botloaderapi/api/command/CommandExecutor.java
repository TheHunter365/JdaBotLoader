package net.thehunter365.botloaderapi.api.command;

import net.dv8tion.jda.core.entities.TextChannel;

import java.lang.reflect.Member;

public interface CommandExecutor {

    void execute(String label, Member sender, TextChannel channel, String[] args);
}
