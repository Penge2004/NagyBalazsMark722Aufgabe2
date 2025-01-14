package Domain;

public class TestClassForNotGettingError implements HasID{
    private int id;
    private String name;

    public TestClassForNotGettingError(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int getID() {
        return id ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestClassForNotGettingError{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
