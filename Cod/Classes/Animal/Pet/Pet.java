package Classes.Animal.Pet;

import Classes.Animal.Animal;

import java.util.Date;

public abstract class Pet extends Animal {
    private final String breed;
    private final Boolean trained;

    public Pet(int id, String name, String command, Date birthdate, String breed, Boolean trained) {
        super(id, name, command, birthdate);
        this.breed = breed;
        this.trained = trained;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", порода: " + breed +
                ", дрессирован: " + trained;
    }
}