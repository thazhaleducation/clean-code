package cqsexample;

public class CQSExample {
  private static Session session;
  private static String defaultUsername = "admin";
  private static String defaultPassword = "admin";

  public static void main(String[] args) {
    
    login("admin", "admin");
  }

  public static void login(String username, String password) {
    createSessionIfAuthenticated(username, password);
  }

  public static boolean createSessionIfAuthenticated(String username, String password){
    if (username == defaultUsername && password == defaultPassword) {
      session = new Session(username, "123123token", new java.util.Date().getTime(), new java.util.Date().getTime() + 1000);
      return true;
    } else {
      return false;
    }
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