package com.benfel7.deathswap.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;

import static org.bukkit.scoreboard.RenderType.HEARTS;

public class DSwap implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Bukkit.getOnlinePlayers().forEach(player -> {
            player.setFoodLevel(20);
            player.setHealth(Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getDefaultValue());
        });

        Scoreboard sb = new Scoreboard() {
            @Override
            public Objective registerNewObjective(String name, String criteria) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Objective registerNewObjective(String name, String criteria, String displayName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Objective registerNewObjective(String name, String criteria, String displayName, RenderType renderType) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Objective getObjective(String name) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<Objective> getObjectivesByCriteria(String criteria) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<Objective> getObjectives() {
                return null;
            }

            @Override
            public Objective getObjective(DisplaySlot slot) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<Score> getScores(OfflinePlayer player) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<Score> getScores(String entry) throws IllegalArgumentException {
                return null;
            }

            @Override
            public void resetScores(OfflinePlayer player) throws IllegalArgumentException {

            }

            @Override
            public void resetScores(String entry) throws IllegalArgumentException {

            }

            @Override
            public Team getPlayerTeam(OfflinePlayer player) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Team getEntryTeam(String entry) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Team getTeam(String teamName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<Team> getTeams() {
                return null;
            }

            @Override
            public Team registerNewTeam(String name) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Set<OfflinePlayer> getPlayers() {
                return null;
            }

            @Override
            public Set<String> getEntries() {
                return null;
            }

            @Override
            public void clearSlot(DisplaySlot slot) throws IllegalArgumentException {

            }
        };
        sb.registerNewObjective("Health", "health", "Health", HEARTS);
        Objects.requireNonNull(sb.getObjective("Health")).setDisplaySlot(DisplaySlot.PLAYER_LIST);

        return true;
    }
}
