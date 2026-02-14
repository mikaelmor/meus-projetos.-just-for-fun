import java.util.Scanner;

public class Statements {
    public static void main(String[] args) {
        
        //if statement = PERFORMS A BLOCK  OF CODE if its condition is TRUE

        Scanner scanner = new Scanner (System.in);
        
        String nome;
        int idade;
        boolean Estudante;

        System.out.println("Insira o seu nome: ");
        nome = scanner.nextLine();

        System.out.println("Insira a sua idade: ");
        idade = scanner.nextInt();

        System.out.println("Voce e um estudante ? (true/false): ");
        Estudante = scanner.nextBoolean();
        
        //  Grupo 1  PARA O NOME 

        if(nome.isEmpty()){
            System.out.println("Voce nao inseriu o seu nome");
        }
        else {
            System.out.println("Ola " + nome +"!");
        }


        // Grupo 2 PARA AS IDADES 

        if (idade >= 65) {
            System.out.println("Idoso!");
        }
        else if(idade >= 18){
            System.out.println("Adulto!");
        }
        else if (idade < 0) {
            System.out.println("Voce ainda nem nasceu.");
        }
        else if(idade == 0){
            System.out.println("Nasceu!");
        }
          else if(idade == 1){
            System.out.println("Voce e um bebe.");
        }
        else {
            System.out.println("Voce e uma crianca.");
        }


        // Grupo 3 PARA OS ESTUDANTES

        if(Estudante){
            System.out.println("Voce e um estudante!");
        }
        else {
            System.out.println("Voce NAO e um estudante!");
        }


        scanner.close();
    }
}