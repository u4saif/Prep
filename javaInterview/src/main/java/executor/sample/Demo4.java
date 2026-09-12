package executor.sample;

import java.util.Map;

/**
 * Demo4
 */
public class Demo4 {

    public static void main(String[] args) {
        System.out.println("question 1");
        String ss ="$123,840/y";
        int resultss = Integer.parseInt(ss.replaceAll("[^0-9]", ""));
        System.out.println(resultss);

        System.out.println("question 5");
        Scheduler scheduler = new Scheduler();
        scheduler.run("US");
        scheduler.run("EU");
        scheduler.run("APAC");
        scheduler.run("UNKNOWN");
    }

    // Strategy per region, keyed by region code - no if/else or switch needed.
    interface RegionJob {
        void run();
    }

    static class Scheduler {
        private final Map<String, RegionJob> jobsByRegion = Map.of(
                "US", () -> System.out.println("Running US logic: midnight-open batch"),
                "EU", () -> System.out.println("Running EU logic: GDPR-safe batch"),
                "APAC", () -> System.out.println("Running APAC logic: multi-timezone batch")
        );

        private final RegionJob defaultJob = () -> System.out.println("No job registered for region");

        void run(String region) {
            jobsByRegion.getOrDefault(region, defaultJob).run();
        }
    }
}