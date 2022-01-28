package nextleveldb;

import java.util.Scanner;

class Cli extends Parser {
	final String PROMPT = "# ";
	Scanner s = new Scanner(System.in);

	void run() {
		printLogo();
		while (true) {
			if (super.currentIndex != null)
				System.out.print(super.currentIndex.name);
			if (super.currentDocument != null)
				System.out.print('@' + super.currentDocument.name);
			System.out.print(PROMPT);
			String cmd = s.nextLine();
			if (cmd.isEmpty())
				continue;
			parse(cmd);
		}
	}

	void printLogo() {
		System.out.println(
				" __    __                     __     __                                   __ _______  _______");
		System.out.println(
				"|  \\  |  \\                   |  \\   |  \\                                 |  \\       \\|       \\ ");
		System.out.println(
				"| ▓▓\\ | ▓▓ ______  __    __ _| ▓▓_  | ▓▓       ______  __     __  ______ | ▓▓ ▓▓▓▓▓▓▓\\ ▓▓▓▓▓▓▓\\");
		System.out.println(
				"| ▓▓▓\\| ▓▓/      \\|  \\  /  \\   ▓▓ \\ | ▓▓      /      \\|  \\   /  \\/      \\| ▓▓ ▓▓  | ▓▓ ▓▓__/ ▓▓");
		System.out.println(
				"| ▓▓▓▓\\ ▓▓  ▓▓▓▓▓▓\\\\▓▓\\/  ▓▓\\▓▓▓▓▓▓ | ▓▓     |  ▓▓▓▓▓▓\\\\▓▓\\ /  ▓▓  ▓▓▓▓▓▓\\ ▓▓ ▓▓  | ▓▓ ▓▓    ▓▓");
		System.out.println(
				"| ▓▓\\▓▓ ▓▓ ▓▓    ▓▓ >▓▓  ▓▓  | ▓▓ __| ▓▓     | ▓▓    ▓▓ \\▓▓\\  ▓▓| ▓▓    ▓▓ ▓▓ ▓▓  | ▓▓ ▓▓▓▓▓▓▓\\");
		System.out.println(
				"| ▓▓ \\▓▓▓▓ ▓▓▓▓▓▓▓▓/  ▓▓▓▓\\  | ▓▓|  \\ ▓▓_____| ▓▓▓▓▓▓▓▓  \\▓▓ ▓▓ | ▓▓▓▓▓▓▓▓ ▓▓ ▓▓__/ ▓▓ ▓▓__/ ▓▓");
		System.out.println(
				"| ▓▓  \\▓▓▓\\▓▓     \\  ▓▓ \\▓▓\\  \\▓▓  ▓▓ ▓▓     \\\\▓▓     \\   \\▓▓▓   \\▓▓     \\ ▓▓ ▓▓    ▓▓ ▓▓    ▓▓");
		System.out.println(
				" \\▓▓   \\▓▓ \\▓▓▓▓▓▓▓\\▓▓   \\▓▓   \\▓▓▓▓ \\▓▓▓▓▓▓▓▓ \\▓▓▓▓▓▓▓    \\▓     \\▓▓▓▓▓▓▓\\▓▓\\▓▓▓▓▓▓▓ \\▓▓▓▓▓▓▓");
		System.out.println("\nNextLevelDB © 2021 Prajwal S N, Rahul K, Aum Santosh Patil");
	}

}
