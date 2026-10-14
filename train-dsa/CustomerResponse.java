/**
 * CustomerResponse
 */
public class CustomerResponse {

    String response = "";


    CustomerResponse(Object customer, Object account, Object transactions) {
        this.response = "customers: " + customer + ", account: " + account + ", transactions: " + transactions;
    }

}
