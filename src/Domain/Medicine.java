package Domain;

/**
 * Domain element 1 - Medicine
 * */
public class Medicine implements  HasID{
    private int id;
    private String name;
    int price;
    private String healthProblem;

    /**
     * The constructor of the Medicine class
     * */
    public Medicine(int id, String name,int price, String healthProblem) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.healthProblem = healthProblem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", healthProblem='" + healthProblem + '\'' +
                '}';
    }
}
