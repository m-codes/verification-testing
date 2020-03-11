package cm;

import java.math.BigDecimal;

public interface ICalculateStrategy {
    BigDecimal calculate(BigDecimal bigDecAmount);
}

class StudentStrategy implements ICalculateStrategy {

    public BigDecimal calculate(BigDecimal bigDecAmount) {
        BigDecimal studentThreshold = new BigDecimal("5.5");
        BigDecimal studentReductionPercentage = new BigDecimal("0.25");

        if (bigDecAmount.compareTo(studentThreshold) == 1) {
            bigDecAmount = bigDecAmount.subtract(bigDecAmount.multiply(studentReductionPercentage));
        }
        return bigDecAmount;
    }
}

class StaffStrategy implements ICalculateStrategy {

    public BigDecimal calculate(BigDecimal bigDecAmount) {
        BigDecimal staffMaxPayable = new BigDecimal("16.0");

        if (bigDecAmount.compareTo(staffMaxPayable) == 1) {
            //maximum payable is 16.00 per day
            bigDecAmount = staffMaxPayable;
        }
        return bigDecAmount;
    }
}

class ManagementStrategy implements ICalculateStrategy {

    public BigDecimal calculate(BigDecimal bigDecAmount) {
        BigDecimal managementMinPayable = new BigDecimal("3.0");

        if (bigDecAmount.compareTo(managementMinPayable) == -1) {
            //maximum payable is 16.00 per day
            bigDecAmount = managementMinPayable;
        }
        return bigDecAmount;
    }
}

class VisitorStrategy implements ICalculateStrategy {

    public BigDecimal calculate(BigDecimal bigDecAmount) {
        BigDecimal visitorThresholdAndDeduction = new BigDecimal("8.0");
        BigDecimal visitorReductionPercentage = new BigDecimal("0.5");

        if (bigDecAmount.compareTo(visitorThresholdAndDeduction) <= 0) {
            //first 8.00 is free for visitor
            bigDecAmount = bigDecAmount.ZERO;
        } else {
            bigDecAmount = bigDecAmount.subtract(visitorThresholdAndDeduction);
            bigDecAmount = bigDecAmount.multiply(visitorReductionPercentage);
        }
        return bigDecAmount;
    }
}

