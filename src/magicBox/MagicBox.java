package magicBox;

import java.util.Random;

public class MagicBox<T> {
    private T[] items = null;
    private int addedCount = 0;

    public MagicBox(int maximumAmount) {
        if (maximumAmount < 0) {
            throw new RuntimeException("Максимальное количество предметов должно быть положительным!");
        } else {
            items = (T[]) new Object[maximumAmount];
        }
    }

    public boolean add(T item) {
        checkForInitializationError();

        if (isBoxNotFullOrEmpty()) {
            items[addedCount] = item;
            addedCount++;
            return true;
        }

        return false;
    }

    public T pick() {
        checkForInitializationError();

        if (isBoxNotFullOrEmpty()) {
            throw new RuntimeException("Коробка не заполнена полностью! Чтобы использовать метод, " +
                    "добавьте в коробку ещё " + (items.length - addedCount) + " предмет(-ов -а)!");
        } else {
            return getRandomItem();
        }
    }

    private T getRandomItem() {
        Random random = new Random();
        int randomInt = random.nextInt(items.length);

        return items[randomInt];
    }

    private void checkForInitializationError() {
        if (items == null) {
            throw new RuntimeException("Класс некорректно инициализирован!");
        }
    }

    // Возвращает true если коробка полность не заполнена или пуста
    private boolean isBoxNotFullOrEmpty() {
        return addedCount < items.length;
    }
}
