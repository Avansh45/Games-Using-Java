import java.util.Scanner;
import java.util.Random;

class Game{
    int userNum;
    int r;
    int num;
    Game(){
        Random random = new Random();
        r =random.nextInt(0,101);
    }
    int getRandom(){
        return r;
    }

    int takeUserInput(){
        return userNum;
    }
    boolean isCorrectNumber(){
        if(userNum==r){
            return true;
        }
        else{
            return false;
        }
    }
    void setGuesses(){
        num++;
    }
    int getGuesses(){
        return num;
    }
}
public class GuessNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        int userNum;
        while((g.isCorrectNumber())==false){
            g.setGuesses();
            userNum = sc.nextInt();
            g.userNum=userNum;
            if(g.getRandom()>userNum){
                System.out.println("you have entered smaller number");
            }
            else if(g.getRandom()<userNum){
                System.out.println("you have entered greater number");
            }
            else{
                break;
            }
        }
        System.out.println("No.of Gusses: "+g.getGuesses());
        
        
        System.out.println("Random Number Was "+g.getRandom());
        sc.close();
    }
}
