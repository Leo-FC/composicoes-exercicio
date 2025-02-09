import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Entre com os dados do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrabalhador = sc.nextLine();

        System.out.print("Nivel: ");
        String nivelTrabalhador = sc.nextLine();

        System.out.print("Salario base: ");
        double salarioTrabalhador = sc.nextDouble();

        // NivelTrabalhador.valueOf(nivelTrabalhador) = Usando a String para definir o valor
        // new Departamento(nomeDepartamento) = Como o departamento é uma classe a parte, é preciso instanciar
        // o objeto e passar o valor
        Trabalhador trabalhador1 = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador),
                salarioTrabalhador, new Departamento(nomeDepartamento));

        System.out.print("Quantos contratos esse trabalhador possui? ");
        int qtdContratos = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < qtdContratos; i++){
            System.out.printf("\nDigite os dados do contrato %d:\n", i + 1);

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Informe a data (DD/MM/YYYY): ");
            String dataInformada = sc.nextLine();
            //Converter a string para LocalDate
            LocalDate dataContrato = LocalDate.parse(dataInformada, fmt);

            System.out.print("Valor por hora: ");
            double valorHoraTrabalhador = sc.nextDouble();

            System.out.print("Duracao: ");
            int valorHora = sc.nextInt();
            sc.nextLine();

            trabalhador1.addContrato(new HoraContrato(dataContrato, valorHoraTrabalhador, valorHora));
        }

        System.out.print("Insira um mês e ano para calcular a receita (MM/YYYY): ");
        String mesAnoInformado = sc.nextLine();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth mesAno = YearMonth.parse(mesAnoInformado, fmt); // Usamos YearMonth porque ele representa apenas mês e ano (MM/yyyy), sem precisar definir um dia como no LocalDate.

        double trabalhadorReceita = trabalhador1.receita(mesAno.getYear(), mesAno.getMonthValue());

        System.out.printf("Nome: %s\nDepartamento: %s\nReceita para %s: %.2f",
                trabalhador1.getNome(), trabalhador1.getDepartamento().getNome(), mesAnoInformado, trabalhadorReceita);
    }
}
