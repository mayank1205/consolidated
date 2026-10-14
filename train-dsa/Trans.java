import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trans {
    String transId;
    String CoustomerID;
    String AccountID;
    String TransType;
    BigDecimal amount;
    LocalDateTime timestamp;
    String Status;

    public Trans(String transId, String coustomerID, String accountID, String transType, BigDecimal amount,
            LocalDateTime timestamp, String status) {
        this.transId = transId;
        CoustomerID = coustomerID;
        AccountID = accountID;
        TransType = transType;
        this.amount = amount;
        this.timestamp = timestamp;
        Status = status;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public String getCoustomerID() {
        return CoustomerID;
    }

    public void setCoustomerID(String coustomerID) {
        CoustomerID = coustomerID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getTransType() {
        return TransType;
    }

    public void setTransType(String transType) {
        TransType = transType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public static void main(String[] args) {
        List<Trans> transactions = List.of(
                new Trans("t01", "c01", "A101", "debit", new BigDecimal("20000"),
                        LocalDateTime.parse("2026-08-20T05:24:00"), "success"),

                new Trans("t02", "c01", "A102", "debit", new BigDecimal("40000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "success"),

                new Trans("t03", "c02", "A103", "debit", new BigDecimal("40000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "success"),

                new Trans("t04", "c03", "A104", "debit", new BigDecimal("60000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "success"),

                new Trans("t05", "c01", "A105", "debit", new BigDecimal("50000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "success"),
                new Trans("t06", "c04", "A106", "debit", new BigDecimal("50000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "failed"),
                new Trans("t07", "c01", "A107", "debit", new BigDecimal("50000"),
                        LocalDateTime.parse("2026-08-20T06:24:00"), "failed"));
        transactions = transactions.stream().filter((t) -> "SUCCESS".equalsIgnoreCase(t.getStatus())).toList();
        // transactions = transactions.stream().filter((t) -> "c01".equalsIgnoreCase(t.getCoustomerID())).toList();
        Map<String, BigDecimal> customerTransactions = transactions.stream().collect(Collectors.groupingBy(Trans::getCoustomerID, Collectors.reducing(BigDecimal.ZERO, Trans::getAmount, BigDecimal::add))).entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, BigDecimal>::getValue).reversed().thenComparing(Map.Entry::getKey)).limit(3).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        
        customerTransactions.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

}