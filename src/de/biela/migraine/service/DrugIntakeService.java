package de.biela.migraine.service;

import de.biela.migraine.model.DrugIntake;
import de.biela.migraine.model.Migraine;

import java.util.UUID;

public interface DrugIntakeService {
    void createDrugIntake(DrugIntake drugIntake);

    void updateDrugIntake(UUID id, DrugIntake drugIntake);

    DrugIntake getDrugIntake(UUID id);

    void deleteDrugIntake(UUID id);
}
