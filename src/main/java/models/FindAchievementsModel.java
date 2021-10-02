package models;

import lombok.RequiredArgsConstructor;
import java.util.TreeMap;

@RequiredArgsConstructor
public class FindAchievementsModel implements Model{
    private final TreeMap<Integer, String> achievementsMap;

    @Override
    public String findById(int id) {
        return achievementsMap.get(id);
    }

    @Override
    public TreeMap<Integer, String> showEverything() {
        return achievementsMap;
    }

}
