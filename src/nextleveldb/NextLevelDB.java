package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class NextLevelDB {
	private Map<String, Index> indexes = new HashMap<String, Index>();

	void listIndexes() {
	}

	Index getIndex(String name) {
		return new Index("");
	}

	void createIndex(String name) {
	}

	void deleteIndex(String name) {
	}
}
