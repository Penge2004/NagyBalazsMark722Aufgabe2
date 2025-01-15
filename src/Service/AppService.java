package Service;

import Domain.TestClassForNotGettingError;
import Repository.InMemoryRepository;

import java.util.List;

/**
 * This class provides application-level services for managing two separate repositories.
 * It supports CRUD operations for the Domain objects
 */
public class AppService {
    /**
     * Repository for managing the first type of domain element.
     */
    InMemoryRepository<TestClassForNotGettingError> ChangeRepo1;
    /**
     * Repository for managing the second type of domain element.
     */
    InMemoryRepository<TestClassForNotGettingError> ChangeRepo2;


    /**
     * Constructor to initialize the service with two repositories.
     *
     * @param ChangeRepo1 the first repository
     * @param ChangeRepo2 the second repository
     */
    public AppService(InMemoryRepository<TestClassForNotGettingError> ChangeRepo1, InMemoryRepository<TestClassForNotGettingError> ChangeRepo2) {
        this.ChangeRepo1 = ChangeRepo1;
        this.ChangeRepo2 = ChangeRepo2;
    }

    /**
     * Adds a new object to the first repository.
     */
    public void add1(int id,String name){
        ChangeRepo1.create(new TestClassForNotGettingError(id,name));
    }

    /**
     * Adds a new object to the second repository.
     */
    public void add2(int id,String name){
        ChangeRepo2.create(new TestClassForNotGettingError(id,name));
    }

    /**
     * Deletes an object from the first repository by its ID.
     *
     * @param id the unique identifier of the object to be deleted.
     */
    public void delete1(int id){
        ChangeRepo1.delete(id);
    }

    /**
     * Deletes an object from the second repository by its ID.
     *
     * @param id the unique identifier of the object to be deleted.
     */
    public void delete2(int id){
        ChangeRepo2.delete(id);
    }

    /**
     * Retrieves an object from the first repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID or null when item not found
     */
    public TestClassForNotGettingError get1(int id){
        return ChangeRepo1.getByID(id);
    }

    /**
     * Retrieves an object from the second repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID or null when item not found
     */
    public TestClassForNotGettingError get2(int id){
        return  ChangeRepo2.getByID(id);
    }

    /**
     * Updates the name of an object in the first repository.
     */
    public void update1(int id,String name){
        TestClassForNotGettingError tc = get1(id);
        tc.setName(name);
        ChangeRepo1.update(tc);

    }

    /**
     * Updates the name of an object in the second repository.
     */
    public void update2(int id,String name){
        TestClassForNotGettingError tc = get2(id);
        tc.setName(name);
        ChangeRepo2.update(tc);
    }

    /**
     * Retrieves all objects from the first repository.
     *
     * @return a list of all objects in the first repository.
     */
    public List<TestClassForNotGettingError> getAll1(){
        return ChangeRepo1.getAll();
    }

    /**
     * Retrieves all objects from the second repository.
     *
     * @return a list of all objects in the second repository.
     */
    public List<TestClassForNotGettingError> getAll2(){
        return ChangeRepo2.getAll();
    }

}
