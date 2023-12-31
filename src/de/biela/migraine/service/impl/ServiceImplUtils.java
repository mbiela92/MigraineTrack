package de.biela.migraine.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ServiceImplUtils {
    public static LocalDateTime getLocalDateTime(ResultSet result, String columnLabel) throws SQLException {
        Timestamp creationTimestamp = result.getTimestamp(columnLabel);
        return creationTimestamp.toLocalDateTime();
    }
}
