package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CM on 01/02/2018.
 */
public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     *
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     *
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size() - 1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>) list).subList(i + 1, lastIndex + 1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     *
     * @param period the Period addition
     * @param list   the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }

    private BigDecimal reductions(BigDecimal bigDecAmount) {
        BigDecimal studentThreshold = new BigDecimal("5.5");
        BigDecimal studentReductionPercentage = new BigDecimal("0.25");
        BigDecimal staffMaxPayable = new BigDecimal("16.0");
        BigDecimal managementMinPayable = new BigDecimal("3.0");
        BigDecimal visitorThresholdAndDeduction = new BigDecimal("8.0");
        BigDecimal visitorReductionPercentage = new BigDecimal("0.5");


        if (this.kind == CarParkKind.STUDENT && bigDecAmount.compareTo(studentThreshold) == 1) {
            bigDecAmount = bigDecAmount.subtract(bigDecAmount.multiply(studentReductionPercentage));
            return bigDecAmount;

        } else if (this.kind == CarParkKind.STAFF && bigDecAmount.compareTo(staffMaxPayable) == 1) {
            //maximum payable is 16.00 per day
            bigDecAmount = staffMaxPayable;
            return bigDecAmount;

        } else if (this.kind == CarParkKind.MANAGEMENT && bigDecAmount.compareTo(managementMinPayable) == -1) {
            //maximum payable is 16.00 per day
            bigDecAmount = managementMinPayable;
            return bigDecAmount;

        } else if (this.kind == CarParkKind.VISITOR) {
            if (bigDecAmount.compareTo(visitorThresholdAndDeduction) == -1 || bigDecAmount.compareTo(visitorThresholdAndDeduction) == 0) {
                //first 8.00 is free for visitor
                bigDecAmount = bigDecAmount.ZERO;
            } else {
                bigDecAmount = bigDecAmount.subtract(visitorThresholdAndDeduction);
                bigDecAmount = bigDecAmount.multiply(visitorReductionPercentage);
            }
        }
        return bigDecAmount;
    }


    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal bigDecAmount = this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours)).
                add(this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));
        BigDecimal newBigDecAmount = reductions(bigDecAmount);

        return (newBigDecAmount);
    }
}
