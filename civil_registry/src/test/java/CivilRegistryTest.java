import org.javaacademy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;

public class CivilRegistryTest {
    @Mock
    Citizen citizen1;
    @Mock
    Citizen citizen2;
    @Mock
    Citizen citizen3;
    @Mock
    LocalDate localDate;
    CivilRegistry civilRegistry;


    @BeforeEach
    void init() {
        civilRegistry = new CivilRegistry("test");
        citizen1 = new Citizen("test1", "test1,",
                "test1,", true, FamilyType.NOT_MARRIED);
        citizen2 = new Citizen("test2", "test2",
                "test2", false, FamilyType.NOT_MARRIED);
        citizen3 = new Citizen("test2", "test2",
                "test2", false, FamilyType.NOT_MARRIED);
        localDate = Mockito.mock(LocalDate.class);
    }
    @Test
    void nameNotNullTest(){
        Assertions.assertNotNull(civilRegistry.getName());
    }

    @Test
    void childBirthTest() {
        CivilRegistry civilRegistry = new CivilRegistry("test");
        int prevSize = civilRegistry.getCitizenRecordings().size();
        civilRegistry.childBirth(citizen1, citizen2, citizen3, localDate);
        Assertions.assertEquals(prevSize + 1, civilRegistry.getCitizenRecordings().size());
    }

    @Test
    void weddingRegistrationThrows() {
        citizen1.setMale(true);
        citizen2.setMale(true);
        civilRegistry = Mockito.mock(CivilRegistry.class);
        Mockito.doThrow(RuntimeException.class)
                .when(civilRegistry).weddingRegistration(citizen1, citizen2, localDate);
    }

    @Test
    void weddingRegistrationNotThrows() {
        Assertions.assertDoesNotThrow(() -> civilRegistry.weddingRegistration(citizen1,
                citizen2, localDate));
        Assertions.assertEquals(citizen1, citizen2.getMarriedWith());
    }

    @Test
    void divorceRegistrationTestSuccess() {
        civilRegistry.divorceRegistration(citizen1, citizen2, localDate);
        Assertions.assertNull(citizen1.getMarriedWith());
        Assertions.assertEquals(citizen1.getFamilyType(), citizen2.getFamilyType());
    }
    @Test
    void divorceRegistrationTestThrows() {
        Assertions.assertThrows(RuntimeException.class,
                () -> civilRegistry.divorceRegistration(citizen2, citizen3, localDate));
    }

    @Test
    void makeStatisticsTest() {
        localDate = LocalDate.of(2024, 3, 4);
        Assertions.assertNotNull(civilRegistry.makeStatistics(localDate));
    }
}

