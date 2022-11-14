package navigationtiming;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.openqa.selenium.JavascriptExecutor;
import util.Constants;
import util.WebDriverHolder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PerfNavigationTiming {

    Map<String, Object> timings = null;
    private final String javaScriptForPerformance = "var timings = performance.timing || {};return timings;";


    InfluxDB influxDB = InfluxDBFactory.connect(Constants.DATABASE_URL);
    BatchPoints batchPoints = BatchPoints
            .database(Constants.DATABASE_NAME)
            .retentionPolicy("autogen")
            .build();

    public void writeToInflux(String pageName) {
        getAllTiming();
        influxDB.setLogLevel(InfluxDB.LogLevel.BASIC);
        Point point = Point.measurement("nc")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("projectName", Constants.PROJECT_NAME)
                .tag("scenario", Constants.SCENARIO_NAME)
                .tag("env", Constants.ENV_NAME)
                .tag("browser", Constants.BROWSER_NAME)
                .tag("page", pageName)
                .tag("periodicity", "Debug")
                .tag("periodicity_comment", "nopcommerce")
                .tag("buildID", Constants.BUILD_ID)
                .addField("latency", this.getLatency())
                .addField("backend_response", this.getBackend_response())
                .addField("tti", this.getTimeToInteract())
                .addField("ttl", this.getTimeToLoad())
                .addField("onload", this.getOnload())
                .addField("total_time", this.getTotal_time())
                .build();
        batchPoints.point(point);
        influxDB.write(batchPoints);
    }

    public Map<String, Object> getAllTiming() {
        JavascriptExecutor jsrunner = (JavascriptExecutor) WebDriverHolder.getDriver();
        timings = (Map<String, Object>) jsrunner.executeScript(javaScriptForPerformance);
        return timings;
    }

    private Long getAnTime(String name) { return (Long) timings.get(name); }

    public Long getNavigationStart() { return getAnTime("navigationStart"); }

    public Long getResponseStart() { return getAnTime("responseStart"); }

    public Long getResponseEnd() { return getAnTime("responseEnd"); }

    public Long getDomLoading() { return getAnTime("domLoading"); }

    public Long getDomInteractive() { return getAnTime("domInteractive"); }

    public Long getDomComplete() { return getAnTime("domComplete"); }

    public Long getLoadEventStart() { return getAnTime("loadEventStart"); }

    public Long getLoadEventEnd() { return getAnTime("loadEventEnd"); }



    public long getLatency() { return getResponseStart() - getNavigationStart(); }

    public long getBackend_response() { return getResponseEnd() - getResponseStart(); }

    public long getTimeToInteract() { return getDomInteractive() - getDomLoading(); }

    public long getTimeToLoad() { return getDomComplete() - getDomInteractive(); }

    public long getOnload() { return getLoadEventEnd() - getLoadEventStart(); }

    public long getTotal_time() { return getLoadEventEnd() - getNavigationStart(); }

}
