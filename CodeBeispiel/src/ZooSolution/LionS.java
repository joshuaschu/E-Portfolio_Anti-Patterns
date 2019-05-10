package ZooSolution;

public class LionS {
    private int age;
    private int weight;
    private int toothCount;

    public LionS(int age, int toothCount, int weight) {
        this.age = age;
        this.toothCount = toothCount;
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

    public int getToothCount() {
        return toothCount;
    }

    public void setToothCount(int toothCount) {
        this.toothCount = toothCount;
    }
}
