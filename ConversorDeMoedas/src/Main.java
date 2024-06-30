import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda consultaMoeda = new ConsultaMoeda();
        String moedaOriginal;
        String moedaConvertida;

        while (true) {
            System.out.println("***************************************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moedas! ");
            System.out.println("");
            System.out.println("Menu de opções disponíveis:");
            System.out.println("1. Conversão Dólar americano (USD) >>>> Euro (EUR)");
            System.out.println("2. Conversão Euro (EUR) >>>> Dólar americano (USD)");
            System.out.println("3. Conversão Dólar americano (USD) >>>> Real Brasileiro (BRL)");
            System.out.println("4. Conversão Real Brasileiro (BRL) >>>> Dólar americano (USD)");
            System.out.println("5. Conversão Euro (EUR) >>>> Real Brasileiro (BRL)");
            System.out.println("6. Conversão Real Brasileiro (BRL) >>>> Euro (EUR)");
            System.out.println("7. Sair");
            System.out.println("");
            System.out.println("***************************************************************");
            System.out.print("Escolha uma opção válida: ");
            System.out.println("");

            int opcao = leitura.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }


            switch (opcao) {
                case 1:
                    moedaOriginal = "USD";
                    moedaConvertida = "EUR";
                    break;
                case 2:
                    moedaOriginal = "EUR";
                    moedaConvertida = "USD";
                    break;
                case 3:
                    moedaOriginal = "USD";
                    moedaConvertida = "BRL";
                    break;
                case 4:
                    moedaOriginal = "BRL";
                    moedaConvertida = "USD";
                    break;
                case 5:
                    moedaOriginal = "EUR";
                    moedaConvertida = "BRL";
                    break;
                case 6:
                    moedaOriginal = "BRL";
                    moedaConvertida = "EUR";
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    continue;
            }

            System.out.print("Digite o valor a ser convertido: ");
            double valor = leitura.nextDouble();

            try {
                Conversao conversao = consultaMoeda.buscarMoeda(moedaOriginal);
                Map<String, Double> rates = conversao.getConversionRates();
                if (rates.containsKey(moedaConvertida)) {
                    double taxa = rates.get(moedaConvertida);
                    double valorConvertido = valor * taxa;
                    System.out.printf("O valor de %.2f %s equivale a %.2f %s\n\n", valor, moedaOriginal, valorConvertido, moedaConvertida);
                } else {
                    System.out.println("Não foi possível encontrar a taxa de conversão para a moeda escolhida.\n");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Erro ao realizar a conversão.\n");
            }
        }

        leitura.close();
    }
}

