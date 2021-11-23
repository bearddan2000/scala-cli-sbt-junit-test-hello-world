package example;

import org.junit._;
import java.io._;
import org.junit.runner._;
import org.junit.runner.notification._;

class JUnitListener extends RunListener {
    var pw: PrintWriter = new PrintWriter(new FileWriter("/tmp/target/test-reports/junit.html"));
    var testFailed: Boolean = false;
    val outputFile = "/tmp/target/test-reports/junit.html";

    @throws(classOf[Exception])
    override def testRunStarted(description: Description): Unit = {
        pw = new PrintWriter(new FileWriter(outputFile));
        pw.println("<html><head><title>JUnit report</title></head><body>");
    }

    @throws(classOf[Exception])
    override def testRunFinished(result: Result): Unit = {
        pw.println("</body></html>");
        pw.close();
    }

    @throws(classOf[Exception])
    override def testStarted(description: Description): Unit = {
        pw.print("<p> Test " + description.getDisplayName() + " ");
        testFailed = false;

    }

    @throws(classOf[Exception])
    override def testFinished(description: Description): Unit = {
        if (!testFailed) {
            pw.print("OK");
        }
        pw.println("</p>");
    }

    @throws(classOf[Exception])
    override def testFailure(failure: Failure): Unit = {
        testFailed = true;
        pw.print("FAILED!");
    }

    override def testAssumptionFailure(failure: Failure): Unit = {
        pw.print("ASSUMPTION FAILURE");
    }

    @throws(classOf[Exception])
    override def testIgnored(description: Description): Unit = {
        pw.print("IGNORED");
    }
}
