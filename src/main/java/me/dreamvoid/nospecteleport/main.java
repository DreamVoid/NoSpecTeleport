package me.dreamvoid.nospecteleport;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e){
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.SPECTATOR) && !p.hasPermission("nospecteleport.bypass")){
            e.setCancelled(true);
        }
    }
}
