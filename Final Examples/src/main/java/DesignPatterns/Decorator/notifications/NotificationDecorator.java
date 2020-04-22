package DesignPatterns.Decorator.notifications;

public abstract class NotificationDecorator implements INotification  {
    private INotification notification;

    public NotificationDecorator(INotification notification) {
        this.notification = notification;
    }

    @Override
    public String sendMessage() {
        return this.notification.sendMessage();
    }
}
