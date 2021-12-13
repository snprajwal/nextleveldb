package nextleveldb;

import java.util.ArrayList;

interface Operations {
	void create();

	void delete();

	void list();
}

class NextLevelDB {
	ArrayList<Index> indexes;

	NextLevelDB() {
		indexes = new ArrayList<Index>();
	}

	public static void main(String[] args) {
		Cli cli = new Cli();
		cli.printLogo();
		cli.run();
	}
}
