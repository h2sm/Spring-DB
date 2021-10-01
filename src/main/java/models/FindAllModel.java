package models;

import lombok.RequiredArgsConstructor;

import java.util.TreeMap;

@RequiredArgsConstructor
public class FindAllModel implements Model {
    private final TreeMap<Integer, String> map;

    @Override
    public String findById(int id) {
        return null;
    }

    @Override
    public TreeMap<Integer, String> showEverything() {
        return map;
    }
}
