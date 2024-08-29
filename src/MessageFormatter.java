import java.text.SimpleDateFormat;
import java.util.Date;
public class MessageFormatter {

    private final SimpleDateFormat dateFormat;

    public MessageFormatter(String timeFormat) {
        this.dateFormat = new SimpleDateFormat(timeFormat);
    }

    public String format(Message message) {
        String timestamp = dateFormat.format(message.getTimestamp());
        return String.format("%s [%s] %s - %s",
                message.getLevel().name(),
                timestamp,
                message.getNamespace(),
                message.getContent());
    }

}
