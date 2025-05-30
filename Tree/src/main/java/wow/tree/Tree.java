package wow.tree;

import java.util.Scanner;
import java.util.ArrayList;

public class Tree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner jm = new Scanner(System.in);

        tree.insert(6);
        tree.insert(100);
        tree.insert(345);
        tree.insert(78);
        tree.insert(23);
        tree.insert(0);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Display Allowances");
            System.out.println("2. Add Allowance");
            System.out.println("3. Exit Program");
            System.out.print("Choose Option: ");

            int choice = jm.nextInt();

            switch (choice) {
                case 1:
                    boolean loop = true;
                    while (loop) {
                        System.out.println("\n--- Choose a sorting method ---");
                        System.out.println("1. Ascending");
                        System.out.println("2. Descending");
                        System.out.println("3. PreOrder");
                        System.out.println("4. PostOrder");
                        System.out.println("5. Back");
                        System.out.print("Choose Option: ");
                        int input = jm.nextInt();

                        ArrayList<Integer> AllowancesList = new ArrayList<>();

                        switch (input) {
                            case 1:
                                System.out.println("\n--- ALLOWANCES LIST ---");
                                System.out.println("Ascending Order: ");
                                ascending(tree.root, AllowancesList);
                                if (AllowancesList.isEmpty()) {
                                    System.out.println("\nNo allowances added yet.");
                                } else {
                                    for (int value : AllowancesList) {
                                        System.out.println(value);
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("\n--- ALLOWANCES LIST ---");
                                System.out.println("Descending Order");
                                descending(tree.root, AllowancesList);
                                if (AllowancesList.isEmpty()) {
                                    System.out.println("\nNo allowances added yet.");
                                } else {
                                    for (int value : AllowancesList) {
                                        System.out.println(value);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("\n--- ALLOWANCES LIST ---");
                                System.out.println("PreOrder: ");
                                tree.preOrder();
                                break;
                            case 4:
                                System.out.println("\n--- ALLOWANCES LIST ---");
                                System.out.println("PostOrder:");
                                tree.postOrder();
                                break;
                            case 5:
                                loop = false;
                                continue;
                            default:
                                System.out.println("Invalid Input");
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n--- ADD ALLOWANCE ---");
                    System.out.print("Input Allowance: ");
                    int allowance = jm.nextInt();
                    tree.insert(allowance);
                    System.out.println("Allowance added.");
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Ascending order (smallest to largest)
    private static void ascending(Node root, ArrayList<Integer> list) {
        if (root != null) {
            ascending(root.left, list);
            list.add(root.value);
            ascending(root.right, list);
        }
    }

    // Descending order (largest to smallest)
    private static void descending(Node root, ArrayList<Integer> list) {
        if (root != null) {
            descending(root.right, list);
            list.add(root.value);
            descending(root.left, list);
        }
    }
}