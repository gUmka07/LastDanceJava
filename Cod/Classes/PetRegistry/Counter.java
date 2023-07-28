package Classes.PetRegistry;

class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public int add() {
        return ++count;
    }

    @Override
    public void close() {
        System.out.println("Завершение работы счетчика");
    }
}