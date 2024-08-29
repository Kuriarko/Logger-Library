import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {

    public static Logger createLogger(LoggerConfiguration config) {
        Map<LogLevel, Sink> sinks = new HashMap<>();
        Sink sink;

        switch (config.getSinkType()) {
            case FILE:
                if (config.getMaxFileSize() > 0 && config.getMaxBackupFiles() > 0) {
                    sink = new RotatingFileSink(config.getFileLocation(), config.getMaxFileSize(), config.getMaxBackupFiles());
                } else {
                    sink = new FileSink(config.getFileLocation());
                }
                break;
            case CONSOLE:
                sink = new ConsoleSink();
                break;
            default:
                throw new IllegalArgumentException("Unsupported sink type: " + config.getSinkType());
        }

        for (LogLevel level : LogLevel.values()) {
            if (level.ordinal() >= config.getLogLevel().ordinal()) {
                sinks.put(level, sink);
            }
        }

        return new Logger(config, sinks);
    }

    public static Logger createLogger(LoggerConfiguration config, Map<LogLevel, Sink> customSinks) {
        Map<LogLevel, Sink> sinks = new HashMap<>(customSinks);

        for (LogLevel level : LogLevel.values()) {
            if (level.ordinal() >= config.getLogLevel().ordinal() && !sinks.containsKey(level)) {
                Sink sink;

                switch (config.getSinkType()) {
                    case FILE:
                        if (config.getMaxFileSize() > 0 && config.getMaxBackupFiles() > 0) {
                            sink = new RotatingFileSink(config.getFileLocation(), config.getMaxFileSize(), config.getMaxBackupFiles());
                        } else {
                            sink = new FileSink(config.getFileLocation());
                        }
                        break;
                    case CONSOLE:
                        sink = new ConsoleSink();
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported sink type: " + config.getSinkType());
                }

                sinks.put(level, sink);
            }
        }

        return new Logger(config, sinks);
    }

}
