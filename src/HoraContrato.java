import java.time.LocalDate;


public class HoraContrato {
    private LocalDate data;
    private double valorHora;
    private int horas;

    public HoraContrato(){}

    public HoraContrato(LocalDate data, double valorHora, int horas){
        this.data = data;
        this.valorHora = valorHora;
        this.horas = horas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public double valorTotal(){
        return valorHora * horas;
    }
}
