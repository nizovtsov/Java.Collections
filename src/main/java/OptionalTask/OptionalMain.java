package OptionalTask;

import java.io.*;
import java.util.*;

public class OptionalMain {
    public static void main(String[] args) {
        System.out.println("Task 1");
        task1();
        System.out.println("===============\nTask 4");
        task4();
        System.out.println("===============\nTask 6");
        task6();
        System.out.println("===============\nTask 8");
        task8();
    }

    /*
    8. Задан файл с текстом на английском языке. Выделить все различные слова.
    Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
     */
    private static void task8() {
        String inputFileName = "words.txt";
        String fileContent = "Words in unit \n UNIT is working. Task in task window \n " +
                "Errors tASK wOrds\nControl the control-unit \n click button before exit";
        createFile(inputFileName, fileContent);
        File file = new File("words.txt");

        HashSet<String> hashSet = new HashSet();
        String str;
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Extracting words from text: ");
        while (scanner.hasNext()) {
            str = scanner.next().toLowerCase();
            System.out.println(str);
            hashSet.add(str);
        }
        scanner.close();
        System.out.println(hashSet);
    }

    /*
    6. Ввести строки из файла, записать в список ArrayList.
    Выполнить сортировку строк, используя метод sort() из класса Collections.
     */
    private static void task6() {
        try (Scanner scanner = new Scanner(new File("output1.txt"))) {
            ArrayList<String> strArray = new ArrayList<>();

            while (scanner.hasNextLine()) {
                strArray.add(scanner.nextLine());
            }
            System.out.println("Before sort - " + strArray);
            Collections.sort(strArray);
            System.out.println("After sort - " + strArray);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
     */
    private static void task4() {
        String poem = "Hold fast to dreams \n" +
                "For if dreams die\n" +
                "Life is a broken-winged bird\n" +
                "That cannot fly.\n" +
                "Hold fast to dreams\n" +
                "For when dreams go\n" +
                "Life is a barren field\n" +
                "Frozen with snow.";
        List<String> lines = Arrays.asList(poem.split("\n"));
        System.out.println(lines);

        Collections.sort(lines, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length() - t1.length();
            }
        });
        System.out.println(lines);
    }

    /*
    1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
     */
    private static void task1() {
        String inputFileName = "input1.txt";
        String outputFileName = "output1.txt";
        String fileContent = "1\n2\n3\n4\n5";
        createFile(inputFileName, fileContent);
        Stack<String> stack = new Stack<>();
        try (Scanner scanner = new Scanner(new File(inputFileName));
             FileWriter fileWriter = new FileWriter(new File(outputFileName))) {
            System.out.println("Reading file - " + inputFileName);
            while (scanner.hasNextLine()) {
                stack.push(scanner.nextLine());
            }
            System.out.println("Writing file - " + outputFileName);
            while (!stack.isEmpty()) {
                fileWriter.write(stack.pop() + "\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Check file - " + outputFileName);
    }

    private static void createFile(String fileName, String fileContent) {
        File tmpDir = new File(fileName);
        boolean exists = tmpDir.exists();
        if (!exists) {
            try {
                System.out.println("Creating file");
                FileOutputStream fos = new FileOutputStream(fileName);
                fos.write(fileContent.getBytes());
                fos.flush();
                fos.close();
                System.out.println("File created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File exists");
        }
    }
}
