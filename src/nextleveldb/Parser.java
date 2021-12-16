package nextleveldb;

class Parser {
	NextLevelDB db = new NextLevelDB();
	Index ind = new Index();
	Document doc = new Document();
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
		case "document":
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
		Index index;
		switch (operation) {
		case "create":
			if (!db.getIndex(name).name.equals("")) {
				db.createIndex(name);
				System.out.println("Index " + name + " created");
				return;
			}
			System.out.println("ERR: Index already exists");
			return;
		case "connect":
			index = db.getIndex(name);
			if (!index.name.equals("")) {
				currentIndex = index;
				System.out.println("Connected to index " + currentIndex.name);
				return;
			}
			System.out.println("ERR: Index does not exist");
			return;
		case "delete":
			index = db.getIndex(name);
			if (!index.name.equals("")) {
				if (currentIndex.name.equals(name)) {
					currentIndex = null;
				}
				db.deleteIndex(name);
				System.out.println("Deleted index " + name);
				return;
			}
			System.out.println("ERR: Index does not exist");
			return;
		}
	}

	void documentHandler(String[] tokens) {
		String operation = tokens[0];
		if (operation.equals("list")) {
			ind.listDocument();
			return;
		}
		if (tokens.length < 3) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String name = tokens[2];
		Document document;
		switch (operation) {
		case "create":
			if (!ind.getDocument(name).name.equals("")) {
				ind.createDocument(name);
				System.out.println("Document " + name + " created");
				return;
			}
			System.out.println("ERR: Document already exists");
			return;
		case "connect":
			document = ind.getDocument(name);
			if (!index.name.equals("")) {
				currentDocument = document;
				System.out.println("Connected to document " + currentDocument.name);
				return;
			}
			System.out.println("ERR: Document does not exist");
			return;
		case "delete":
			document = db.getDocument(name);
			if (!document.name.equals("")) {
				if (currentDocument.name.equals(name)) {
					currentDocument = null;
				}
				ind.deleteDocument(name);
				System.out.println("Deleted document " + name);
				return;
			}
			System.out.println("ERR: Document does not exist");
			return;
		}
	}
	}

	void pairHandler(String[] tokens) {
		String operation = tokens[0];
		if (operation.equals("list")) {
			doc.listPairs();//lists pairs in current document
			return;
		}
		if (tokens.length < 3) {
			System.out.println("ERR: Insufficient arguments for operation " + operation.toUpperCase());
			return;
		}
		String name = tokens[2];
		Pair pair;
		switch (operation) {
		case "create":
			if (!ind.getIndex(name).name.equals("")) {
				doc.createPair(name);
				System.out.println("Index " + name + " created");
				return;
			}
			System.out.println("ERR: Index already exists");
			return;

		case "update":
			if (!db.getIndex(name).name.equals("")) {
				doc.updatePair(name);
				System.out.println("Index " + name + " created");
				return;
			}
			System.out.println("ERR: Index already exists");
			return;
			}

		case "delete":
			index = db.getIndex(name);
			if (!index.name.equals("")) {
				if (currentIndex.name.equals(name)) {
					currentIndex = null;
				}
				doc.deletePair(name);
				System.out.println("Deleted index " + name);
				return;
			}
			System.out.println("ERR: Index does not exist");
			return;
		}
	}
	}

}
