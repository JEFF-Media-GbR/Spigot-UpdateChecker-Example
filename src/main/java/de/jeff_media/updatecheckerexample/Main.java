package de.jeff_media.updatecheckerexample;

import de.jeff_media.updatechecker.UpdateChecker;
import de.jeff_media.updatechecker.UserAgentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public class Main extends JavaPlugin {

    public void onEnable() {
        getCommand("updatechecker").setExecutor(new UpdateCheckCommand(this));
        getServer().getPluginManager().registerEvents(new UpdateCheckListener(this), this);

        // Example Update Checker
        UpdateChecker.init(this,"https://api.jeff-media.de/chestsort/latest-version.txt")
                .setDownloadLink("https://www.spigotmc.org/resources/chestsort-api.59773/")
                .setChangelogLink("https://www.spigotmc.org/resources/chestsort-api.59773/history")
                .setDonationLink("https://paypal.me/mfnalex")
                .checkEveryXHours(1)
                .checkNow();
    }

    public void example2() {

        // If your plugin has both a paid and free version, you can set two download links.
        // Free users will see both links, while users of the paid version will only see the paid link.
        UpdateChecker.init(this,"https://api.jeff-media.de/angelchest/latest-version.txt")
                .setFreeDownloadLink("https://www.spigotmc.org/resources/angelchest-free.60383/")
                .setPaidDownloadLink("https://www.spigotmc.org/resources/angelchest-plus.88214/")
                .setChangelogLink("https://www.spigotmc.org/resources/angelchest-plus.88214/history")
                .setDonationLink("https://paypal.me/mfnalex")
                .setNameFreeVersion("Free")
                .setNamePaidVersion("Plus")
                .setNotifyOpsOnJoin(true)
                .setColoredConsoleOutput(true)
                .setNotifyByPermissionOnJoin("updatechecker")
                .setUsingPaidVersion(true)
                .setUserAgent(new UserAgentBuilder().addPluginNameAndVersion().addKeyValue("Something","someValue"))
                .checkEveryXHours(0.016667) // Check every minute (first regular check will also be in a minute)
                .checkNow(); // Also check right now
    }
}
