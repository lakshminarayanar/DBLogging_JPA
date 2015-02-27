package com.hlb.dblogging.log.utility;

public enum LogLevel {
    DEBUG("debug"),
    INFO("info"),
    WARN("warn"),
    ERROR("error"),
    FATAL("fatal"),
    ALL("all")
    ;

    private final String text;

    /**
     * @param text
     */
    private LogLevel(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}