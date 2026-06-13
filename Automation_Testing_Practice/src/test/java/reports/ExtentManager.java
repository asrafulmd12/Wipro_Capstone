package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {

        if (extent == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            "test-output/ExtentReport.html");

            sparkReporter.config()
                    .setReportName("BlogSpot Automation Report");

            sparkReporter.config()
                    .setDocumentTitle("Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);
        }

        return extent;
    }
}
