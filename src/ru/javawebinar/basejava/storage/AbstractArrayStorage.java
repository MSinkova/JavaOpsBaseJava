package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected int size;
    protected int STORAGE_LIMIT = 1000;
    public Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        //TODO check if resume present
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Resume does not exist: " + uuid);
        } else {
            return storage[index];
        }
        return null;
    }

    protected abstract int findIndex(String uuid);
}