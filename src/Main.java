import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] array; //array de inteiros
    static boolean arrayCriado = false; //indica se os valores do array já foram gerados

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tamanho = 1000; //tamanho do array
        array = new int[tamanho]; //cria o array vazio com o tamanho escolhido

        boolean sair = false; //variavel auxiliar para o menu

        while (!sair) {
            //Menu interativo
            System.out.println("\n==================MENU==================");
            System.out.println("\nEscolha uma das opções abaixo:");
            System.out.println("1 - Criar array de 1000 valores aleatórios");
            System.out.println("2 - Ordenar o array de menor para maior");
            System.out.println("3 - Mostrar números primos do array");
            System.out.println("4 - Sair");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    gerarArray();
                    break;
                case 2:
                    if (!arrayCriado) {
                        System.out.println("Atenção: é preciso criar o array antes de ordená-lo!");
                    } else {1

                        ordenar(array);
                        System.out.println("Array ordenado com sucesso!");
                    }
                    break;
                case 3:
                    if (!arrayCriado) {
                        System.out.println("Atenção: é preciso criar o array antes de mostrar primos!");
                    } else {
                        mostrarPrimos();
                    }
                    break;
                case 4:
                    System.out.println("Volte sempre...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }

    public static void gerarArray() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1501);
        }
        arrayCriado = true; //marca que o array já foi gerado
        System.out.println("Array gerado com sucesso!");
    }

    public static void ordenar(int[] array) {
        //ordenacao com insertion sort
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static boolean ehPrimo(int n) {
        if (n <= 1) return false; //números menores ou iguais a 1 não são primos
        if (n == 2) return true; //2 é o único primo par
        if (n % 2 == 0) return false; //qualquer número par maior que 2 não é primo
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false; //se é divisível por i, não é primo
        }
        return true; //se não encontrou divisores, é primo
    }

    public static void mostrarPrimos() {
        System.out.println("Números primos no array: ");
        for (int n : array) {
            if (ehPrimo(n)) {
                System.out.println(n);
            }
        }
        System.out.println();
    }
}