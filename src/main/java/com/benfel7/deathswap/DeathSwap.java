package com.benfel7.deathswap;

import com.benfel7.deathswap.commands.DSwap;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class DeathSwap extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("dswap")).setExecutor(new DSwap());
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "DeathSwap Started");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "DeathSwap Closed");
    }
}
