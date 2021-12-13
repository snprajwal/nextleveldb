package nextleveldb;

import java.util.Scanner;

class Cli {
	void run() {
		Scanner s = new Scanner(System.in);
		Parser parser = new Parser();
		while (true) {
			System.out.print(">");
			String cmd = s.nextLine();
			if (cmd.isEmpty())
				continue;
			parser.parse(cmd);
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
