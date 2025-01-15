package Service;

import Domain.Medicine;
import Domain.Patient;
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
    InMemoryRepository<Medicine> medicineRepository;
    /**
     * Repository for managing the second type of domain element.
     */
    InMemoryRepository<Patient> patientRepository;


    /**
     * Constructor to initialize the service with two repositories.
     *
     * @param medicineRepo the first repository
     * @param patientRepo the second repository
     */
    public AppService(InMemoryRepository<Medicine> medicineRepo, InMemoryRepository<Patient> patientRepo) {
        this.medicineRepository = medicineRepo;
        this.patientRepository = patientRepo;
    }

    /**
     * Adds a new object to the first repository.
     */
    public void addMedicine(int id,String name,int price, String healthProblem){
        medicineRepository.create(new Medicine(id,name, price,healthProblem));
    }

    /**
     * Adds a new object to the second repository.
     */
    public void addPatient(int id,String name,int age, String diagnose){
        patientRepository.create(new Patient(id,name,age,diagnose));
    }

    /**
     * Deletes an object from the first repository by its ID.
     *
     * @param id the unique identifier of the object to be deleted.
     */
    public void deleteMedicine(int id){
        medicineRepository.delete(id);
    }

    /**
     * Deletes an object from the second repository by its ID.
     *
     * @param id the unique identifier of the object to be deleted.
     */
    public void deletePatient(int id){
        patientRepository.delete(id);
    }

    /**
     * Retrieves an object from the first repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID or null when item not found
     */
    public Medicine getMedicine(int id){
        return medicineRepository.getByID(id);
    }

    /**
     * Retrieves an object from the second repository by its ID.
     *
     * @param id the unique identifier of the object to retrieve.
     * @return the object with the specified ID or null when item not found
     */
    public Patient getPatient(int id){
        return  patientRepository.getByID(id);
    }

    /**
     * Updates the name of an object in the first repository.
     */
    public void updateMedicine(int id,String name,int price,String healthProblem){
        Medicine med = getMedicine(id);
        med.setName(name);
        med.setPrice(price);
        med.setHealthProblem(healthProblem);
        medicineRepository.update(med);

    }

    /**
     * Updates the name of an object in the second repository.
     */
    public void updatePatient(int id,String name,int age,String diagnose){
        Patient patient = getPatient(id);
        patient.setName(name);
        patient.setAge(age);
        patient.setDiagnose(diagnose);
        patientRepository.update(patient);
    }

    /**
     * Retrieves all objects from the first repository.
     *
     * @return a list of all objects in the first repository.
     */
    public List<Medicine> getAllMedicines(){
        return medicineRepository.getAll();
    }

    /**
     * Retrieves all objects from the second repository.
     *
     * @return a list of all objects in the second repository.
     */
    public List<Patient> getAllPatients(){
        return patientRepository.getAll();
    }

    /**
     * Assigns a medicine to a patient
     * @param patID - the ID of the patient
     * @param medID - the ID of the medicine
     * */
    public void addMedicineToPatient(int patID,int medID){
        Medicine med = getMedicine(medID);
        Patient patient = getPatient(patID);
        patient.addNewMed(med);

    }

}
