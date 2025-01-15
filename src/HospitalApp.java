import Domain.Medicine;
import Domain.Patient;
import Repository.InMemoryRepository;
import Service.AppService;
import Ui.UI;

/**
 * Entry point of the application. Sets up the repositories, service layer, and user interface (UI).
 * Responsible for initializing the components and starting the application.
 */
public class HospitalApp{

    /**
     * The main method that serves as the entry point of the application.
     */
    public static void main(String[] args) {
        // Initialize two in-memory repositories
        InMemoryRepository<Medicine> medicineRepo = new InMemoryRepository<>();
        InMemoryRepository<Patient> patientRepo = new InMemoryRepository<>();
        // Create the service layer, connecting the repositories
        AppService appService = new AppService(medicineRepo,patientRepo);
        // Initialize the user interface (UI) with the service layer
        UI ui = new UI(appService);

        // Start the application
        ui.RUN();
    }
}