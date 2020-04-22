package DesignPatterns.Decorator.notifications;

public class SocialApp {
    private NotificationSettings settings;

    public SocialApp(NotificationSettings settings) {
        this.settings = settings;
    }

    private void notify(String message) {
        INotification notifier = this.settings.buildNotifier(message);
        System.out.println(notifier.sendMessage());
    }

    public void addFriend(String name) {
        this.notify("Added " + name + " to your friends list!");
    }

    public void removeFriend(String name) {
        this.notify("Removed " + name + " from your friends list!");
    }
}
