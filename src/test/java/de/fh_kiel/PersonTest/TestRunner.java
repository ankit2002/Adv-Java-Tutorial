package de.fh_kiel.PersonTest;

/**
 * Created by amit on 28.11.16.
 */

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args) {

        /*TestSuite suite = new TestSuite(filterValuesTest.class, PersonServiceTest.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());*/
        Result result = JUnitCore.runClasses(PersonServiceTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

        Result result1 = JUnitCore.runClasses(filterValuesTest.class);

        for (Failure failure : result1.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result1.wasSuccessful());
    }
}
