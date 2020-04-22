package DesignPatterns.Decorator.notifications;

public class SlackDecorator extends NotificationDecorator {
    public SlackDecorator(INotification notification) {
        super(notification);
    }

    @Override
    public String sendMessage() {
        return super.sendMessage() + " to Slack";
    }
}
