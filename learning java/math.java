import java.util.Scanner;

public class math{
    public static void main(String[] args) {
        
         // circumference = 2 * Math.PI * radius;
         // area = Math.PI * Math.pow(radius, 2);
         // volume = (4.0 / 3.0) *Math.PI * Math.pow(radius, 3);

        Scanner scanner = new Scanner(System.in);

        double radius;
        double circumference;
        double area;
        double volume;

        System.out.println("Enter the radius: ");
        radius = scanner.nextDouble();

        circumference = 2 * Math.PI * radius;
        area =  Math.PI * Math.pow(radius, 2);
        volume = (4.0 / 3.0) *Math.PI * Math.pow(radius, 3);


        System.out.printf("The circumference is: %.1fcm\n", circumference);
        System.out.printf("The area is: %.1fcm2\n", area);
        System.out.printf("The volume is: %.1fcm3\n", volume);
        
        scanner.close();
    }
}