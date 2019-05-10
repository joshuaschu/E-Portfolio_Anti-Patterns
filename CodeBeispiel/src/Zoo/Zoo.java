package Zoo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Zoo {
    private boolean gates = false;
    private double money = 0;
    private ArrayList<Goat> goats = null;
    private ArrayList<Lion> lions = null;
    private Random random;

    public Zoo() {
        goats = new ArrayList<Goat>();
        lions = new ArrayList<Lion>();
        random = new Random();
        this.init();
        boolean open = this.isZooOpen();
        this.moveGates(open);
        this.feedGoats();
        this.feedLions();
        this.newVisitors(75);
    }

    private void newVisitors(int visitors) {
        //75*1.14=85.5 ;-)
        money += 1.14 * visitors;
    }

    private void feedLions() {
        for (Lion lion : lions) {
            lion.setWeight(lion.getWeight() + 1);
        }
    }

    private void feedGoats() {
        for (Goat goat : goats) {
            goat.setWeight(goat.getWeight() + 1);
        }
    }

    private void moveGates(boolean open) {
        gates = open;
    }

    private void init() {
        for (int i = 0; i < 25; i++) {
            goats.add(new Goat(i, i * random.nextInt((5 - 1) + 1) + 1));
        }
        for (int j = 0; j < 5; j++) {
            lions.add(new Lion(j + 5, 50, this.calcWeight(j + 5)));
        }
    }

    private int calcWeight(int age) {
        int result = 1;
        for (int i = 1; i <= 3; i++) {
            result *= age;
        }
        return result;
    }

    public boolean isZooOpen() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        if (date.getHours() >= 9 && date.getHours() < 17) {
            return Boolean.valueOf("true");
        }
        return Boolean.valueOf("false");
    }

    private String getLionText(Lion lion) {
        return "Age: " + lion.getAge() + " Weight: " + lion.getWeight() + ",\r\n";
    }

    private String getGoatText(Goat goat) {
        return "Age: " + goat.getAge() + " Weight: " + goat.getWeight() + ",\r\n";
    }

    @Override
    public String toString() {
        String result = "";
        result += "There are the following lions in the zoo: ";
        for (Lion lion : lions) {
            result += this.getLionText(lion);
        }
        result += "And here are the goats:";
        for (Goat goat : goats) {
            result += this.getGoatText(goat);
        }
        result += "The Zoo earned " + Math.round(money) + " euro today!\r\n";
        if (gates) {
            result += "And the Zoo is open!";
        } else {
            result += "But the Zoo is closed!";
        }
        return result;
    }
}
