import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private final LogLevel level;
    private final String namespace;
    private final String content;
    private final Date timestamp;

    public Message(LogLevel level, String namespace, String content, Date timestamp) {
        this.level = level;
        this.namespace = namespace;
        this.content = content;
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
