package de.fh_kiel.PersonTest;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/*
 * Created by amit on 28.11.16.
 */


public class TestRunner {
    public static void main(String[] args) {

TestSuite suite = new TestSuite(filterValuesTest.class, PersonControllerTest.class,
        CompanyGetAllTest.class, CompanyGetByIdTest.class, PersonGetAllTest.class, PersonGetByIdTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());

        Result result2 = JUnitCore.runClasses(PersonControllerTest.class);

        for (Failure failure : result2.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result2.wasSuccessful());

        Result result1 = JUnitCore.runClasses(filterValuesTest.class);

        for (Failure failure : result1.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result1.wasSuccessful());

        Result result3 = JUnitCore.runClasses(CompanyGetAllTest.class);

        for (Failure failure : result3.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result3.wasSuccessful());

        Result result4 = JUnitCore.runClasses(CompanyGetAllTest.class);

        for (Failure failure : result4.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result4.wasSuccessful());

        Result result5 = JUnitCore.runClasses(PersonGetAllTest.class);

        for (Failure failure : result5.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result5.wasSuccessful());

        Result result6 = JUnitCore.runClasses(PersonGetByIdTest.class);

        for (Failure failure : result6.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result6.wasSuccessful());
    }
}
