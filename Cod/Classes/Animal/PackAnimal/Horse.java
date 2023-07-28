package Classes.Animal.PackAnimal;
import java.util.Date;

public class Horse extends PackAnimal {
    public Horse(int id, String name, String command, Date birthdate, int load_capacity, int max_speed) {
        super(id, name, command, birthdate, load_capacity, max_speed);
    }

    @Override
    public void do_command() {
        System.out.println("Лошадь " + getName() + " выполняет команду: " + getCommand());
    }
}