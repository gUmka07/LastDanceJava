package Classes.Animal.Pet;
import java.util.Date;

public class Cat extends Pet {
    public Cat(int id, String name, String command, Date birthdate, String breed, Boolean trained) {
        super(id, name, command, birthdate, breed, trained);
    }

    @Override
    public void do_command() {
        System.out.println("Кошка " + getName() + " выполняет команду: " + getCommand());
    }
}