package wtf.hallow.hallowlib;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import wtf.hallow.hallowlib.interfaces.HConsole;
import wtf.hallow.hallowlib.utils.Console;
import wtf.hallow.hallowlib.utils.Utils;

public final class HallowLib extends JavaPlugin {

    public static final Utils Utils = new Utils();
    public static final Console Console = new Console();

    private boolean startLoading = false;

    @Override
    public void onLoad() {
        Console.sendMessage(HConsole.ConsoleStatus.INFO, "Hallow Library [Plugin] is loading...");
        startLoading = true;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!startLoading) {
            Console.sendMessage(HConsole.ConsoleStatus.ERROR, "There was an error while the plugin/server was loading.");
            Console.executeCommand("stop");
        } else {
            Console.sendMessage(HConsole.ConsoleStatus.INFO, "Hallow Library [Plugin] has successfully loaded.");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Console.sendMessage(HConsole.ConsoleStatus.INFO,"Hallow Library [Plugin] has been unloaded.");
        Console.sendMessage(HConsole.ConsoleStatus.WARNING, "Since the library is unloaded, any plugins using it will no longer function properly.");
    }
}
