package Classes.PetRegistry;

import Classes.Animal.Animal;
import Classes.Animal.PackAnimal.Camel;
import Classes.Animal.PackAnimal.Donkey;
import Classes.Animal.PackAnimal.Horse;
import Classes.Animal.Pet.Cat;
import Classes.Animal.Pet.Dog;
import Classes.Animal.Pet.Hamster;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PetRegistry {
    private final List<Animal> animals;
    private final Counter counter;
    private final Scanner scanner;

    public PetRegistry(Scanner scanner) {
        this.animals = new ArrayList<>();
        this.counter = new Counter();
        this.scanner = scanner;
    }

    public void addNewAnimal() {
        try (counter) {

            String subtype = getAnimalSubtype();
            String type = getAnimalType(subtype);
            String name = getAnimalName();
            String command = getAnimalCommand();
            Date birthdate = getAnimalBirthdate();

            switch (type) {
                case "Pet" -> addPetAnimal(subtype, name, command, birthdate);
                case "Pack animal" -> addPackAnimal(subtype, name, command, birthdate);
                default -> throw new InputMismatchException("Введен некорректный номер");
            }

        } catch (Exception e) {
            throw new RuntimeException("Ошибка при добавлении животного: " + e.getMessage());
        }
    }

    private String getAnimalSubtype() throws IOException {
        String[] animalSubtypes = {"Кошка", "Собака", "Хомяк", "Лошадь", "Верблюд", "Осёл"};
        System.out.println("Выберите вид животного:");
        for (int i = 0; i < animalSubtypes.length; i++) {
            System.out.println((i + 1) + ". " + animalSubtypes[i]);
        }

        System.out.print("Выберите действие: ");
        int choice;

        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            throw new IOException("Введено некорректное значение. Необходимо ввести число.", e);
        }

        if (choice < 1 || choice > animalSubtypes.length) {
            throw new IOException("Введено некорректное число. Выберите номер из списка.");
        }

        return animalSubtypes[choice - 1];
    }

    private String getAnimalType(String animalSubtype) {
        return switch (animalSubtype) {
            case "Кошка", "Собака", "Хомяк" -> "Pet";
            case "Лошадь", "Верблюд", "Осёл" -> "Pack animal";
            default -> throw new InputMismatchException("Введен некорректный номер");
        };
    }

    private String getAnimalName() throws IOException {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            throw new IOException("Имя животного не может быть пустым.");
        }

        if (!name.matches("^[a-zA-Zа-яА-Я0-9 ]+$")) {
            throw new IOException("Имя животного содержит недопустимые символы. Разрешены только буквы, цифры и пробелы.");
        }

        return name;
    }

    private String getAnimalCommand() throws IOException {
        System.out.println("Введите команду, которую выполняет животное: ");
        String command = scanner.nextLine().trim();

        if (command.isEmpty()) {
            throw new IOException("Команда не может быть пустой.");
        }

        if (!command.matches("^[a-zA-Zа-яА-Я0-9 ]+$")) {
            throw new IOException("Команда содержит недопустимые символы. Разрешены только буквы, цифры и пробелы.");
        }

        return command;
    }

    private Date getAnimalBirthdate() throws IOException {
        System.out.println("Введите дату рождения животного в формате 31.12.2019: ");
        String dateString = scanner.nextLine().trim();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthdate;

        try {
            birthdate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IOException("Некорректный формат даты. Ожидается формат 31.12.2019.");
        }

        return birthdate;
    }

    private String getPetBreed() throws IOException {
        System.out.println("Введите породу домашнего животного: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            throw new IOException("Порода домашнего животного не может быть пустым.");
        }

        if (!name.matches("^[a-zA-Zа-яА-Я0-9 ]+$")) {
            throw new IOException("Порода домашнего животного содержит недопустимые символы. Разрешены только буквы, цифры и пробелы.");
        }

        return name;
    }

    private Boolean getPetTrained() throws IOException {
        System.out.println("Введите дрессированно ли домашнее животное: ");
        System.out.println("1. Да");
        System.out.println("2. Нет");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            throw new IOException("Введено некорректное значение. Необходимо ввести число.", e);
        }

        return switch (choice) {
            case 1 -> true;
            case 2 -> false;
            default -> throw new IOException("Введено некорректное значение. Необходимо выбрать 1 или 2.");
        };
    }

    private int getPackAnimalLoadCapacity() throws IOException {
        System.out.println("Введите переносимый животным вес (кг): ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IOException("Введено некорректное значение. Необходимо ввести число.", e);
        } finally {
            scanner.nextLine();
        }
    }

    private int getPackAnimalMaxSpeed() throws IOException {
        System.out.print("Введите максимальную скорость животного (км\\ч): ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IOException("Введено некорректное значение. Необходимо ввести число.", e);
        } finally {
            scanner.nextLine();
        }
    }

    private void addPetAnimal(String subtype, String name, String command, Date birthdate) throws IOException {
        String breed = getPetBreed();
        Boolean trained = getPetTrained();
        // TODO:
        System.out.println(subtype);
        System.out.println(name);
        System.out.println(command);
        System.out.println(birthdate);

        switch (subtype) {
            case "Кошка" -> animals.add(new Cat(counter.add(), name, command, birthdate, breed, trained));
            case "Собака" -> animals.add(new Dog(counter.add(), name, command, birthdate, breed, trained));
            case "Хомяк" -> animals.add(new Hamster(counter.add(), name, command, birthdate, breed, trained));
            case default -> throw new IOException("Введено некорректное значение.");
        }
    }

    private void addPackAnimal(String subtype, String name, String command, Date birthdate) throws IOException {
        int loadCapacity = getPackAnimalLoadCapacity();
        int maxSpeed = getPackAnimalMaxSpeed();

        switch (subtype) {
            case "Лошадь" -> animals.add(new Horse(counter.add(), name, command, birthdate, loadCapacity, maxSpeed));
            case "Верблюд" -> animals.add(new Camel(counter.add(), name, command, birthdate, loadCapacity, maxSpeed));
            case "Осёл" -> animals.add(new Donkey(counter.add(), name, command, birthdate, loadCapacity, maxSpeed));
            case default -> throw new IOException("Введено некорректное значение.");
        }
    }

    public void printAnimalCommands() {
        System.out.print("Введите ID животного, чтобы увидеть его команду: ");
        int animalId = scanner.nextInt();

        Animal animal = findAnimalById(animalId);
        if (animal != null) {
            System.out.println("Команда животного " + animal.getName() + ": " + animal.getCommand());
        } else {
            System.out.println("Животное с ID " + animalId + " не найдено.");
        }
    }

    public void teachAnimalNewCommand() {
        System.out.print("Введите ID животного, чтобы обучить его новой команде: ");
        int animalId = scanner.nextInt();
        scanner.nextLine();

        Animal animal = findAnimalById(animalId);
        if (animal != null) {
            System.out.print("Введите новую команду для животного: ");
            String newCommand = scanner.nextLine();
            animal.setCommand(newCommand);
            System.out.println("Животное " + animal.getName() + " успешно обучено новой команде: " + newCommand);
        } else {
            System.out.println("Животное с ID " + animalId + " не найдено.");
        }
    }

    private Animal findAnimalById(int id) {
        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public void printAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }

        System.out.println("Список всех животных в реестре: ");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}