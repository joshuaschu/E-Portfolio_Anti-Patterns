package ZooRefactoredSolution;

import java.util.ArrayList;

public class AnimalKeeper {
    private ArrayList<GoatRefactored> goats;
    private ArrayList<LionRefactored> lions;

    public AnimalKeeper(ArrayList<GoatRefactored> goats, ArrayList<LionRefactored> lions) {
        this.goats = goats;
        this.lions = lions;
    }

    public void feedLions() {
        for (LionRefactored lion : lions) {
            lion.setWeight(lion.getWeight() + 1);
        }
    }

    public void feedGoats() {
        for (GoatRefactored goat : goats) {
            goat.setWeight(goat.getWeight() + 1);
        }
    }
    public ArrayList<LionRefactored> getLions(){
        return lions;
    }

    public ArrayList<GoatRefactored> getGoats() {
        return goats;
    }
}
