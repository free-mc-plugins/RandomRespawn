package com.ericlam.executors;

import com.ericlam.addon.TPManager;
import com.ericlam.configmanager.Config;
import com.ericlam.main.RandomRespawn;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Randomspawn implements CommandExecutor {
    private final RandomRespawn plugin;
    public Randomspawn(RandomRespawn plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("you are not player!");
            return false;
        }

        Player player = (Player) commandSender;

        if(!player.hasPermission("rr.random")) {
            player.sendMessage(Config.getInstance().getPrefix()+"§c你沒有權限!");
            return false;
        }

        Location spawn = new TPManager().getRandomLocation(player,null);

        player.teleport(spawn);

        return true;

    }
}
