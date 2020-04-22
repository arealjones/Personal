package DesignPatterns.Decorator.notifications;

public class Notification implements INotification  {
    protected String message;

    public Notification(String message) {
        this.message = message;
    }
    @Override
    public String sendMessage() {
        return "Sending '" + this.message + "'";
    }
}
