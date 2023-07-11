package de.biela.migraine.application;

import de.biela.migraine.model.Migraine;
import de.biela.migraine.service.impl.DrugIntakeServiceImpl;
import de.biela.migraine.service.impl.MigraineServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


public class Main {
    static String jdbcURL = "jdbc:mysql://localhost:3306/migraine_db?useSSL=false&serverTimezone=UTC";
    static String jdbcUsername = "root";
    static String jdbcPassword = "";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Datenbankverbindung hergestellt");
        } catch (SQLException e) {
            // Auto-generated catch block
            e.printStackTrace();
            System.out.println("Fehler beim Verbindungsaufbau zur Datenbank");
        }
        return connection;
    }
    public static void main(String[] args) {
        getConnection();












        // Initialisiere die erforderlichen Objekte, wie DAOs und Services
        /*MigraineDAO migraineDAO = new MigraineDAO();
        DrugIntakeDAO drugIntakeDAO = new DrugIntakeDAO();*/
        MigraineServiceImpl migraineServiceImpl = new MigraineServiceImpl();
        DrugIntakeServiceImpl drugIntakeServiceImpl = new DrugIntakeServiceImpl();

        // Führe CRUD-Operationen aus
        Migraine migraine = new Migraine(UUID.randomUUID(), LocalDate.now(),"jojo", Migraine.PainSeverity.WEAK, LocalDateTime.now(),LocalDateTime.now());
        Migraine migraineup = new Migraine(UUID.randomUUID(), LocalDate.now(),"jojoaaaaaaa", Migraine.PainSeverity.WEAK, LocalDateTime.now(),LocalDateTime.now());
        migraineServiceImpl.createMigraine(migraine);
        System.out.println(UUID.randomUUID());
        //migraineServiceImpl.deleteMigraine(migraine.getId());
        System.out.println(migraineServiceImpl.getMigraine(migraine.getId()));
        migraineServiceImpl.updateMigraine(migraine.getId(),migraineup);
        System.out.println("\n" + migraineServiceImpl.getMigraine(migraine.getId()));
/*
        Migraine retrievedMigraine = migraineServiceImpl.getMigraine(migraine.getId());
        System.out.println(retrievedMigraine);
        // Weitere Operationen ausführen, z.B. Update oder Löschen

        DrugIntake drugIntake = new DrugIntake(UUID.randomUUID(), DrugIntake.Drug.PARACETAMOL, DrugIntake.AmountEntity.GRAMS, 10, LocalDateTime.now(), UUID.randomUUID(),LocalDateTime.now(), LocalDateTime.now());
        drugIntakeService.createDrugIntake(drugIntake);

        DrugIntake retrievedDrugIntake = drugIntakeService.getDrugIntake(drugIntake.getId());
        // Weitere Operationen ausführen, z.B. Update oder Löschen

        // Weitere Logik und Anwendungsfälle hier implementieren*/
    }
}
