package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class NextLevelDB {
    private Map<String, Index> indexes = new HashMap<String, Index>();

    Index getIndex(String name) {
        if (!indexes.containsKey(name))
            return new Index("");
        return indexes.get(name);
    }

    void listIndexes() {
        indexes.forEach((key, value) -> System.out.println(key));
    }

    void createIndex(String name) {
        indexes.put(name, new Index(name));
    }

    void deleteIndex(String name) {
        indexes.remove(name);
    }
}
