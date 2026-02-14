import java.util.Scanner;

public class libs {
    public static void main(String[] args) {

          // Jogo de Palavas
        
       Scanner scanner = new Scanner(System.in);

      String adjetivo1;
      String substantivo1;
      String adjetivo2;
      String verbo1;
      String adjetivo3;

      System.out.println("Insira um adjetivo (descricao): ");
      adjetivo1 = scanner.nextLine();

      System.out.println("Insira um substantivo (animal ou pessoa): ");
      substantivo1 = scanner.nextLine();

      System.out.println("Insira um adjetivo (descricao): ");
      adjetivo2 = scanner.nextLine();

      System.out.println("Insira um verbo que termina com -ndo (acao): ");
      verbo1 = scanner.nextLine();

      System.out.println("Insira um adjetivo (descricao): ");
      adjetivo3 = scanner.nextLine();       


    
      System.out.println("\nHoje eu fui para um zoologico muito " + adjetivo1);
      System.out.println("Na exibicao eu vi um " + substantivo1 + ".");
      System.out.println(substantivo1 + " estava " + adjetivo2 + " e " + verbo1 + "!");
      System.out.println("Eu fiquei " + adjetivo3 + "!");


        scanner.close();
    }
} 