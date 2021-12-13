package nextleveldb;

import java.util.ArrayList;

class Document {// implements Operations
	String name;
	Index index;
	ArrayList<Pair> pairs;

	Document(Index index, String name) {
		this.name = name;
		this.index = index;
		this.pairs = new ArrayList<Pair>();
	}
	// add functions for create, delete, list
}
