package cm;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RateTests {
    //NR: Normal Rate, RR: Reduced Rate, NP: Normal Period, RP: Reduced Period, SP: Stay Period
    //    NR < RR
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_NrLessThanRr() {
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

    //    NP > 24
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_NpGreaterThan24() {
        Period slot1 = new Period(22, 25);
        Period slot2 = new Period(4, 20);
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
    public void Should_ThrowException_RpGreaterThan24() {
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

    //    NR == Null
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_NrEquals0() {
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
    public void Should_ThrowException_RrEquals0() {
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
    public void Should_ThrowException_NpEquals0() {
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
    public void Should_ThrowException_RpEquals0() {
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
    public void Should_ThrowException_PeriodsOverlap() {
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
    public void Should_ThrowException_NrLessThan0() {
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
    public void Should_ThrowException_RrLessThan0() {
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
    public void Should_ThrowException_NpLessThan0() {
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
    public void Should_ThrowException_RpLessThan0() {
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
    public void Should_AssertEquals_SpMultipliedByNr() {
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


        assertEquals(new BigDecimal("45.00"), test.calculate(stayPeriod));
    }

    //Calculate test - SP * RR
    @Test
    public void Should_AssertEquals_SpMultipliedByRr() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.MANAGEMENT;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 16);

        assertEquals(new BigDecimal(60), test.calculate(stayPeriod));
    }

    //Test if reduce period is null
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_RpParamEqualsNull() {
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
    public void Should_ThrowException_NpParamEqualsNull() {
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
    public void Should_ThrowException_MultiplePeriodsOverlappingIndividually() {
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

    //To check if period lists are invalid individually
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_PeriodListsInvalidIndividually() {
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
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_MultiplePeriodsOverlapping() {
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

    //Test if visitor kind and total less than 8
    @Test
    public void Should_GiveReduction_IsVisitorAndTotalLessThan8() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        CarParkKind kind = CarParkKind.VISITOR;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("0"), test.calculate(stayPeriod));
    }

    //Test if visitor and total greater than 8 reduction is applied
    @Test
    public void Should_GiveReduction_IsVisitorAndTotalGreaterThan8() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 17);

        assertEquals(new BigDecimal("26.00"), test.calculate(stayPeriod));
    }

    //Test if visitor total is equal to eight
    @Test
    public void Should_GiveReduction_IsVisitorAndTotalEqualTo8() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);
        CarParkKind kind = CarParkKind.VISITOR;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("0"), test.calculate(stayPeriod));
    }

    //Test if student discount is applied
    @Test
    public void Should_GiveReduction_IsStudent() {
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
        Period stayPeriod = new Period(10, 12);

        assertEquals(new BigDecimal("15.00"), test.calculate(stayPeriod));
    }

    //Test if staff max amount of 16 is applied
    @Test
    public void Should_GiveReduction_IsStaffMaxTotalSixteen() {
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
        Period stayPeriod = new Period(10, 14);

        assertEquals(new BigDecimal("16.0"), test.calculate(stayPeriod));
    }

    //Test if management minimum amount of 3 is applied
    @Test
    public void Should_GiveReduction_IsManagementMinimumTotal3() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        CarParkKind kind = CarParkKind.MANAGEMENT;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("3.0"), test.calculate(stayPeriod));
    }

    //Test student when under discount value
    @Test
    public void Should_NoReduction_IsStudent() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(4);
        CarParkKind kind = CarParkKind.STUDENT;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("5"), test.calculate(stayPeriod));
    }

    //Test staff when max not reached
    @Test
    public void Should_NoReduction_IsStaff() {
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
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("10"), test.calculate(stayPeriod));
    }

    //Test if stay period is equal to null
    @Test(expected = IllegalArgumentException.class)
    public void Should_ThrowException_IfStayPeriodEqualsNull() {
        Period slot1 = new Period(10, 16);
        Period slot2 = new Period(17, 22);
        ArrayList<Period> normalRatePeriod = new ArrayList<Period>();
        ArrayList<Period> reducedRatePeriod = new ArrayList<Period>();
        normalRatePeriod.add(slot1);
        reducedRatePeriod.add(slot2);
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(1);
        CarParkKind kind = CarParkKind.MANAGEMENT;

        Rate test = new Rate(kind, normalRate, reducedRate, reducedRatePeriod, normalRatePeriod);
        Period stayPeriod = new Period(10, 11);

        assertEquals(new BigDecimal("3.0"), test.calculate(null));
    }


}
