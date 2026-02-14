import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
       Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite a sua idade: ");
        int idade = scanner.nextInt();
        
        System.out.println("Qual o seu gpa: ");
        double gpa = scanner.nextDouble();

        System.out.println("Voce e um estudante ? (true/false): ");
        boolean eumEstudante = scanner.nextBoolean();

        

        System.out.println("Ola " + nome);
        System.out.println("Voce tem " + idade + " anos de idade."); 
        System.out.println("Seu gpa e " + gpa);
        
        if(eumEstudante){
            System.out.println("Voce e um estudante");
        }
        else { 
            System.out.println("Voce NAO e um estudante");
        }

        scanner.close();
    }
} 