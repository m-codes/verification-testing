package cm;

import java.math.BigDecimal;

public class CalculateStrategyContext {
    ICalculateStrategy calculateStrategy;

    public void setCalculateStrategy(ICalculateStrategy calculateStrategy){
        this.calculateStrategy = calculateStrategy;
    }

    public BigDecimal calculateAmount(BigDecimal bigDecAmount){
        return calculateStrategy.calculate(bigDecAmount);
    }
}
