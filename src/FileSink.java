import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSink implements Sink{

    protected final String fileLocation;

    public FileSink(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public synchronized void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
