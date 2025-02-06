package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private int STORAGE_LIMIT = 1000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void update(Resume resume) {
        //TODO check if resume present
        int index = findIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("ERROR: Resume does not exist: " + resume.getUuid());
        } else {
            storage[index] = resume;
        }
    }
      
    public void save(Resume r) {
        //TODO check if resume not present
        int index = findIndex(r.getUuid());
        if (index != -1) {
            System.out.println("ERROR: Resume is already exist: " + r.getUuid());
        } else if (index == STORAGE_LIMIT) {
            System.out.println("ERROR: Resume full");
        } else {
            storage[size++] = r;
        }
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

    public void delete(String uuid) {
        //TODO check if resume present
        int index = findIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Resume does not exist: " + uuid);
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public int findIndex(String uuid) {
        for (int index = 0; index < storage.length; index++) {
            if (storage[index] == null) {
                return -1;
            }
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}