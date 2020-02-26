package cm;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WalshMartinTestTask2 {

    //    NR >= 0
    @Test
    public void TestOneSuccessful() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    NR < RR
    @Test(expected = IllegalArgumentException.class)
    public void TestTwoLowerNr() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STAFF;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    RR > NR
    @Test(expected = IllegalArgumentException.class)
    public void TestThreeGreaterRr() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(11);
        CarParkKind kind = CarParkKind.MANAGEMENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    NP > 24
    @Test(expected = IllegalArgumentException.class)
    public void TestFourNpGreaterThanLimit() {
        Period slot1 = new Period(22, 25);
        Period slot2 = new Period(4,20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    RP > 24
    @Test(expected = IllegalArgumentException.class)
    public void TestFiveRpGreaterThanLimit() {
        Period slot1 = new Period(10, 4);
        Period slot2 = new Period(5, 25);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    NP < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestSixNpLessThanZero() {
        Period slot1 = new Period(-10, 4);
        Period slot2 = new Period(5, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    RP < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestSevenRpLessThanZero() {
        Period slot1 = new Period(10, 4);
        Period slot2 = new Period(-5, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    NR == Null
    @Test(expected = IllegalArgumentException.class)
    public void TestEightNullNr() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STAFF;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);

    }

    //    RR == Null
    @Test(expected = IllegalArgumentException.class)
    public void TestNineNullRr() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = null;
        CarParkKind kind = CarParkKind.VISITOR;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);

    }

    //    NP == Null
    @Test(expected = NullPointerException.class)
    public void TestTenNullNp() {
        Period slot1 = null;
        Period slot2 = new Period(5, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);

    }

    //    RP == Null
    @Test(expected = NullPointerException.class)
    public void TestElevenNullRp() {
        Period slot1 = new Period(10, 16);
        Period slot2 = null;
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);

    }

    //    Periods overlapping
    @Test(expected = IllegalArgumentException.class)
    public void TestTwelveOverlapping() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(6, 12);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);

    }

    //    NR < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestThirteenNrLessThanZero() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(-10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    RR < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestFourteenRrLessThanZero() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(-5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    NP < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestFifteenNpEndLessThanZero() {
        Period slot1 = new Period(10, -4);
        Period slot2 = new Period(5, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //    RP < 0
    @Test(expected = IllegalArgumentException.class)
    public void TestSixteenRpEndLessThanZero() {
        Period slot1 = new Period(10, 4);
        Period slot2 = new Period(5, -20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //Calculate test - SP * NR
    @Test
    public void TestSeventeenCalculate() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 16);


        assertEquals(new BigDecimal(60), test.calculate(stayPeriod));
    }

    //Calculate test - SP * RR
    @Test
    public void TestEighteenCalculate() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STAFF;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 16);

        assertEquals(new BigDecimal(60), test.calculate(stayPeriod));
    }

    //Test if reduce period is null
    @Test(expected = IllegalArgumentException.class)
    public void TestNineteenNullReducedPeriod() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, null, normalRatePeriod);
    }

    //Test if normal period is null
    @Test(expected = IllegalArgumentException.class)
    public void TestTwentyNullNormalPeriod() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, null);
    }

    //Test if multiple list overlapping
    @Test(expected = IllegalArgumentException.class)
    public void TestTwentyOneListsOverlapping() {
        Period slot1 = new Period(10, 12);
        Period slot2 = new Period(11, 13);
        Period slot3 = new Period(14, 16);
        Period slot4 = new Period(17, 20);
        Period slot5 = new Period(19, 22);
        Period slot6 = new Period(22, 23);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        normalRatePeriod.add(slot2);
        normalRatePeriod.add(slot3);
        reducedRatePeriod.add(slot4);
        reducedRatePeriod.add(slot5);
        reducedRatePeriod.add(slot6);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //To check if period lists are valid individually
    @Test(expected = IllegalArgumentException.class)
    public void TestTwentyTwoValidIndividually() {
        Period slot1 = new Period(10, 12);
        Period slot2 = new Period(11, 13);
        Period slot3 = new Period(14, 16);
        Period slot4 = new Period(17, 20);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        normalRatePeriod.add(slot2);
        normalRatePeriod.add(slot3);
        reducedRatePeriod.add(slot4);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }

    //Test 2 collections of periods where one list overlaps the other
    @Test (expected = IllegalArgumentException.class)
    public void TestTwentyThreeOneListOverlap() {
        Period slot1 = new Period(10, 12);
        Period slot2 = new Period(12, 13);
        Period slot3 = new Period(14, 16);
        Period slot4 = new Period(9, 13);
        Period slot5 = new Period(20, 21);
        Period slot6 = new Period(22, 23);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        normalRatePeriod.add(slot2);
        normalRatePeriod.add(slot3);
        reducedRatePeriod.add(slot4);
        reducedRatePeriod.add(slot5);
        reducedRatePeriod.add(slot6);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.STUDENT;

        new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
    }


}
