package de.biela.migraine.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DrugIntake {
    public DrugIntake() {

    }
    public enum Drug {
        IBU, TRIPTAN, PARACETAMOL
    }

    public enum AmountEntity {
        GRAMS, PIECE
    }
    private UUID id;
    private Drug drug;
    private AmountEntity amountEntity;
    private BigDecimal amount;
    private LocalDateTime takeTimestamp;
    private UUID migraineId;
    private LocalDateTime creationTimestamp;
    private LocalDateTime modificationTimestamp;

    public DrugIntake(UUID id, Drug drug, AmountEntity amountEntity, BigDecimal amount,
                      LocalDateTime takeTimestamp, UUID migraineId, LocalDateTime creationTimestamp,
                      LocalDateTime modificationTimestamp) {
        this.id = id;
        this.drug = drug;
        this.amountEntity = amountEntity;
        this.amount = amount;
        this.takeTimestamp = takeTimestamp;
        this.migraineId = migraineId;
        this.creationTimestamp = creationTimestamp;
        this.modificationTimestamp = modificationTimestamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public AmountEntity getAmountEntity() {
        return amountEntity;
    }

    public void setAmountEntity(AmountEntity amountEntity) {
        this.amountEntity = amountEntity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTakeTimestamp() {
        return takeTimestamp;
    }

    public void setTakeTimestamp(LocalDateTime takeTimestamp) {
        this.takeTimestamp = takeTimestamp;
    }

    public UUID getMigraineId() {
        return migraineId;
    }

    public void setMigraineId(UUID migraineId) {
        this.migraineId = migraineId;
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
        return "\nDrugIntake{\n" +
                "id=" + id +
                ", \ndrug=" + drug +
                ", \namountEntity=" + amountEntity +
                ", \namount=" + amount +
                ", \ntakeTimestamp=" + takeTimestamp +
                ", \nmigraineId=" + migraineId +
                ", \ncreationTimestamp=" + creationTimestamp +
                ", \nmodificationTimestamp=" + modificationTimestamp +
                '}';
    }
}
