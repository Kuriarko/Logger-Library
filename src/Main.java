import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Create logger configuration using the builder pattern
        LoggerConfiguration config = new LoggerConfiguration.Builder()
                .withTimeFormat("dd-MM-yyyy HH:mm:ss")
                .withLogLevel(LogLevel.INFO)
                .withSinkType(SinkType.FILE)
                .withFileLocation("logs/app.log")
                .withMaxFileSize(1024 * 1024) // 1MB for example
                .withMaxBackupFiles(5) // Keep 5 backup files
                .build();

        // Create the logger using LoggerFactory
        Logger logger = LoggerFactory.createLogger(config);

        // Log some messages
        logger.log(LogLevel.INFO, "App", "Application started");
        logger.log(LogLevel.DEBUG, "App", "This is a debug message");
        logger.log(LogLevel.WARN, "App", "This is a warning");
        logger.log(LogLevel.ERROR, "App", "An error occurred");
        logger.log(LogLevel.FATAL, "App", "Fatal error!");

        // Custom sink example
        Map<LogLevel, Sink> customSinks = new HashMap<>();
        customSinks.put(LogLevel.INFO, new ConsoleSink());

        Logger customLogger = LoggerFactory.createLogger(config, customSinks);

        // Log some messages with the custom logger
        customLogger.log(LogLevel.INFO, "CustomApp", "Custom application started");
        customLogger.log(LogLevel.ERROR, "CustomApp", "Custom error occurred");
    }
}