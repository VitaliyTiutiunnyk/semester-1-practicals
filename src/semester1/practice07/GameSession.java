package semester1.practice07;

import java.util.UUID;

public class GameSession {
    String sessionToken;
    String hostPlayer;
    boolean isActive;
    private static int activeSessionsCount = 0;
    public static final int MAX_SESSIONS = 3;

    private GameSession(String host) {
        this.hostPlayer = host;
        this.sessionToken = UUID.randomUUID().toString();
        this.isActive = true;

    }

    public static GameSession createSession(String host) {
        if (activeSessionsCount >= MAX_SESSIONS) {
            System.out.println("Помилка: усі сервера перевантажені!");
            return null;
        }
        activeSessionsCount++;
        return new GameSession(host);
    }
    public void terminate() {
        if (isActive) {
            isActive = false;
            activeSessionsCount--;
            System.out.println("Сесію гравця " + hostPlayer + " завершено.");
        }
    }
}