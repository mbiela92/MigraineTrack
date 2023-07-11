
import de.biela.migraine.model.Migraine;
import de.biela.migraine.service.impl.MigraineServiceImpl;
import org.junit.jupiter.api.*;
import de.biela.migraine.model.Migraine.PainSeverity; // Beispiel-Paketstruktur


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MigraineServiceImplTest {




    private static MigraineServiceImpl migraineServiceImpl;
    private static Migraine migraine;
    private void assertMigraineProperties(Migraine expected, Migraine actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getDate(), actual.getDate());
        assertEquals(expected.getDescription(), actual.getDescription());
        assertEquals(expected.getPainSeverity(), actual.getPainSeverity());
        assertEquals(expected.getCreationTimestamp(), actual.getCreationTimestamp());
        assertEquals(expected.getModificationTimestamp(), actual.getModificationTimestamp());
    }

    @BeforeAll
    public static void setUp() {
        migraineServiceImpl = new MigraineServiceImpl();
        migraine = new Migraine(
                UUID.randomUUID(),
                LocalDate.now(),
                "Test Migräne",
                PainSeverity.STRONG,
                LocalDateTime.now().withNano(0),
                LocalDateTime.now().withNano(0)
        );
    }

    @AfterAll
    public static void tearDown() {
            migraineServiceImpl = null;
            migraine = null;
        }

    @Test
    @Order(1)
    public void TestCreateAndGetMigraine() {
        //GIVEN
        migraineServiceImpl.createMigraine(migraine);

        //WHEN
        Migraine getMigraine = migraineServiceImpl.getMigraine(migraine.getId());

        //THEN
        assertAll("migraine",
                () -> assertMigraineProperties(migraine,getMigraine)
        );
    }

    @Test
    @Order(2)
    public void TestUpdateAndGetMigraine() {
        //GIVEN
        migraine.setDescription("Update Test Migraine");
        //WHEN

        migraineServiceImpl.updateMigraine(migraine.getId(),migraine);
        Migraine getMigraine = migraineServiceImpl.getMigraine(migraine.getId());

        //THEN
        assertAll("migraine",
                () -> assertMigraineProperties(migraine,getMigraine)
        );
    }
    @Test
    @Order(3)
    public void TestDeleteAndGetMigraine() {
        //GIVEN

        //WHEN
        migraineServiceImpl.deleteMigraine(migraine.getId());
        Migraine getMigraine = migraineServiceImpl.getMigraine(migraine.getId());

        //THEN
        assertNull(getMigraine);
    }
}

