public class Employee {
    private int id;
    private String full_name;
    private String position;
    private int id_shop;
    private String age;
    private String salary;

    public Employee(int id, String full_name, String position, int id_shop, String age, String salary) {
        this.id = id;
        this.full_name = full_name;
        this.position = position;
        this.id_shop = id_shop;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String login) {
        this.full_name = full_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPassword(String password) {
        this.position = position;
    }

    public int getId_shop() {
        return id_shop;
    }

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
