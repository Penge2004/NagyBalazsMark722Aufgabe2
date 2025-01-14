import Domain.TestClassForNotGettingError;
import Repository.InMemoryRepository;
import Service.AppService;
import Ui.UI;

public class Main{
    public static void main(String[] args) {
        InMemoryRepository<TestClassForNotGettingError> repository1 = new InMemoryRepository<>();
        InMemoryRepository<TestClassForNotGettingError> repository2 = new InMemoryRepository<>();
        AppService appService = new AppService(repository1,repository2);
        UI ui = new UI(appService);

        ui.RUN();
    }
}