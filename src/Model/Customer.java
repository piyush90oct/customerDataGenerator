package Model;

public class Customer {

    private String customerId;
    private String contractId;
    private String geozone;
    private String teamcode;
    private String projectcode;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", contractId=" + contractId +
                ", geozone='" + geozone + '\'' +
                ", teamcode='" + teamcode + '\'' +
                ", projectcode='" + projectcode + '\'' +
                ", buildduration='" + buildduration + '\'' +
                '}';
    }

    public Customer(String customerId, String contractId, String geozone, String teamcode, String projectcode, String buildduration) {
        this.customerId = customerId;
        this.contractId = contractId;
        this.geozone = geozone;
        this.teamcode = teamcode;
        this.projectcode = projectcode;
        this.buildduration = buildduration;
    }

    private String buildduration;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public void setGeozone(String geozone) {
        this.geozone = geozone;
    }

    public String getTeamcode() {
        return teamcode;
    }

    public void setTeamcode(String teamcode) {
        this.teamcode = teamcode;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getBuildduration() {
        return buildduration;
    }

    public void setBuildduration(String buildduration) {
        this.buildduration = buildduration;
    }
}
