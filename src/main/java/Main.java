import com.kraievskyi.lection.task1.service.FileFormatter;
import com.kraievskyi.lection.task1.service.FileReadWrite;
import com.kraievskyi.lection.task2.service.FineService;
import com.kraievskyi.lection.task2.service.ReadWrite;

public class Main {
    public static void main(String[] args) {
        FileReadWrite fileReadWrite = new FileReadWrite();
        fileReadWrite.fileWriter(new FileFormatter().formatFile(fileReadWrite.readFile()));

        ReadWrite readWrite = new ReadWrite();
        FineService fineService = new FineService();
        readWrite.writeFileToXml(fineService.calculateFines(readWrite.readFiles()));
    }
}
