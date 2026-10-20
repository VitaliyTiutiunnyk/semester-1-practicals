package semester1.practice06;

public class Player {
    String nickname;
    int health=100;
    public void takeDamage(int damage){
        health-=damage;
        if (health<0){
            health=0;
            System.out.println(nickname+" Загинув");

        }


        }
        public void heal(int amount){
        if (health>100){
            health=100;
        }
        }


}
