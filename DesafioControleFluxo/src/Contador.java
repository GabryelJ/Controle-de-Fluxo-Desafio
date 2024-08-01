import java.util.InputMismatchException;
import java.util.Scanner;
public class Contador {

    public static void contar(int primeiroParametro, int segundoParametro) throws ParametrosInvalidosException{
        if (primeiroParametro > segundoParametro){
            throw new ParametrosInvalidosException();
        }
        else {
            for (int i = 1; i <= (segundoParametro - primeiroParametro); i++){
                System.out.println("Imprimindo o numero " + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        int parametroUm= -99;
        int parametroDois = -99;
        boolean entradaValida = false;
        while (!entradaValida || (parametroUm > parametroDois)) {
            try {
                System.out.print("Digite o primeiro parametro: ");
                parametroUm = terminal.nextInt();
                System.out.print("Digite o segundo parametro: ");
                parametroDois = terminal.nextInt();
                entradaValida = true;
                contar(parametroUm, parametroDois);
            } catch (InputMismatchException exception) {
                System.out.println("Insira um numero.");
                System.out.println("Tente novamente: ");
                entradaValida = false;
                parametroUm = -99;
                parametroDois = -99;
                terminal.nextLine();
            } catch (ParametrosInvalidosException exception) {
                System.out.println("O segundo parametro deve ser maior que o primeiro.");
                System.out.println("Tente novamente: ");
                entradaValida = false;
                parametroUm = -99;
                parametroDois = -99;
            }
        }
        terminal.close();
    }
}
