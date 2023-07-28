package Classes.Animal.Pet;
import java.util.Date;

public class Hamster extends Pet {
    public Hamster(int id, String name, String command, Date birthdate, String breed, Boolean trained) {
        super(id, name, command, birthdate, breed, trained);
    }

    @Override
    public void do_command() {
        System.out.println("Хомяк " + getName() + " выполняет команду: " + getCommand());
    }
}
