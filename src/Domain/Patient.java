package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Domain element 2 - Patients
 * */
public class Patient implements HasID{
    private int id;
    private String name;
    private int age;
    private String diagnose;
    private List<Medicine> medicines;

    /**
     * The constructor of the Patient class
     * */
    public Patient(int id, String name, int age, String diagnose) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
        this.medicines = new ArrayList<Medicine>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public void addNewMed(Medicine medicine) {
        medicines.add(medicine);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", diagnose='" + diagnose + '\'' +
                ", medicines=" + medicines +
                '}';
    }
}
