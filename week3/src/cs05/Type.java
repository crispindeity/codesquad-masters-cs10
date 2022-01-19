package cs05;

import java.util.HashMap;
import java.util.Map;

public class Type {

    private final Map<String, Integer> types = new HashMap<>();

    private boolean isEmptyType(String typeName) {
        return types.containsKey(typeName);
    }

    public boolean setTypeSize(String typeName, int size) {
        if (isEmptyType(typeName)) {
            return false;
        }
        types.put(typeName, size);
        return true;
    }
}