package wtf.hallow.hallowlib.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import wtf.hallow.hallowlib.HallowLib;
import wtf.hallow.hallowlib.interfaces.HConsole;

public class Console implements HConsole {

    private HallowLib plugin;

    public Console() {
        plugin = HallowLib.getPlugin(HallowLib.class);
    }

    private final Utils Utils = new Utils();

    public void sendMessage(ConsoleStatus status, String message) {
        if (status == ConsoleStatus.INFO) {
            Bukkit.getConsoleSender().sendMessage(Utils.translate("&a[INFO] &r" + message));
        } else if (status == ConsoleStatus.WARNING) {
            Bukkit.getConsoleSender().sendMessage(Utils.translate("&6[WARNING] &r" + message));
        } else if (status == ConsoleStatus.ERROR) {
            Bukkit.getConsoleSender().sendMessage(Utils.translate("&c[ERROR] &r" + message));
        } else if (status == ConsoleStatus.SEVERE) {
            Bukkit.getConsoleSender().sendMessage(Utils.translate("&4[SEVERE] &r" + message));
            new BukkitRunnable() {
                @Override
                public void run() {
                    executeCommand("stop");
                }
            }.runTaskLater(plugin, 10);
        }
    }

    public void executeCommand(String command) {
        this.sendMessage(ConsoleStatus.INFO, "Console executed command [" + command + "] successfully.");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
    }
}