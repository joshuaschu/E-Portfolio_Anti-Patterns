package ZooRefactoredSolution;

public class LionRefactored {
    private int age;
    private int weight;
    private int toothCount;

    public LionRefactored(int age, int toothCount) {
        this.age = age;
        this.toothCount = toothCount;
        this.weight = calcWeight(this.age);
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

    public int getToothCount() {
        return toothCount;
    }

    public void setToothCount(int toothCount) {
        this.toothCount = toothCount;
    }

    private int calcWeight(int age) {
        //we can use the math function cause it does the same
        return (int) Math.pow(age,3);
    }

    @Override
    public String toString() {
        return "Age: " + this.getAge() + " Weight: " + this.getWeight() + ",\r\n";
    }
}
