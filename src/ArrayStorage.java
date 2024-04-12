import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size - 1, null);
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
        return;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageWithoutNull = new Resume[size()];
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storageWithoutNull = Arrays.copyOf(storage, size);
            }
            break;
        }
        return storageWithoutNull;
    }

    int size() {
        return size;
    }
}