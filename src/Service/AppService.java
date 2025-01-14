package Service;

import Domain.TestClassForNotGettingError;
import Repository.InMemoryRepository;

import java.util.List;

public class AppService {
    InMemoryRepository<TestClassForNotGettingError> ChangeRepo1;
    InMemoryRepository<TestClassForNotGettingError> ChangeRepo2;

    public AppService(InMemoryRepository<TestClassForNotGettingError> ChangeRepo1, InMemoryRepository<TestClassForNotGettingError> ChangeRepo2) {
        this.ChangeRepo1 = ChangeRepo1;
        this.ChangeRepo2 = ChangeRepo2;
    }

    public void add1(int id,String name){
        ChangeRepo1.create(new TestClassForNotGettingError(id,name));
    }
    public void add2(int id,String name){
        ChangeRepo2.create(new TestClassForNotGettingError(id,name));
    }
    public void delete1(int id){
        ChangeRepo1.delete(id);
    }
    public void delete2(int id){
        ChangeRepo2.delete(id);
    }
    public TestClassForNotGettingError get1(int id){
        return ChangeRepo1.getByID(id);
    }
    public TestClassForNotGettingError get2(int id){
        return  ChangeRepo2.getByID(id);
    }
    public void update1(int id,String name){
        TestClassForNotGettingError tc = get1(id);
        tc.setName(name);
        ChangeRepo1.update(tc);

    }
    public void update2(int id,String name){
        TestClassForNotGettingError tc = get2(id);
        tc.setName(name);
        ChangeRepo2.update(tc);
    }
    public List<TestClassForNotGettingError> getAll1(){
        return ChangeRepo1.getAll();
    }
    public List<TestClassForNotGettingError> getAll2(){
        return ChangeRepo2.getAll();
    }

}
