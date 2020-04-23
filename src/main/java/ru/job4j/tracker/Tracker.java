package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * @return Copy of this.item without null.
     */
    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item name = this.items[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int index = 0; index < namesWithoutNull.length; index++) {
            System.out.println(namesWithoutNull[index]);
        }
        return namesWithoutNull;
    }

    /**
     * @param findName name to find
     * @return Copy of this.item with names if found.
     */
    public Item[] findByName(String findName) {
        Item[] foundNames = new Item[this.items.length];
        int size = 0;
        for (int index = 0; index < this.items.length; index++) {
            Item name = this.items[index];
            if (name != null) {
                if (name.getName().equals(findName)) {
                    foundNames[size] = name;
                    size++;
                }
            }
        }
        foundNames = Arrays.copyOf(foundNames, size);
        for (int index = 0; index < foundNames.length; index++) {
            System.out.println(foundNames[index]);
        }
        return foundNames;
    }

    /**
     * @param id to find Item
     * @return Item if id is matched.
     */
    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    /**
     * @param id to find Item
     * @return int index of Item or -1 if not found.
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * @param id to find item
     * @param newItem to replace new Item
     * @return true if replaced successfully or false if not.
     */
    public boolean replace(String id, Item newItem) {
        int indexOfItem = indexOf(id);
        if (indexOfItem >= 0) {
            newItem.setId(items[indexOfItem].getId());
            items[indexOfItem] = newItem;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        if (index >= 0) {
            int start = index + 1;
            int size = position - index;
            System.arraycopy(items, start, items, index, size);
            items[position - 1] = null;
            position--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
}