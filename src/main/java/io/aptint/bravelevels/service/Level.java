package io.aptint.bravelevels.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Level {

    private String name;
    private int cost;
    /*
    TODO: Add items in config to each level. Design item builder.
    private List<String> itemsList;
     */
    private List<String> commandList;

    public Level(ConfigurationSection section) {
        this.name = section.getString("name");
        this.cost = section.getInt("cost");
        //this.itemsList = section.getStringList("items");
        this.commandList = section.getStringList("commands");
        build();
    }

    public void build() {
        /*if(!itemsList.isEmpty()) {
            ItemStack itemStack;
            for(String str : itemsList) {
                String splitList[] = str.split(", ");
                for(String split : splitList) {
                    //if(!split.contains()) break;
                    break;
                }
            }
        }*/
        if(!commandList.isEmpty()) {
            List<String> newCList = new ArrayList<>();
            for(String str : commandList) {
                str = str.startsWith("/") ? str.replaceFirst("/", "") : str.toString();
                newCList.add(str);
            }
            setCommandList(newCList);
        }
    }

}