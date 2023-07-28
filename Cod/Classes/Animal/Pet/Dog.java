package Classes.Animal.Pet;
import java.util.Date;

public class Dog extends Pet {
    public Dog(int id, String name, String command, Date birthdate, String breed, Boolean trained) {
        super(id, name, command, birthdate, breed, trained);
    }

    @Override
    public void do_command() {
        System.out.println("Собака " + getName() + " выполняет команду: " + getCommand());
    }
}