public class Employee1 {
    private int id;
    private String name;
    private String position;
    private double hourlyRate;
    public Employee1(int id, String name, String position, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Position: " + position + ", Hourly Rate: $" + hourlyRate;
    }
}
