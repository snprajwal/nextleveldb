package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class NextLevelDB {
	private Map<String, Index> indexes = new HashMap<String, Index>();

	void listIndexes() {
        	for (Map.Entry pairEntry: indexes.entrySet()) {
			    System.out.println(pairEntry.getKey()+":"+pairEntry.getValue());}
	}

	Index getIndex(String name) {
        if (!indexes.containsValue(name)){
            return new Index("");}
        else{
            return indexes.get(name); 
        }
    }
	void createIndex(String name) {
        indexes.put(name,getIndex(name));
    }

	void deleteIndex(String name) {
        indexes.remove(name);
	}
}
