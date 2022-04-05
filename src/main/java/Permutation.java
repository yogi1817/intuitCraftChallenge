import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

public class Permutation {
    public static void main(String args[]){
        Employee anika = new Employee("Anika",  null);
        Employee kanika = new Employee("kanika", List.of(anika));
        Employee yogesh = new Employee("Yogesh", List.of(kanika));
        Employee mom = new Employee("Mom", List.of(yogesh, kanika));

        Employee ceo = findCEO(List.of(yogesh, kanika, anika, mom));
        System.out.println("ceo ->"+ ceo);
        System.out.println(findChainOfCommand(ceo, kanika));
        System.out.println(findChainOfCommand(ceo, anika));
    }

    private static LinkedList<String> findChainOfCommand(Employee ceo, Employee employee) {
        LinkedList<String> chainOfCommand = new LinkedList<>();
        findChainOfCommand(ceo, employee, chainOfCommand, true);
        return chainOfCommand;
    }

    private static void findChainOfCommand(Employee employeeLooking, Employee employee, LinkedList<String> chain, boolean found){
        if(!found){
            return;
        }

        if(employeeLooking.getEmployeeName().equals(employee.getEmployeeName())){
            return;
        }else if(employeeLooking.getReporte()==null){
            found = false;
            return;
        } else{
            boolean finalFound = found;
            employeeLooking.getReporte().forEach(reportee-> {
                chain.add(reportee.getEmployeeName());
                findChainOfCommand(reportee, employee, chain, finalFound);
            });
        }
    }

    private static Employee findCEO(List<Employee> employeeList) {
        Set<Employee> employeeSet = employeeList.stream()
                .filter(employee -> employee.getReporte()!=null)
                .flatMap(employee -> employee.getReporte().stream())
                .collect(Collectors.toSet());
        return employeeList.stream()
                .filter(emp -> !employeeSet.contains(emp))
                .findFirst().get();
    }
}

@AllArgsConstructor
@Data
@EqualsAndHashCode
class Employee{
    String employeeName;
    List<Employee> reporte;

    public String toString(){
        return this.employeeName;
    }
}
