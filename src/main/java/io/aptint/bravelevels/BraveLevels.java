package io.aptint.bravelevels;

import io.aptint.bravelevels.commands.BLCommand;
import io.aptint.bravelevels.events.MenuInteractEvent;
import io.aptint.bravelevels.service.LevelHandler;
import io.aptint.bravelevels.service.MenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BraveLevels extends JavaPlugin {

    private static BraveLevels instance;
    private InventoryManager inventoryManager;
    private MenuHandler menuHandler;
    private LevelHandler levelHandler;

    @Override
    public void onEnable() {
        instance = this;
        inventoryManager = new InventoryManager(this);
        menuHandler = new MenuHandler(color(getConfig().getString("settings.menu.title")), getConfig().getInt("settings.menu.rows"), getConfig().getConfigurationSection("levels"));
        levelHandler = new LevelHandler();
        getServer().getPluginManager().registerEvents(new MenuInteractEvent(),this);
        Bukkit.getPluginCommand("levels").setExecutor(new BLCommand());
        reloadConfig();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        for(Player player : getMenuHandler ().getINVENTORY().getManager().getOpenedPlayers(getMenuHandler().getINVENTORY())) {
            getMenuHandler().getINVENTORY().close(player);
        }
        super.onDisable();
    }

    public static BraveLevels getInstance() {
        return instance;
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public MenuHandler getMenuHandler() {
        return menuHandler;
    }

    public LevelHandler getLevelHandler() {
        return levelHandler;
    }

    public String color(String colorize) {
        return ChatColor.translateAlternateColorCodes('&', colorize);
    }
}

