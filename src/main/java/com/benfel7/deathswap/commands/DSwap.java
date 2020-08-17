package com.benfel7.deathswap.commands;

import org.bukkit.*;
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

        Player player1 = Bukkit.getPlayer(args[0]);
        Player player2 = Bukkit.getPlayer(args[1]);

        World world = player1.getWorld();

        player1.sendMessage(ChatColor.RED + "Your mission is to kill " + player2.getName());
        player2.sendMessage(ChatColor.RED + "Your mission is to kill " + player1.getName());

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

        if (args.length == 3) {
            int maxSpread = Integer.parseInt(args[2]);
            Location p1random = new Location(world, (int) (Math.random() * maxSpread), (int) (Math.random() * maxSpread), (int) (Math.random() * maxSpread));
            Location p2random = new Location(world, (int) (Math.random() * maxSpread), (int) (Math.random() * maxSpread), (int) (Math.random() * maxSpread));
            player1.teleport(p1random);
            player2.teleport(p2random);

            int distance = (int) p1random.distance(p2random);
        }
        return true;
    }

}
