Logger Library

A flexible and configurable logging library for applications.

Key Features:

    Message Levels: Supports various message levels (DEBUG, INFO, WARN, ERROR, FATAL) for different logging needs.
    Customizable Sinks: Allows for logging to various destinations (e.g., text files, databases, console) based on configuration.
    Timestamp Enrichment: Automatically adds timestamps to log messages for easy tracking.
    Namespace Identification: Identifies the part of the application that sent the message using namespaces.
    Configuration-Driven: Easily configure logging behavior using a simple configuration file.

Usage:

    Configure the logger library:
        Create a configuration file in the desired format (e.g., JSON, YAML).
        Specify logging level, sink type, sink details, and other options.
    Initialize the logger:
        Use the library's initialization function to load the configuration and create the logger instance.
    Log messages:
        Use the logger's logging methods (e.g., debug, info, warn, error, fatal) to log messages with the appropriate level and namespace.
