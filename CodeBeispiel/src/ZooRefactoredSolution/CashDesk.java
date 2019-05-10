package ZooRefactoredSolution;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashDesk {
    private BigDecimal money;

    public CashDesk(double money) {
        this.money = new BigDecimal(money);
    }

    public void newVisitors(int visitors) {
        //75*1.14=85.5 ;-)
        BigDecimal result = new BigDecimal("1.14").multiply(new BigDecimal(visitors));
        money = money.add(result);
    }

    public String getMoney(){
        return  money.setScale(0, RoundingMode.HALF_UP).toString();
    }
}
