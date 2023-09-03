package me.workwolf.playerrtp;

import me.workwolf.playerrtp.Utils.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerRTP extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger.log(Logger.LogLevel.INFO, "Plugin created by WorkWolf_2 for Palladiums...");
        Logger.log(Logger.LogLevel.OUTLINE, "*********************");
        Logger.log(Logger.LogLevel.INFO, "Plugin is loading...");
        Logger.log(Logger.LogLevel.INFO, "Commands are loading...");
        registerCommands(this);
        Logger.log(Logger.LogLevel.INFO, "Commands are loaded!");
        Logger.log(Logger.LogLevel.SUCCESS, "Connessione al database riuscita!");
        Logger.log(Logger.LogLevel.SUCCESS, "The plugin has loaded correctly!");
        Logger.log(Logger.LogLevel.OUTLINE, "*********************");
        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerCommands(PlayerRTP plugin) {
        getCommand("playertp").setExecutor(new me.workwolf.playerrtp.Commands.PlayerRTP());
    }


}

