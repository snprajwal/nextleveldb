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
	}

	void pairHandler(String[] tokens) {
	}

}
