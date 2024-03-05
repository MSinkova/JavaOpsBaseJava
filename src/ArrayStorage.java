import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        if(storage[size] == null) {
            storage[size] = r;
            size++;
            return;
        }
        System.out.println("ERROR: Rezume already exists");
    }

    Resume get(String uuid) {
        Resume[] storageWithoutNull = getAll();
        for(int i = 0; i< storageWithoutNull.length; i++) {
           if(storageWithoutNull[i].toString() == uuid) {
               return storageWithoutNull[i];
           }

        }
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < size; i++) {
            if(storage[i] != null) {
               if(uuid == storage[i].toString()) {
                   storage[i] = storage[size - 1];
                   storage[size - 1] = null;
                   size--;
               }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] storageWithoutNull = new Resume[size()];
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                storageWithoutNull[i] = storage[i];
            }
        }
        return storageWithoutNull;
    }

    int size() {
        for(size = 0; size < storage.length; size++) {
           if (storage[size] != null) {
               size++;
           }
        }
        return size;
    }
}