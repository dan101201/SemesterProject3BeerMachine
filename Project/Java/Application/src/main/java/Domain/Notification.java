package Domain;

import Data.Machine;

public class Notification {
    private NotificationType notificationType;
    private String description;
    private Machine machineAddress;

public Notification evalSubscriptionInt(int integer){
    switch (integer) {
    case 0:
        Notification notificationInstans = new Notification(NotificationType.WARNING, "Low ")   ;
        break;
    case 1:
        //Notification notificationInstans = new Notification(NotificationType.ERROR, "Machine broke..");
        break;
    }
      return null;
}

    public Notification(NotificationType notificationType, String description) {
        this.notificationType = notificationType;
        this.description = description;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
