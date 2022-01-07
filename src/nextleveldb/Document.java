package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Document {
	String name;
	private Map<String, String> pairs = new HashMap<String, String>();

	Document(String name) {
		this.name = name;
	}

	String getPair(String key) {
		if (!pairs.containsKey(key))
			return "";
		return pairs.get(key);
	}

	void listPairs() {
		pairs.forEach((key, value) -> System.out.println(key + " -> " + value));
	}

	void createPair(String key, String val) {
		pairs.put(key, val);
	}

	void updatePair(String key, String val) {
		pairs.replace(key, val);
	}

	void deletePair(String key) {
		pairs.remove(key);
	}

}
