package de.jeff_media.updatecheckerexample;

import de.jeff_media.updatechecker.UpdateCheckEvent;
import de.jeff_media.updatechecker.UpdateCheckResult;
import de.jeff_media.updatechecker.UpdateCheckSuccess;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UpdateCheckListener implements Listener {

    private final Main main;

    UpdateCheckListener(Main main) {
        this.main=main;
    }

    @EventHandler
    public void onUpdateCheck(UpdateCheckEvent event) {
        if(event.getRequesters()==null) return;

        for(CommandSender sender : event.getRequesters()) {
            main.getLogger().info(sender.getName() + " has requested an update check, aaaaaaaand...");
        }

        if(event.getSuccess() == UpdateCheckSuccess.FAIL) {
            main.getLogger().info("it failed, lol");
        } else if(event.getResult() == UpdateCheckResult.NEW_VERSION_AVAILABLE) {
            main.getLogger().info("there is a new version available: "+event.getLatestVersion());
        } else {
            main.getLogger().info("you are running the latest version :)");
        }

    }
}
