package nextleveldb;

class Pair { // implements Operations
	String key, value;
	Document doc;

	Pair(Document doc, String key, String value) {
		this.doc = doc;
		this.key = key;
		this.value = value;
	}
	// add functions for create, delete, list, update
}
