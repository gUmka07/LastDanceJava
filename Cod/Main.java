import Classes.PetRegistry.PetRegistry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetRegistry petRegistry = new PetRegistry(scanner);

        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("\nМеню:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать всех животных");
                System.out.println("3. Показать команду, которую выполняет животное");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("5. Выйти из программы");
                System.out.print("Выберите действие: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> petRegistry.addNewAnimal();
                    case 2 -> petRegistry.printAllAnimals();
                    case 3 -> petRegistry.printAnimalCommands();
                    case 4 -> petRegistry.teachAnimalNewCommand();
                    case 5 -> exit = true;
                    default -> System.out.println("Некорректный выбор. Пожалуйста, выберите номер из меню.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ошибка при добавлении животного, попробуйте еще раз");
            }
        }
    }
}
