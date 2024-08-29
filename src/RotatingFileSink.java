import java.io.*;
import java.util.zip.GZIPOutputStream;

public class RotatingFileSink extends FileSink{

    private final long maxFileSize;
    private final int maxBackupFiles;

    public RotatingFileSink(String fileLocation, long maxFileSize, int maxBackupFiles) {
        super(fileLocation);
        this.maxFileSize = maxFileSize;
        this.maxBackupFiles = maxBackupFiles;
    }

    @Override
    public synchronized void log(String message) {
        try {
            rotateLogsIfNeeded();
            super.log(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rotateLogsIfNeeded() throws IOException {
        File logFile = new File(fileLocation);
        if (logFile.length() > maxFileSize) {
            rotateLogs();
        }
    }

    private void rotateLogs() throws IOException {
        for (int i = maxBackupFiles; i > 0; i--) {
            File oldFile = new File(fileLocation + "." + i);
            File newFile = new File(fileLocation + "." + (i + 1));
            if (oldFile.exists()) {
                if (i == maxBackupFiles) {
                    compressLogFile(oldFile);
                } else {
                    oldFile.renameTo(newFile);
                }
            }
        }
        File logFile = new File(fileLocation);
        File firstBackupFile = new File(fileLocation + ".1");
        logFile.renameTo(firstBackupFile);
    }

    private void compressLogFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file.getPath() + ".gz");
             GZIPOutputStream gzos = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gzos.write(buffer, 0, len);
            }
        }
        file.delete();
    }
}
