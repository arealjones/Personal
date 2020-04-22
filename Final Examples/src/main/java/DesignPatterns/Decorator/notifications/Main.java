package DesignPatterns.Decorator.notifications;

public class Main {
    public static void main(String[] args) throws PlatformRequiredException {
        NotificationSettings allPlatforms = new NotificationSettings.Builder()
                                                .enableEmail().enableFacebook().enableSlack()
                                                .build();
        NotificationSettings emailOnly = new NotificationSettings.Builder().enableEmail().build();

        SocialApp app1 = new SocialApp(allPlatforms);
        app1.addFriend("Katie");
        app1.addFriend("Dan");

        SocialApp app2 = new SocialApp(emailOnly);
        app2.removeFriend("Wayne");
    }
}
