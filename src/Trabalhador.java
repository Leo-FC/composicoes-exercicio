import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private double salarioBase;

    private Departamento departamento;
    private List <HoraContrato> contratos = new ArrayList<>();

    public Trabalhador(){}

    public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento){
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }

    public void addContrato(HoraContrato contrato){
        contratos.add(contrato);
    }

    public void removeContrato(HoraContrato contrato){
        contratos.remove(contrato);
    }

    public double receita(int ano, int mes){
        double soma = salarioBase;
        for(HoraContrato con : contratos){
            int con_ano = con.getData().getYear();
            int con_mes = con.getData().getMonthValue();

            if(ano == con_ano && mes == con_mes){
                soma += con.valorTotal();
            }
        }
        return soma;
    }

}
