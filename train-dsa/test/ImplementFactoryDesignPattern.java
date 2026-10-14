
interface Notification {
    void send();

}

class EmailNotification implements Notification {
    @Override 
    public void send() {
        System.out.println("send email notification");
    }
} 

class SMSNotification implements Notification {
    @Override 
    public void send() {
        System.out.println("send SMS notification");
    }
} 

class NotificationFactory {
    public static Notification createNotification(String type) {
        if(type.equals("email")) {
            return new EmailNotification();
        } else if(type.equals("sms")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Invalid Notification Type");
    }
}

public class ImplementFactoryDesignPattern {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("email");
        Notification notification1 = NotificationFactory.createNotification("sms");
        notification.send();
        notification1.send();
    }
    
}