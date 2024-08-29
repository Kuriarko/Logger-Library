import java.util.Map;
import java.util.HashMap;

public class LoggerConfiguration {

    private String timeFormat;
    private LogLevel logLevel;
    private SinkType sinkType;
    private String fileLocation;
    private long maxFileSize;
    private int maxBackupFiles;

    private LoggerConfiguration(Builder builder) {
        this.timeFormat = builder.timeFormat;
        this.logLevel = builder.logLevel;
        this.sinkType = builder.sinkType;
        this.fileLocation = builder.fileLocation;
        this.maxFileSize = builder.maxFileSize;
        this.maxBackupFiles = builder.maxBackupFiles;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public SinkType getSinkType() {
        return sinkType;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public int getMaxBackupFiles() {
        return maxBackupFiles;
    }

    public static class Builder {
        private String timeFormat;
        private LogLevel logLevel;
        private SinkType sinkType;
        private String fileLocation;
        private long maxFileSize;
        private int maxBackupFiles;

        public Builder withTimeFormat(String timeFormat) {
            this.timeFormat = timeFormat;
            return this;
        }

        public Builder withLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Builder withSinkType(SinkType sinkType) {
            this.sinkType = sinkType;
            return this;
        }

        public Builder withFileLocation(String fileLocation) {
            this.fileLocation = fileLocation;
            return this;
        }

        public Builder withMaxFileSize(long maxFileSize) {
            this.maxFileSize = maxFileSize;
            return this;
        }

        public Builder withMaxBackupFiles(int maxBackupFiles) {
            this.maxBackupFiles = maxBackupFiles;
            return this;
        }

        public LoggerConfiguration build() {
            return new LoggerConfiguration(this);
        }
    }
}
