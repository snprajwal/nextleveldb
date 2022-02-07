package nextleveldb;

class Parser {
	NextLevelDB db = new NextLevelDB();
	Index currentIndex;
	Document currentDocument;

	void parse(String cmd) {
		String identifier;
		String[] tokens = cmd.toLowerCase().split(" ");
		// tokens(0, 1, ...) = {OPERATION, IDENTIFIER, ...VALUES}
		if (tokens[0].equals("exit"))
			System.exit(0);
		if (tokens.length < 2) {
			System.out.println("ERR: Invalid command");
			return;
		}
		identifier = tokens[1];
		switch (identifier) {
		case "index":
			indexHandler(tokens);
			break;
		case "doc":
			documentHandler(tokens);
			break;
		case "pair":
			pairHandler(tokens);
			break;
		default:
			System.out.println("ERR: Invalid identifier " + identifier.toUpperCase());
			break;
		}
	}

	void indexHandler(String[] tokens) {
		String operation = tokens[0];

		if (operation.equals("list")) {
			db.listIndexes();
			return;
		}

		if (tokens.length < 3) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String name = tokens[2];

		switch (operation) {
		case "create":
			if (db.getIndex(name).name.isBlank()) {
				db.createIndex(name);
				System.out.println("Index " + name + " created");
				return;
			}
			System.out.println("ERR: Index already exists");
			return;
		case "connect":
			Index index = db.getIndex(name);
			if (!index.name.isBlank()) {
				currentIndex = index;
				System.out.println("Connected to index " + currentIndex.name);
				return;
			}
			System.out.println("ERR: Index does not exist");
			return;
		case "delete":
			if (!db.getIndex(name).name.isBlank()) {
				if (currentIndex != null)
					if (currentIndex.name.equals(name)) {
						currentIndex = null;
						currentDocument = null;
					}
				db.deleteIndex(name);
				System.out.println("Deleted index " + name);
				return;
			}
			System.out.println("ERR: Index does not exist");
			return;
		default:
			System.out.println("ERR: Invalid operation " + operation.toUpperCase());
			break;
		}
	}

	void documentHandler(String[] tokens) {
		if (currentIndex == null) {
			System.out.println("ERR: Index connection not found");
			return;
		}
		String operation = tokens[0];

		if (operation.equals("list")) {
			currentIndex.listDocuments();
			return;
		}

		if (tokens.length < 3) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String name = tokens[2];

		switch (operation) {
		case "create":
			if (currentIndex.getDocument(name).name.isBlank()) {
				currentIndex.createDocument(name);
				System.out.println("Document " + name + " created");
				return;
			}
			System.out.println("ERR: Document already exists");
			return;
		case "connect":
			Document doc = currentIndex.getDocument(name);
			if (!doc.name.isBlank()) {
				currentDocument = doc;
				System.out.println("Connected to document " + currentDocument.name);
				return;
			}
			System.out.println("ERR: Document does not exist");
			return;
		case "delete":
			if (!currentIndex.getDocument(name).name.isBlank()) {
				if (currentDocument != null)
					if (currentDocument.name.equals(name)) {
						currentDocument = null;
					}
				currentIndex.deleteDocument(name);
				System.out.println("Deleted document " + name);
				return;
			}
			System.out.println("ERR: Document does not exist");
			return;
		default:
			System.out.println("ERR: Invalid operation " + operation.toUpperCase());
			break;
		}
	}

	void pairHandler(String[] tokens) {
		if (currentIndex == null) {
			System.out.println("ERR: Index connection not found");
			return;
		}
		if (currentDocument == null) {
			System.out.println("ERR: Document connection not found");
			return;
		}
		String operation = tokens[0];

		if (operation.equals("list")) {
			currentDocument.listPairs();
			return;
		}

		if (tokens.length < 3) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String key = tokens[2];

		switch (operation) {
		case "get":
			String value = currentDocument.getPair(key);
			if (!value.isBlank()) {
				System.out.println(key + " -> " + value);
				return;
			}
			System.out.println("ERR: Pair does not exist");
			return;
		case "delete":
			if (!currentDocument.getPair(key).isBlank()) {
				currentDocument.deletePair(key);
				System.out.println("Deleted pair " + key);
				return;
			}
			System.out.println("ERR: Pair does not exist");
			return;
		}

		if (tokens.length < 4) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String val = tokens[3];

		switch (operation) {
		case "create":
			if (currentDocument.getPair(key).isBlank()) {
				currentDocument.createPair(key, val);
				System.out.println("Pair " + key + " -> " + val + " created");
				return;
			}
			System.out.println("ERR: Pair already exists");
			return;

		case "update":
			if (!currentDocument.getPair(key).isBlank()) {
				currentDocument.updatePair(key, val);
				return;
			}
			System.out.println("ERR: Pair does not exist");
			return;
		default:
			System.out.println("ERR: Invalid operation " + operation.toUpperCase());
			break;
		}
	}
}
