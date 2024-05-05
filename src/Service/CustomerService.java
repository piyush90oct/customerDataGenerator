package Service;

import Model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> customerDataParser(String input);

    void generateReportByContractId(List<Customer> customers);
    void generateReportByGeoCode(List<Customer> customers);
    void generateBuildDurationDataByGeoCode(List<Customer> customers);

}
