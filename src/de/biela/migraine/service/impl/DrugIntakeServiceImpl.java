package de.biela.migraine.service.impl;

import de.biela.migraine.dao.JDBCUtils;
import de.biela.migraine.model.DrugIntake;
import de.biela.migraine.model.Migraine;

import java.math.BigDecimal;
import java.sql.*;
import java.util.UUID;

import static de.biela.migraine.service.impl.ServiceImplUtils.getLocalDateTime;

public class DrugIntakeServiceImpl implements de.biela.migraine.service.DrugIntakeService {


    @Override
    public void createDrugIntake(DrugIntake drugIntake) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "INSERT INTO drugintake (id, drug, amountEntity, amount, takeTimestamp, migraineId, creationTimestamp, modificationTimestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,drugIntake.getId().toString());
            statement.setString(2, drugIntake.getDrug().toString());
            statement.setString(3, drugIntake.getAmountEntity().toString());
            statement.setBigDecimal(4, drugIntake.getAmount());
            statement.setTimestamp(5, Timestamp.valueOf(drugIntake.getTakeTimestamp()));
            statement.setString(6, drugIntake.getMigraineId().toString());
            statement.setTimestamp(7, Timestamp.valueOf(drugIntake.getCreationTimestamp()));
            statement.setTimestamp(8, Timestamp.valueOf(drugIntake.getModificationTimestamp()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateDrugIntake(UUID id, DrugIntake drugIntake) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "UPDATE drugintake SET drug = ?, amountEntity = ?, amount = ?, takeTimestamp = ?, migraineId = ?, modificationTimestamp = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, drugIntake.getDrug().toString());
            statement.setString(2, drugIntake.getAmountEntity().toString());
            statement.setBigDecimal(3, drugIntake.getAmount());
            statement.setTimestamp(4, Timestamp.valueOf(drugIntake.getTakeTimestamp()));
            statement.setString(5, drugIntake.getMigraineId().toString());
            statement.setTimestamp(6, Timestamp.valueOf(drugIntake.getModificationTimestamp()));
            statement.setString(7, id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DrugIntake getDrugIntake(UUID id) {
        DrugIntake drugIntake = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "SELECT * FROM drugIntake WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                drugIntake = new DrugIntake();
                drugIntake.setId(UUID.fromString(resultSet.getString("id")));
                drugIntake.setDrug(DrugIntake.Drug.valueOf(resultSet.getString("drug")));
                drugIntake.setAmountEntity(DrugIntake.AmountEntity.valueOf(resultSet.getString("amountEntity")));
                drugIntake.setAmount(BigDecimal.valueOf(resultSet.getInt("amount")));
                drugIntake.setTakeTimestamp(getLocalDateTime(resultSet,"takeTimestamp"));
                drugIntake.setMigraineId(UUID.fromString(resultSet.getString("migraineId")));
                drugIntake.setCreationTimestamp(getLocalDateTime(resultSet, "creationTimestamp"));
                drugIntake.setModificationTimestamp(getLocalDateTime(resultSet, "modificationTimestamp"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugIntake;
    }

    @Override
    public void deleteDrugIntake(UUID id) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String query = "DELETE FROM drugintake WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,id.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
