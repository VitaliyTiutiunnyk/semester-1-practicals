package semester1.practice10;

public class Task04 {
    public static void broadcastAlert(NotificationSender[] senders, String alertText) {
        for (NotificationSender sender : senders) {
            System.out.println(sender.send(alertText));
        }
    }
    public static void run(){
        NotificationSender[] senders = {
                new EmailSender("user@gmail.com"),
                new SmsSender("+380000000000"),
                new TelegramBotSender("@user")
        };
        broadcastAlert(senders, "Увага! Отримано термінове повідомлення.");
    }
}
class NotificationSender{
    private final String recipient;
    NotificationSender(String recipient){
        this.recipient=recipient;
    }
    public String send(String message) {
        return "Повідомлення для " + recipient + ": " + message;
    }
}
class EmailSender extends NotificationSender{
    EmailSender(String recipient) {
        super(recipient);
    }
    @Override
    public String send(String message) {
        return super.send("Тема: Термінове сповіщення\n" + message);
    }
}
class SmsSender extends NotificationSender {

    SmsSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        if (message.length() > 70) {
            message = message.substring(0, 70);
        }

        return super.send(message);
    }
}
class TelegramBotSender extends NotificationSender {

    TelegramBotSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        return super.send("🚨 *ТРИВОГА!*\n**" + message + "**");
    }
}

