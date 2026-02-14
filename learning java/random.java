import java.util.Random;

public class random {
    public static void main(String[] args) {
        
        Random random = new Random();

        //int number;
        //double number;
       
        //number = random.nextInt();
        //number = random.nextDouble();
         

         boolean isHeads;

         isHeads = random.nextBoolean();
    
         if(isHeads){
            System.out.println("DOUBLE HEADS");
         }
         else{
            System.out.println("hords of chaos");
         }
    
    }
}