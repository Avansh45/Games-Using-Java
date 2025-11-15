import java.util.Scanner;
import java.util.InputMismatchException;
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
        System.out.println(" Number has been choosen(0-100). Let's begin !");
        System.out.print("Choose the number :");
        
        while(true){
           try {
                g.setGuesses(); 
                
                int userNum = sc.nextInt();
                g.userNum = userNum;
                
                if (g.isCorrectNumber()) {
                    System.out.println("\n--- CONGRATULATIONS! ---");
                    break;
                }
                else if (userNum < g.getRandom()) {
                    System.out.println("You entered a smaller number.");
                    System.out.println("Try Again! \n------------------------------");
                }
                else {
                    System.out.println("You entered a greater number.");
                    System.out.println("Try Again! \n------------------------------");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input! Please enter a whole number only.");
                System.out.println("------------------------------");
                g.num--;
                
                sc.next(); 
            }
        }
        System.out.println("No.of Gusses: "+g.getGuesses());
        
        
        System.out.println("Choosen Number Was "+g.getRandom());
        sc.close();
    }
}
