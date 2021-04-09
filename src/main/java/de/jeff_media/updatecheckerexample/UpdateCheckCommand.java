package de.jeff_media.updatecheckerexample;

import de.jeff_media.updatechecker.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class UpdateCheckCommand implements CommandExecutor {

    private final Main main;

    public UpdateCheckCommand(Main main) {
        this.main=main;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {

        // Check for updates and send result to the one who entered the command
        if(args.length==0) {
            UpdateChecker.getInstance().checkNow(commandSender);
            return true;
        }

        if(args.length==1) {

            // Check for updates and send result to all players
            if(args[0].equalsIgnoreCase("players")) {
                UpdateChecker.getInstance().checkNow(Bukkit.getOnlinePlayers().toArray(new Player[0]));
                return true;
            }

            // Check for updates and send result to all players and console
            if(args[0].equalsIgnoreCase("all")) {
                List<CommandSender> everyone = new ArrayList<>(Bukkit.getOnlinePlayers());
                everyone.add(Bukkit.getConsoleSender());
                UpdateChecker.getInstance().checkNow(everyone.toArray(new CommandSender[0]));
            }

        }

        commandSender.sendMessage("Usage: /updatechecker [players|all]");
        return true;
    }
}
