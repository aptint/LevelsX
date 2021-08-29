package io.aptint.bravelevels.events;

import io.aptint.bravelevels.BraveLevels;
import dev.evak.levelsx.service.MenuHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuInteractEvent implements Listener {

    private InventoryHolder menuHandler = BraveLevels.getInstance().getMenuHandler().getINVENTORY;

    @EventHandler
    public void onInteract(InventoryClickEvent event) {

        if(!((event.getInventory().getHolder()) instanceof menuHandler.getINVENTORY().getHolder()))
        event.getWhoClicked().sendMessage(event);
        event.getWhoClicked().sendMessage(BraveLevels.getInstance().getMenuHandler().getINVENTORY().getTitle());
        if(!event.getInventory().getTitle().equalsIgnoreCase(BraveLevels.getInstance().getMenuHandler().getINVENTORY().getTitle())) return;

        event.setCancelled(true);
        event.getWhoClicked().sendMessage("NO!");
    }
}
