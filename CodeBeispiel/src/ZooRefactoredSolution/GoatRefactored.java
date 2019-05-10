package ZooRefactoredSolution;

public class GoatRefactored {
    private int age;
    private int weight;

    public GoatRefactored(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Age: " + this.getAge() + " Weight: " + this.getWeight() + ",\r\n";
    }
}
