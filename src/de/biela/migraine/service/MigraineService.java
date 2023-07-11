package de.biela.migraine.service;

import de.biela.migraine.model.Migraine;

import java.util.UUID;

public interface MigraineService {
    void createMigraine(Migraine migraine);

    void updateMigraine(UUID id, Migraine migraine);

    Migraine getMigraine(UUID id);

    void deleteMigraine(UUID id);
}
