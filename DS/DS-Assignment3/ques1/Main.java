package ques1;

import java.util.Scanner;

/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		System.out.println("****** Virtual Command Prompt ******");
		DirectoryTree directory = new DirectoryTree();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("[gh0st]#[" + directory.getCurrentDir() + "] >> ");
			String cmdQuery = sc.nextLine();
			String[] cmd = cmdQuery.split(" ");
			switch (cmd[0]) {
			case "mkdir":
				directory.mkdir(cmd[1]);
				break;
			case "cd":
				directory.cd(cmd[1]);
				break;
			case "bk":
				directory.bk();
				break;
			case "ls":
				directory.ls();
				break;
			case "find":
				directory.find(cmd[1],directory.rootDir);
				break;
			case "tree":
				directory.tree(directory.rootDir);
				break;
			case "exit":
				System.exit(0);
			default:
				System.out.println("command not found");
			}
		}
	}
}
