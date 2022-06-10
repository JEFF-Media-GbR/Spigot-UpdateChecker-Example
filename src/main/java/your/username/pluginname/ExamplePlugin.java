package your.username.pluginname;

import com.jeff_media.updatechecker.UpdateCheckSource;
import com.jeff_media.updatechecker.UpdateChecker;
import com.jeff_media.updatechecker.VersionSupplier;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        new UpdateChecker(this, UpdateCheckSource.SPIGOT, "60383") // The Spigot ID of your plugin
                .setDownloadLink("https://downloadlink")
                .checkNow();
    }

}
