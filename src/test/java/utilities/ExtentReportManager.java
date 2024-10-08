package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extent-report.html");
            
           
            sparkReporter.config(
                ExtentSparkReporterConfig.builder()
                    .theme(Theme.DARK) // Set theme to dark
                    .documentTitle("Automation Test Report")
                    .reportName("Test Report")
                    .timeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'")
                    .build()
            );
            
            // Add custom CSS and JS if needed
            sparkReporter.config().setCss(".badge-success { background-color: #28a745; }");
            sparkReporter.config().setJs("document.addEventListener('DOMContentLoaded', function() { " +
                "document.querySelector('.brand-logo').style.color = '#fff'; });");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void attachScreenshot(byte[] screenshotBytes, String description) {
        String base64Image = "data:image/png;base64," + java.util.Base64.getEncoder().encodeToString(screenshotBytes);
        test.get().addScreenCaptureFromBase64String(base64Image, description);
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}