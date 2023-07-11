import de.biela.migraine.model.DrugIntake;
import de.biela.migraine.model.Migraine;
import de.biela.migraine.service.impl.DrugIntakeServiceImpl;
import de.biela.migraine.service.impl.MigraineServiceImpl;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DrugIntakeServiceImplTest {
    private static DrugIntakeServiceImpl drugIntakeServiceImpl;
    private static MigraineServiceImpl migraineServiceImpl;
    private static DrugIntake drugIntake;

    private void assertDrugIntakeProperties(DrugIntake expected, DrugIntake actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getDrug(), actual.getDrug());
        assertEquals(expected.getAmountEntity(), actual.getAmountEntity());
        assertEquals(expected.getAmount(), actual.getAmount());
        assertEquals(expected.getTakeTimestamp(), actual.getTakeTimestamp());
        assertEquals(expected.getMigraineId(), actual.getMigraineId());
        assertEquals(expected.getCreationTimestamp(), actual.getCreationTimestamp());
        assertEquals(expected.getModificationTimestamp(), actual.getModificationTimestamp());
    }
    @BeforeAll
    public static void setUp() {
        drugIntakeServiceImpl = new DrugIntakeServiceImpl();
        migraineServiceImpl = new MigraineServiceImpl();
        Migraine migraine = migraineServiceImpl.getMigraine(UUID.fromString("dab2acc6-a5e2-43ca-853f-a5084b35efc8"));
        drugIntake = new DrugIntake(
                UUID.randomUUID(),
                DrugIntake.Drug.PARACETAMOL,
                DrugIntake.AmountEntity.PIECE,
                new BigDecimal(2),
                LocalDateTime.now().withNano(0),
                migraine.getId(),
                LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0)
        );
    }

    @AfterAll
    public static void tearDown() {
        drugIntakeServiceImpl = null;
        drugIntake = null;
    }

    @Test
    @Order(1)
    public void TestCreateAndGetMigraine() {
        //GIVEN
        drugIntakeServiceImpl.createDrugIntake(drugIntake);
        //WHEN
        DrugIntake getDrugIntake = drugIntakeServiceImpl.getDrugIntake(drugIntake.getId());

        //THEN
        assertAll("migraine",
                () -> assertDrugIntakeProperties(drugIntake,getDrugIntake)
        );
    }

    @Test
    @Order(2)
    public void TestUpdateAndGetDrugIntake() {
        //GIVEN
        drugIntake.setDrug(DrugIntake.Drug.IBU);

        //WHEN
        drugIntakeServiceImpl.updateDrugIntake(drugIntake.getId(),drugIntake);
        DrugIntake getDrugIntake = drugIntakeServiceImpl.getDrugIntake(drugIntake.getId());

        //THEN
        assertAll("drugIntake",
                () -> assertDrugIntakeProperties(drugIntake,getDrugIntake)
        );
    }

    @Test
    @Order(3)
    public void TestDeleteAndGetDrugIntake() {
        //GIVEN

        //WHEN
        drugIntakeServiceImpl.deleteDrugIntake(drugIntake.getId());
        DrugIntake getDrugIntake = drugIntakeServiceImpl.getDrugIntake(drugIntake.getId());

        //THEN
        assertNull(getDrugIntake);
    }




}
