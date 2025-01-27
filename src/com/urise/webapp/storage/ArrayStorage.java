package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Objects;

import static java.util.UUID.randomUUID;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private int i;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public Resume update(Resume resume) {
        //TODO check if resume present
        if (checkResume(resume) == false) {
            return resume.setUuid(randomUUID().toString());
        }
        return resume;
    }


    public void save(Resume r) {
        //TODO check if resume not present
        if (checkResume(r) == true) {
            storage[size++] = r;
        }
    }

    public Resume get(String uuid) {
        if (checkUuid(uuid) != null) {
            return storage[i];
        }
        return null;
    }

    public void delete(String uuid) {
        //TODO check if resume present
        if (checkUuid(uuid) != null) {
            storage[i] = storage[size - 1];
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

    public Resume checkUuid(String uuid) {
        i = 0;
        if (Objects.isNull(uuid)) {
            System.out.println("ERROR: Resume does not exist:" + uuid);
        } else {
            for (; i < size; i++) {
                if (uuid.equals(storage[i].toString())) {
                    return storage[i];
                }
            }
            System.out.println("ERROR: Resume does not exist: " + uuid);
        }
        return storage[i];
    }

    public boolean checkResume(Resume resume) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return true;
            }
            if (storage[i].getUuid().equals(resume.getUuid())) {
                System.out.println("ERROR: Resume does exist:" + storage[i].getUuid());
                return false;
            }
        }
        return false;
    }
}