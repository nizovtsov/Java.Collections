package MainTask.HomeElectricalAppliances;

import java.util.Scanner;

public class Main {
    private static String[] operationNames = {
            "1. Add room",
            "2. Add unit",
            "3. Delete unit",
            "4. Turn on unit",
            "5. Turn off unit",
            "6. Show all units",
            "7. Show enabled and sorted units",
            "8. Show total actual power",
            "9. Find unit",
            "0. Exit"
    };

    private static HomeControlUnit homeControlUnit;

    public static void main(String[] args) {
        homeControlUnit = new HomeControlUnit();
        menu();
    }

    private static void menu() {
        boolean isTrue = true;
        while (isTrue) {
            printMenu();
            int n = inputInt("operation number: ");
            switch (n) {
                case 1:
                    homeControlUnit.addNewRoom(inputString("Room name :"));
                    break;
                case 2:
                    homeControlUnit.addNewUnit(inputString("Unit name: "), inputInt("Unit power: "),
                            inputString("Existing room name: "));
                    break;
                case 3:
                    homeControlUnit.deleteUnit(inputInt("Existing unit index: "));
                    break;
                case 4:
                    homeControlUnit.powerOnUnit(inputInt("Existing unit index: "));
                    break;
                case 5:
                    homeControlUnit.powerOffUnit(inputInt("Existing unit index: "));
                    break;
                case 6:
                    homeControlUnit.printAllUnits();
                    break;
                case 7:
                    homeControlUnit.printAllSortedUnits();
                    break;
                case 8:
                    homeControlUnit.printActualPower();
                    break;
                case 9:
                    homeControlUnit.findUnit(inputString("Enter full name or part of the unit name: "));
                    break;
                case 0:
                    isTrue = false;
                    break;
            }
        }
    }

    private static String inputString(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + str);
        return scanner.nextLine();
    }

    private static int inputInt(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + str);
        return scanner.nextInt();
    }

    private static void printMenu() {
        for (String name : operationNames) {
            System.out.println(name);
        }
    }
}
