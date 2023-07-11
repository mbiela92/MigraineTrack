package de.biela.migraine.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Migraine {
    public Migraine() {

    }
    public enum PainSeverity {
        WEAK, MEDIUM, STRONG
    }
    private UUID id;
    private LocalDate date;
    private String description;
    public PainSeverity painSeverity;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;

    public Migraine(UUID id, LocalDate date, String description, PainSeverity painSeverity,
                    LocalDateTime creationTimestamp, LocalDateTime modificationTimestamp) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.painSeverity = painSeverity;
        this.creationTimestamp = creationTimestamp;
        this.modificationTimestamp = modificationTimestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PainSeverity getPainSeverity() {
        return painSeverity;
    }

    public void setPainSeverity(PainSeverity painSeverity) {
        this.painSeverity = painSeverity;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocalDateTime getModificationTimestamp() {
        return modificationTimestamp;
    }

    public void setModificationTimestamp(LocalDateTime modificationTimestamp) {
        this.modificationTimestamp = modificationTimestamp;
    }

    @Override
    public String toString() {
        return "\nMigraine{\n" +
                "id=" + id +
                ",\ndate=" + date +
                ",\ndescription=" + description +
                ",\npainSeverity=" + painSeverity +
                ",\ncreationTimestamp=" + creationTimestamp +
                ",\nmodificationTimestamp=" + modificationTimestamp +
                '}';
    }
}
