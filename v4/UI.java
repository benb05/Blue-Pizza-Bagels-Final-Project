import java.util.*;

public class UI {
    
    private static void cardReader(){
        System.out.println("Please play a card ");
        Scanner sc=new Scanner(System.in);
        String str= sc.nextLine();
        String target = "king";
        if(str.equals(target)){
            System.out.println("Placing " + str);
        }
        else{
            System.out.println("ERROR: INVALID CARD");
        }

       }
    

       private static void numberReader(){
           System.out.println("Choose a number");
           Scanner sc=new Scanner(System.in);
            int a = sc.nextInt();
            if(a < 5){
                System.out.println("Nice Number");
            }

                else{
                    System.out.println("tuff");
                }

            }

       



    public static void main(String[] args) {
    
        cardReader();

    

    }
}
