package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Index {
	String name;
	private Map<String, Document> docs = new HashMap<String, Document>();

	Index(String name) {
		this.name = name;
	}
	void listDocuments(){
	}
	void createDocument(){
	}
	void deleteDocument(){
	}
	// add functions for insert, delete, list, connect
}
