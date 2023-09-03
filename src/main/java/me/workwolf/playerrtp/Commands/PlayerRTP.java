package me.workwolf.playerrtp.Commands;

import me.workwolf.playerrtp.Utils.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRTP implements CommandExecutor {
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if (!(cs instanceof Player)) {
            Logger.log(Logger.LogLevel.WARNING, "Solo un giovatore può eseguire questo comando!");
            return true;
        }

        Player player = (Player) cs;

        if (!player.hasPermission("playertp.rtp")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Palladiums&7] Non hai il permesso per eseguire questo comando!"));
        }

        List<Player> players = new ArrayList<>(getOnlinePlayer());
        List<Location> locations = new ArrayList<>();

        if (players.isEmpty()) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Palladiums&7] Nessun player online sul server!"));
            return true;
        }

        for (Player onlinePlayer : players) {
            locations.add(onlinePlayer.getLocation());
        }

        int randomPlayer = (int) Math.floor(Math.random() * getOnlinePlayer().size());
        Player targetPlayer = players.get(randomPlayer);

        String targetPlayerName = "%target_player%";

        player.teleport(locations.get(randomPlayer));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&6Palladiums&7] Sei stato tippato da " + targetPlayerName.replace("%target_player%", targetPlayer.getDisplayName())));

        return true;
    }

    public List<Player> getOnlinePlayer() {
        List<Player> Onlineplayers = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            Onlineplayers.add(player);
            if (player.hasPermission("playertp.staff")) {
                Onlineplayers.remove(player);
            }
        }

        return Onlineplayers;
    }

}
