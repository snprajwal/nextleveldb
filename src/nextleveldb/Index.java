package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Index {
	String name;
	private Map<String, Document> docs = new HashMap<String, Document>();

	Index(String name) {
		this.name = name;
	}

	Document getDocument(String name) {
		if (!docs.containsKey(name))
			return new Document("");
		return docs.get(name);
	}

	void listDocuments() {
		docs.forEach((key, value) -> System.out.println(key));
	}

	void createDocument(String name) {
		docs.put(name, new Document(name));
	}

	void deleteDocument(String name) {
		docs.remove(name);
	}
}
