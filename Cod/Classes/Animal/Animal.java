package Classes.Animal;


import Interfaces.Command;

import java.util.Date;

public abstract class Animal implements Command {
    private final int id;
    private final String name;
    private String command;
    private final Date birthdate;

    // Конструктор
    public Animal(int id, String name, String command, Date birthdate) {
        this.id = id;
        this.name = name;
        this.command = command;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", имя: " + name +
                ", команда: " + command +
                ", дата рождения: " + birthdate;
    }
}