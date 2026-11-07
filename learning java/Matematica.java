import java.util.Scanner;

public  class  Matematica {
    public static void main(String[] args) {

        // HIPOTENUSA c = Math.sqrt(a² + b²)
        
        Scanner scanner = new Scanner(System.in);

        double a;
        double b;
        double c;

            System.out.println("Insira o tamanho do comprimento do lado A: ");
            a = scanner.nextDouble();

            System.out.println("Insira o tamanho do comprimento do lado B: ");
            b = scanner.nextDouble();

            c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            System.out.println("A hipotenusa do (lado c)e: " + c + "cm");
 
        scanner.close();
    }
}



      // Syste.out.print(Math.PI);
        // Syste.out.print(Math.E);

       // double result;

       // result = Math.pow(2, 5);
       // result = Math.abs(-5);
       // result = Math.sqrt(4);
      //  result = Math.round(3.14);
       // result = Math.ceil(3.14);
       // result = Math.floor(3.99);
      //  result = Math.max(10, 20);
      //  result = Math.min(6, 7);
        
       // System.err.println(result);
   