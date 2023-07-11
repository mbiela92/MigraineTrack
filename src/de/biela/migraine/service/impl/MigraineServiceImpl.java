package de.biela.migraine.service.impl;

import de.biela.migraine.dao.JDBCUtils;
import de.biela.migraine.model.Migraine;
import static de.biela.migraine.service.impl.ServiceImplUtils.*;

import java.sql.*;
import java.util.UUID;

public class MigraineServiceImpl implements de.biela.migraine.service.MigraineService {



    @Override
    public void createMigraine(Migraine migraine) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "INSERT INTO migraine (id, date, description, painSeverity, creationTimestamp, modificationTimestamp) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,migraine.getId().toString());
            statement.setDate(2, Date.valueOf(migraine.getDate()));
            statement.setString(3, migraine.getDescription());
            statement.setString(4, migraine.getPainSeverity().toString());
            statement.setTimestamp(5, Timestamp.valueOf(migraine.getCreationTimestamp()));
            statement.setTimestamp(6, Timestamp.valueOf(migraine.getModificationTimestamp()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMigraine(UUID id, Migraine migraine) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "UPDATE migraine SET date = ?, description = ?, painSeverity = ?, modificationTimestamp = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, Date.valueOf(migraine.getDate()));
            statement.setString(2, migraine.getDescription());
            statement.setString(3, migraine.getPainSeverity().toString());
            statement.setTimestamp(4, Timestamp.valueOf(migraine.getModificationTimestamp()));
            statement.setString(5, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Migraine getMigraine(UUID id) {
        Migraine migraine = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "SELECT * FROM migraine WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                migraine = new Migraine();
                migraine.setId(UUID.fromString(resultSet.getString("id")));
                migraine.setDate(resultSet.getDate("date").toLocalDate());
                migraine.setDescription(resultSet.getString("description"));
                migraine.setPainSeverity((Migraine.PainSeverity.valueOf(resultSet.getString("painSeverity"))));
                migraine.setCreationTimestamp(getLocalDateTime(resultSet, "creationTimestamp"));
                migraine.setModificationTimestamp(getLocalDateTime(resultSet, "modificationTimestamp"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return migraine;
    }

    @Override
    public void deleteMigraine(UUID id) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "DELETE FROM migraine WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
