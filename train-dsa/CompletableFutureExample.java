import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> customerFuture = CompletableFuture.supplyAsync(() -> getCustomer(1));
        CompletableFuture<String> accountFuture = CompletableFuture.supplyAsync(() -> getAccount(1));
        CompletableFuture<String> transactionsFuture = CompletableFuture.supplyAsync(() -> getTransactions(1));
        CompletableFuture.allOf(customerFuture, accountFuture, transactionsFuture).join();
        CustomerResponse response = new CustomerResponse(
        customerFuture.join(),
        accountFuture.join(),
        transactionsFuture.join()
        );
        System.out.println(response.toString());
    }

    static String getCustomer(int id) {
        return "this is the customer";
    }

    static String getAccount(int id) {
        return "this is the account";
    }

    static String getTransactions(int id) {
        return "these are the transactions";
    }
}

class CustomerResponse {

    String response = "";


    CustomerResponse(Object customer, Object account, Object transactions) {
        this.response = "customers: " + customer + ", account: " + account + ", transactions: " + transactions;
    }

}
