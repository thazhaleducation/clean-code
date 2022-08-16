package cqsexample;

public class CQSExampleRefactored {
  private static Session session;
  private static String defaultUsername = "admin";
  private static String defaultPassword = "admin";

  public static void main(String[] args) {
    login("admin", "admin");
  }

  public static void login(String username, String password) {
    if(isAuthenticated(username, password)) {
      createSession(username, password);
    }
  }

  public static boolean isAuthenticated(String username, String password) {
    return username == defaultUsername && password == defaultPassword;
  }

  public static void createSession(String username, String password) {
    session = new Session(username, "123123token", new java.util.Date().getTime(),
        new java.util.Date().getTime() + 1000);
  }
}

class Session {
  private String username;
  private String sessionToken;
  private long createdAt;
  private long expiresAt;

  public Session(String username, String sessionToken, long createdAt, long expiresAt) {
    this.username = username;
    this.sessionToken = sessionToken;
    this.createdAt = createdAt;
    this.expiresAt = expiresAt;
  }
}