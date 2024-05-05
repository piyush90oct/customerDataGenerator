package ServiceImpl;

import Model.Customer;
import Service.CustomerService;

import java.util.*;

public class CustomerServiceImpl implements CustomerService {


    List<Customer> customerList = new ArrayList<>();


    @Override
    public List<Customer> customerDataParser(String input) {

        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            Customer customer = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public void generateReportByContractId(List<Customer> customers) {

        Map<String, Set<String>> contractIdDataMap = new HashMap<>();

        for (Customer customer : customers) {
            String contract_Id = customer.getContractId();
            String customer_Id = customer.getCustomerId();
            Set<String> customerIds = contractIdDataMap.computeIfAbsent(contract_Id, k -> new HashSet<>());
            customerIds.add(customer_Id);
        }

        for (Map.Entry<String, Set<String>> entry : contractIdDataMap.entrySet()) {
            String contractID = entry.getKey();
            Set<String> customerID = entry.getValue();
            System.out.println("For Contract Id " + contractID + "  Customer Id's are :" + customerID);
        }
    }

    public void generateReportByGeoCode(List<Customer> customers) {
        Map<String, Set<String>> geoCodeDataMap = new HashMap<>();

        for (Customer customer : customers) {
            String geoZone = customer.getGeozone();
            String customer_Id = customer.getCustomerId();
            Set<String> customerIds = geoCodeDataMap.computeIfAbsent(geoZone, k -> new HashSet<>());
            customerIds.add(customer_Id);
        }

        for (Map.Entry<String, Set<String>> entry : geoCodeDataMap.entrySet()) {
            String geoZone = entry.getKey();
            Set<String> customerID = entry.getValue();
            System.out.println("For Geo Zone" + geoZone + "  Customer Id's are :" + customerID);
        }
    }


    public void generateBuildDurationDataByGeoCode(List<Customer> customers) {
        Map<String, Long> geoZoneDataMap = new HashMap<>();
        Map<String, Long> geoZoneCountMap = new HashMap<>();

        for (Customer customer : customers) {
            String geoZone = customer.getGeozone();
            long buildDuration = parseBuildDuration(customer.getBuildduration());
            geoZoneDataMap.put(geoZone, geoZoneDataMap.getOrDefault(geoZone, 0L) + buildDuration);
            geoZoneCountMap.put(geoZone, geoZoneCountMap.getOrDefault(geoZone, 0L) + 1);
        }
        for (Map.Entry<String, Long> entry : geoZoneDataMap.entrySet()) {
            String geoZone = entry.getKey();
            Long totalBuildTime = entry.getValue();
            if (geoZoneCountMap.containsKey(geoZone)) {
                Long geoZoneCount = geoZoneCountMap.get(geoZone);
                double avgBuildDuration = totalBuildTime / geoZoneCount;
                System.out.println("For Geo Zone Code " + geoZone + "  average build duration  " + avgBuildDuration);
            }
        }
    }

    private static long parseBuildDuration(String buildDuration) {
        return Long.parseLong(buildDuration.replaceAll("[^0-9]", ""));
    }
}
