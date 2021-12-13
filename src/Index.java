package nextleveldb;

import java.util.ArrayList;

class Index { // implements Operations
	String name;
	ArrayList<Document> docs;

	Index(String name) {
		this.name = name;
		this.docs = new ArrayList<Document>();
	}
	// add functions for insert, delete, list, connect
}
