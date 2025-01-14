package Repository;


import Domain.HasID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An in-memory implementation of the Repository interface for managing entities
 * of type T that extend HasID. This repository uses a Map to store objects based on their unique ID.
 * @param <T> the type of object being stored in the repository, which must implement the {@link HasID} interface.
 */
public class InMemoryRepository<T extends HasID> {

    /**
     * The data is in a HashMap stored. Key is the ID of the object and the Value of the
     * map is the object itself
     * */
    private final Map<Integer, T> data = new HashMap<>();


    /**
     * Creates a new object in the repository, associating it with its unique ID.
     * If an object with the same ID already exists, the new object is not added.
     * @param obj the object to be created in the repository
     */

    public void create(T obj) {
        data.putIfAbsent(obj.getID(), obj);
    }

    /**
     * Deletes an object from the repository by its unique ID.
     * @param objID the unique ID of the object to be deleted
     */
    public void delete(Integer objID) {
        data.remove(objID);
    }

    /**
     * Updates an existing object in the repository. If the object does not already exist,
     * it is added as a new object.
     * @param obj the object to be updated
     */
    public void update(T obj) {
        data.replace(obj.getID(), obj);
    }

    /**
     * Retrieves an object from the repository by its unique ID.
     * @param id the unique ID of the object to retrieve
     * @return the object associated with the provided ID, or null if no such object exists
     */
    public T getByID(Integer id) {
        return data.get(id);
    }

    /**
     * Returns a list of all objects stored in the repository.
     * @return a list of all objects in the repository
     */
    public List<T> getAll() {
        return data.values().stream().toList();
    }
}
