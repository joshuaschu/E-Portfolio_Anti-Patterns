package ZooSolution;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ZooS {
    private static final int OPENING = 9;
    private static final int CLOSING = 17;

    //Overkill initialization
    private boolean gates;
    //Storing money in floating point variables...
    private BigDecimal money;
    private ArrayList<GoatS> goats;
    private ArrayList<LionS> lions;
    private Random random;

    public ZooS() {
        goats = new ArrayList<>();
        lions = new ArrayList<>();
        random = new Random();
        money = new BigDecimal(0);
        this.init();
        boolean open = this.isZooOpen();
        this.moveGates(open);
        this.feedGoats();
        this.feedLions();
        this.newVisitors(75);
    }

    private void newVisitors(int visitors) {
        //75*1.14=85.5 ;-)
        BigDecimal result = new BigDecimal("1.14").multiply(new BigDecimal(visitors));
        money = money.add(result);
    }

    private void feedLions() {
        for (LionS lion : lions) {
            lion.setWeight(lion.getWeight() + 1);
        }
    }

    private void feedGoats() {
        for (GoatS goat : goats) {
            goat.setWeight(goat.getWeight() + 1);
        }
    }

    private void moveGates(boolean open) {
        gates = open;
    }

    private void init() {
        for (int i = 0; i < 25; i++) {
            goats.add(new GoatS(i, i * random.nextInt((5 - 1) + 1) + 1));
        }
        for (int j = 0; j < 5; j++) {
            lions.add(new LionS(j + 5, 50, this.calcWeight(j + 5)));
        }
    }

    private int calcWeight(int age) {
        //we can use the math function cause it does the same
       return (int) Math.pow(age,3);
    }

    public boolean isZooOpen() {
        //Calender.getInstance() can return several versions of a calender
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("Europe/Zurich"));
        //we use constants to avoid "magic values"
        if (cal.get(Calendar.HOUR_OF_DAY) >= this.OPENING && cal.get(Calendar.HOUR_OF_DAY) < this.CLOSING) {
            //booleans are immutable and have build-in caches for the instances
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private String getLionText(LionS lion) {
        return "Age: " + lion.getAge() + " Weight: " + lion.getWeight() + ",\r\n";
    }

    private String getGoatText(GoatS goat) {
        return "Age: " + goat.getAge() + " Weight: " + goat.getWeight() + ",\r\n";
    }

    @Override
    public String toString() {
        //well estimated buffer
        StringBuilder result = new StringBuilder(lions.size()*20+goats.size()*20+200);
        result.append( "There are the following lions in the zoo: ");
        for (LionS lion : lions) {
            result.append( this.getLionText(lion));
        }
        result.append( "And here are the goats:");
        for (GoatS goat : goats) {
            result.append( this.getGoatText(goat));
        }
        result.append( "The Zoo earned " + money.setScale(0, RoundingMode.HALF_UP) + " euro today!\r\n");
        if (gates) {
            result.append( "And the Zoo is open!");
        } else {
            result.append( "But the Zoo is closed!");
        }
        return result.toString();
    }
}
