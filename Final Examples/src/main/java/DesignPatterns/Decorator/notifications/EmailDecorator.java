package DesignPatterns.Decorator.notifications;

public class EmailDecorator extends NotificationDecorator {
    public EmailDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String sendMessage() {
        return super.sendMessage() + " to Email";
    }
}
