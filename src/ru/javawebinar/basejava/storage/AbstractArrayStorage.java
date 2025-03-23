package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class AbstractArrayStorage {
    private int size;
    private int STORAGE_LIMIT = 1000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];

}