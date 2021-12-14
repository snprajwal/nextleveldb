package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Document {
	String name;
	private Map<String, String> pairs = new HashMap<String, String>();

	Document(String name) {
		this.name = name;
	}
	// add functions for create, delete, list, update pairs
}
