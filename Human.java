public class Human {

    private String name;
    private String surname;
    private int age;
    private String sex;
    private int growth;
    private double weight;

    public Human(String name, String surname, int age, String sex, int growth, double weight) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.growth = growth;
        this.weight = weight;
    }

    public Human() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String name) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.getName() != null) {
            stringBuilder.append("The " + this.getSex() + " " + this.getName() + " " + this.getSurname() + "'s age is " + this.getAge() + ", growth is " + this.getGrowth() + " sm and weight is " + this.getWeight() + " kg.");
        }
        return stringBuilder.toString();
    }
}
