package semester1.practice10;

public class Task34 {
    public static void run() {
        AbstractSecurityProtocol[] protocols = {
                new JwtSecurityProtocol(),
                new ApiKeySecurityProtocol()
        };
        String[] tokens = {
                "jwt-123",
                "api-456",
                "wrong-token",
                null
        };
        for (AbstractSecurityProtocol protocol : protocols) {
            System.out.println("\n=== "
                    + protocol.getClass().getSimpleName() + " ===");
            for (String token : tokens) {
                String result = protocol.runSecureCommand(token, "GET_DATA");
                System.out.println(result);
            }
        }
    }
}

abstract class AbstractSecurityProtocol {
    protected abstract boolean authenticateUser(String token);
    protected abstract String executePayload(String command);
    public final String runSecureCommand(String token, String command) {
        if (token == null || !authenticateUser(token)) {
            return "403 FORBIDDEN";
        }
        return "[AUDITED] " + executePayload(command);
    }
}
class JwtSecurityProtocol extends AbstractSecurityProtocol {
    @Override
    protected boolean authenticateUser(String token) {
        return token.equals("jwt-123");
    }
    @Override
    protected String executePayload(String command) {
        return "JWT: Виконано команду " + command;
    }
}
class ApiKeySecurityProtocol extends AbstractSecurityProtocol {
    @Override
    protected boolean authenticateUser(String token) {
        return token.equals("api-456");
    }
    @Override
    protected String executePayload(String command) {
        return "API KEY: Виконано команду " + command;
    }
}
