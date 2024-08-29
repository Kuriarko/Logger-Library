import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    private final LogLevel logLevel;
    private final Map<LogLevel, Sink> sinks;
    private final MessageFormatter formatter;

    public Logger(LoggerConfiguration config, Map<LogLevel, Sink> sinks) {
        this.logLevel = config.getLogLevel();
        this.sinks = sinks;
        this.formatter = new MessageFormatter(config.getTimeFormat());
    }

    public void log(LogLevel level, String namespace, String messageContent) {
        if (level.ordinal() < logLevel.ordinal()) {
            return;
        }
        String formattedMessage = formatter.format(new Message(level, namespace, messageContent, new Date()));
        Sink sink = sinks.get(level);
        if (sink != null) {
            sink.log(formattedMessage);
        }
    }
}
