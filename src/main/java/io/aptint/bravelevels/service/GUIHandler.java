package io.aptint.bravelevels.service;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GUIHandler implements InventoryHolder, Listener {


    private final Inventory inventory;

    public GUIHandler() {
        inventory = Bukkit.createInventory(this, 54, "");

        initItems();
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    private void initItems() {

    }

    @EventHandler
    public void onInteractEvent(InventoryInteractEvent event) {
        if()
    }
}