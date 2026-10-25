package semester1.practice07;

public class UserAccount{
   private int id;private String username;private String email;
    private static int nextId = 1001;
  public   UserAccount(String username, String email){
      this.id = nextId++;
      this.username=username;
      this.email=email;

    }
    public static int getNextAvailableId(){
      return nextId;
    }
    public static void resetIdSequence(int startId){
      nextId=startId;
    }
    public int getId() {
        return id;
    }

}

