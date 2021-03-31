package wtf.hallow.hallowlib.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import wtf.hallow.hallowlib.interfaces.HConsole;

public class Utils implements HConsole {

    private final Console Console = new Console();

    public String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void sendMessage(Object player, String message) {
        if (player instanceof Player) {
            ((Player) player).sendMessage(translate(message));
        } else if (player instanceof CommandSender) {
            ((CommandSender) player).sendMessage(translate(message));
        } else {
            Console.sendMessage(ConsoleStatus.ERROR,"&cA plugin tried to send a message to an object that isn't a player.");
        }
    }

}
