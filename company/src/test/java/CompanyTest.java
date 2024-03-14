import org.javaacademy.*;
import org.javaacademy.programmer.Programmer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.javaacademy.programmer.Task;

import java.util.*;

class CompanyTest {
    Company company;
    @Mock
    Manager manager = Mockito.mock(Manager.class);
    List<Programmer> mockList = Mockito.mock(ArrayList.class);
    Programmer programmer1 = Mockito.mock(Programmer.class);
    Programmer programmer2 = Mockito.mock(Programmer.class);


    @Test
    void giveMoneyTest() {
        Company company = new Company("test", manager, mockList, 1700);
        company.weeklyPayment();
        for (Map.Entry<Employee, Double> table : company.getReportCard().entrySet()) {
            Employee employee = table.getKey();
            Assertions.assertNotNull(employee);
        }
        Assertions.assertEquals(0, company.getReportCard().size());
    }

    @Test
    void weekTaskTest() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(Mockito.mock(Task.class));
        tasks.add(Mockito.mock(Task.class));
        Company company = new Company("test", manager,
                List.of(programmer1, programmer2), 1700);
        company.weeklyWork(tasks);
        Assertions.assertEquals(0, tasks.size());
    }

    @Test
    void workerMoneyNotZeroTest() {
        Company company = new Company("test", manager,
                List.of(programmer1, programmer2), 1700);
        for (Map.Entry<Employee, Double> table : company.getReportCard().entrySet()) {
            Employee employee = table.getKey();
            Assertions.assertNotEquals(null, employee);
            employee.setAmountOfEarnings(employee.getAmountOfEarnings()
                    + (table.getValue() * employee.getHourlyRate()));
            Assertions.assertNotEquals(0, employee.getAmountOfEarnings());
        }
    }
}