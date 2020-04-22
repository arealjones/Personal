package DesignPatterns.Decorator.notifications;

public class FacebookDecorator extends NotificationDecorator {
    public FacebookDecorator(INotification notification) {
        super(notification);
    }


    @Override
    public String sendMessage() {
        return super.sendMessage() + " to Facebook";
    }
}
