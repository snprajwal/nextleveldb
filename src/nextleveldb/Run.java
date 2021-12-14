package nextleveldb;

/* Run the project with:
 * javac -d build/ src/nextleveldb/*.java
 * java -cp build/ nextleveldb.Run
*/

class Run {
	public static void main(String[] args) {
		Cli cli = new Cli();
		cli.run();
	}
}
