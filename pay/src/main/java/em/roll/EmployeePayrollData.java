package em.roll;
/**
 * class that holds the properties of Employee
 */
public class EmployeePayrollData {
    private int id;
    private String name;
    private double salary;

    /**
     * constructor  to innitilize the object properties
     * @param id
     * @param name
     * @param salary
     */
    public EmployeePayrollData(Integer id,String name,Double salary)
    {
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    /**
     * returns string
     */
    public String toString()
    {
        return id+","+name+","+salary;
    }
}