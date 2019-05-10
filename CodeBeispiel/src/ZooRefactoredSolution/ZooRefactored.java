package ZooRefactoredSolution;

import java.util.*;

public class ZooRefactored {
    private static final int OPENING = 9;
    private static final int CLOSING = 17;

    //Overkill initialization
    private boolean gates;

    private Random random;
    private CashDesk cashDesk;
    private AnimalKeeper animalKeeper;

    public ZooRefactored() {
        random = new Random();
        cashDesk = new CashDesk(0.0);
        this.initAnimalKeeper();
        boolean open = this.isZooOpen();
        this.moveGates(open);
        animalKeeper.feedGoats();
        animalKeeper.feedLions();
        cashDesk.newVisitors(75);
    }

    private void moveGates(boolean open) {
        gates = open;
    }

    private void initAnimalKeeper() {
        ArrayList<GoatRefactored> goats = new ArrayList<>();
        ArrayList<LionRefactored> lions = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            goats.add(new GoatRefactored(i, i * random.nextInt((5 - 1) + 1) + 1));
        }
        for (int j = 0; j < 5; j++) {
            lions.add(new LionRefactored(j + 5, 50));
        }
        animalKeeper = new AnimalKeeper(goats, lions);
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

    @Override
    public String toString() {
        //well estimated buffer
        StringBuilder result = new StringBuilder(animalKeeper.getLions().size() * 20 + animalKeeper.getGoats().size() * 20 + 200);
        result.append("There are the following lions in the zoo: ");
        for (LionRefactored lion : animalKeeper.getLions()) {
            result.append(lion.toString());
        }
        result.append("And here are the goats:");
        for (GoatRefactored goat : animalKeeper.getGoats()) {
            result.append(goat.toString());
        }
        result.append("The Zoo earned ").append(cashDesk.getMoney()).append(" euro today!\r\n");
        if (gates) {
            result.append("And the Zoo is open!");
        } else {
            result.append("But the Zoo is closed!");
        }
        return result.toString();
    }
}
