import java.util.Scanner;

public class erros {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter your favorite color: ");
        String color = scanner.nextLine();


        System.out.println("You are " + age + " years old");
        System.out.println("You like the color: " + color);

        scanner.close();
    }
} 