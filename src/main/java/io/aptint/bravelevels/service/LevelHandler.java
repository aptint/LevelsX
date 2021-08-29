package io.aptint.bravelevels.service;

import java.util.HashMap;
import java.util.Map;

public class LevelHandler {

    private Map<String, Level> levelMap;

    public LevelHandler() {
        this.levelMap = new HashMap<>();
    }

    public Map<String, Level> getLevelMap() {
        return levelMap;
    }

    public boolean addLevelMap(Level level) {
        if(levelMap.containsKey(level.getName())) return false;
        this.levelMap.put(level.getName(), level);
        return true;
    }

    public boolean removeLevelMap(Level level) {
        if(levelMap.containsKey(level.getName())) return false;
        this.levelMap.remove(level.getName());
        return true;
    }

    public boolean inLevelMap(Level level) {
        if(levelMap.containsKey(level.getName()) || levelMap.containsValue(level)) return true;
        return false;
    }
}
