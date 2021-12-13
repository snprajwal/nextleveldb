package nextleveldb;

class Parser {
	String id, op, key, value;

	void parse(String cmd) {
		String[] tokens = cmd.toLowerCase().split(" ");
		// tokens(0, 1, 2) = {IDENTIFIER, OPERATION ...VALUES}
		this.id = tokens[0];
		if (tokens.length > 1) {
			this.op = tokens[1];
			this.key = tokens[2];
		}
		if (tokens.length > 3)
			this.value = tokens[3];
	}
}
