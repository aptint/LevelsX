package io.aptint.bravelevels.commands;

import io.aptint.bravelevels.BraveLevels;
import dev.evak.levelsx.service.MenuHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BLCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("You must be a player to run open the GUI right now!");
        }


        if (args.length == 0) {
            BraveLevels.getInstance().getMenuHandler().getINVENTORY().open((Player) commandSender);
        } else if (args[0].equalsIgnoreCase("help")) {

        }
        return false;
    }
}
