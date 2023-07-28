package Classes.Animal.PackAnimal;

import Classes.Animal.Animal;

import java.util.Date;

public abstract class PackAnimal extends Animal {
    private final int load_capacity;
    private final int max_speed;

    public PackAnimal(int id, String name, String command, Date birthdate, int load_capacity, int max_speed) {
        super(id, name, command, birthdate);
        this.load_capacity = load_capacity;
        this.max_speed = max_speed;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", переносимый вес: " + load_capacity +
                ", макс. скорость: " + max_speed;
    }
}