package s1finalproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserManager userManager = new UserManager();
        String username = null;

        // User login loop
        while (username == null) {
            System.out.println("1. Login Account");
            System.out.println("2. Create new user");
            System.out.println("3. Exit");
            System.out.print("\nSelect option: ");
            String input = sc.nextLine().trim();
            if (input.equals("1")) {
                while (true) {
                    System.out.print("\nEnter Username (or type 'back' to return): ");
                    String u = sc.nextLine();
                    if (u.equalsIgnoreCase("back")) break;
                    System.out.print("Enter Password (or type 'back' to return): ");
                    String p = sc.nextLine();
                    if (p.equalsIgnoreCase("back")) break;
                    if (userManager.login(u, p)) {
                        username = u;
                        System.out.println("\n================================================");
                        System.out.println("Login successful!");
                        System.out.println("================================================");

                        break;
                    } else {
                        System.out.println("\n================================================");
                        System.out.println("Login failed.");
                        System.out.println("================================================");

                    }
                }
            } else if (input.equals("2")) {
                while (true) {
                    System.out.print("\nEnter username (or type 'back' to return): ");
                    String newU = sc.nextLine();
                    if (newU.equalsIgnoreCase("back")) break;
                    System.out.print("Enter password (or type 'back' to return): ");
                    String newP = sc.nextLine();
                    if (newP.equalsIgnoreCase("back")) break;
                    if (userManager.createUser(newU, newP)) {
                        System.out.println("\n================================================");
                        System.out.println("User created successfully!");
                        System.out.println("================================================");

                        break;
                    }
                }
            } else if (input.equals("3")) {
                System.out.println("\n================================================");
                System.out.println("Goodbye!");
                System.out.println("================================================");

                sc.close();
                return;
            } else {
                System.out.println("\n================================================");
                System.out.println("Invalid input. Please enter 1, 2, or 3 only.");
                System.out.println("================================================\n");

            }
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Typing Test Menu ===");
            System.out.println("\n1. Play Ranked");
            System.out.println("2. Play Unranked");
            System.out.println("3. Show Leaderboard");
            System.out.println("4. View My Profile");
            System.out.println("5. Exit");
            System.out.print("\nSelect option: ");
            String menuInput = sc.nextLine().trim();

            switch (menuInput) {
                case "1":
                    RankedTypingTest.playRanked(sc, username);
                    break;
                case "2":
                    UnrankedTypingTest.playUnranked(sc, username);
                    break;
                case "3":
                	LeaderboardMenu.showLeaderboardMenu(sc);
                    break;
                case "4":
                    ProfileManager.showProfile(sc, username);
                    break;
                case "5":
                    exit = true;
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("\nInvalid input.");
            }
        }
        sc.close();
    }
}