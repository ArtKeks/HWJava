package HomeWorkJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LoptopMain {
    public static void main(String[] args) {
        Loptop Loptop1 = new Loptop(512, 8, "Black", "Windows");
        Loptop Loptop2 = new Loptop(1024, 16, "Black", "Windows");
        Loptop Loptop3 = new Loptop(2048, 32, "Gray", "iOS");
        Loptop Loptop4 = new Loptop(3072, 64, "White", "Linux");
        Loptop Loptop5 = new Loptop(3072, 64, "Gray", "Linux");

        Set<Loptop> Loptops = new HashSet<>(Arrays.asList(Loptop1, Loptop2, Loptop3, Loptop4, Loptop5));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ (8, 16, 32)");
        String input = scanner.nextLine();
        System.out.println("Введите минимальное значение ОЗУ:");
        filterCriteria.put("RAM", String.valueOf(scanner.nextInt()));

        System.out.println("2 - Объем ЖД (512, 1024, 2048, 3072)");
        input = scanner.nextLine();
        System.out.println("Введите минимальный объем ЖД:");
        filterCriteria.put("HardDisk", String.valueOf(scanner.nextInt()));

        System.out.println("3 - Операционная система (1 - Windows, 2 - iOS, 3 - Linux)");
        input = scanner.nextLine();
        System.out.println("Введите номер операционной системы:");
        int osChoice = scanner.nextInt();
        String os = osChoice == 1 ? "Windows" : osChoice == 2 ? "iOS" : "Linux";
        filterCriteria.put("OperatingSystem", os);

        System.out.println("4 - Цвет (1 - Black, 2 - White, 3 - Gray)");
        input = scanner.nextLine();
        System.out.println("Введите номер цвета:");
        int colorChoice = scanner.nextInt();
        String color = colorChoice == 1 ? "Black" : colorChoice == 2 ? "White" : "Gray";
        filterCriteria.put("Color", color);

        Set<Loptop> filteredLoptops = Loptops.stream()
                .filter(loptop -> Integer.parseInt(filterCriteria.getOrDefault("RAM", "0")) <= loptop.getRAM())
                .filter(loptop -> Integer.parseInt(filterCriteria.getOrDefault("HardDisk", "0")) <= loptop.getHardDisk())
                .filter(loptop -> filterCriteria.getOrDefault("OperatingSystem", "").equals(loptop.getOperatingSystem()))
                .filter(loptop -> filterCriteria.getOrDefault("Color", "").equals(loptop.getColor()))
                .collect(Collectors.toSet());

        for (Loptop loptop : filteredLoptops) {
            System.out.println(loptop);
            System.out.println();
        }
        scanner.close();
    }
}