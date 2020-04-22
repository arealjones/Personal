package DesignPatterns.Decorator.notifications;

public class NotificationSettings {
    private boolean emailEnabled;
    private boolean facebookEnabled;
    private boolean slackEnabled;

    private NotificationSettings(Builder builder) {
        this.emailEnabled = builder.emailEnabled;
        this.facebookEnabled = builder.facebookEnabled;
        this.slackEnabled = builder.slackEnabled;
    }

    public boolean isEmailEnabled() {
        return this.emailEnabled;
    }

    public boolean isFacebookEnabled() {
        return this.facebookEnabled;
    }

    public boolean isSlackEnabled() {
        return this.slackEnabled;
    }

    public INotification buildNotifier(String message) {
        INotification notification = new Notification(message);
        if (this.isEmailEnabled())
            notification = new EmailDecorator(notification);
        if (this.isFacebookEnabled())
            notification = new FacebookDecorator(notification);
        if (this.isSlackEnabled())
            notification = new SlackDecorator(notification);
        return notification;
    }

    public static class Builder {
        private boolean emailEnabled;
        private boolean facebookEnabled;
        private boolean slackEnabled;

        public Builder() {
            this.emailEnabled = false;
            this.facebookEnabled = false;
            this.slackEnabled = false;
        }

        public Builder enableEmail() {
            this.emailEnabled = true;
            return this;
        }

        public Builder enableFacebook() {
            this.facebookEnabled = true;
            return this;
        }

        public Builder enableSlack() {
            this.slackEnabled = true;
            return this;
        }

        private boolean validateChoices() {
            return this.emailEnabled || this.slackEnabled || this.facebookEnabled;
        }

        public NotificationSettings build() throws PlatformRequiredException {
            if (!this.validateChoices())
                throw new PlatformRequiredException("At least one platform must be enabled!");
            return new NotificationSettings(this);
        }
    }
}
