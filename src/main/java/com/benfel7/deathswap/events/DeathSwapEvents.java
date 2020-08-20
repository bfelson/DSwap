package com.benfel7.deathswap.events;

import com.benfel7.deathswap.commands.DSwap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.EventListener;

public class DeathSwapEvents implements Listener {

    @EventHandler
    public void playerDies(PlayerDeathEvent death) {
        Player loser = death.getEntity();
        loser.sendMessage("You lose!");
    }

    @EventHandler
    public static void swap() {

    }
}
