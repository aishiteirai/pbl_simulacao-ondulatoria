package org.example;
import java.math.BigDecimal;

public class Simulacao extends Onda{

    private double tempo;
    private double erro_max;
    private double delta_x = 0.01;
    private double x_max = 1.0;
    private double delta_t = 1;

    public Simulacao() {
    }

    public Simulacao(double tempo, double erro_max, double freq, double comp) {
        super(freq, comp);
        this.tempo = tempo;
        this.erro_max = Math.pow(10, (-erro_max));
    }


    void realizarSimulacao(){
        Calculos obj_calculos = new Calculos(this, this);

        obj_calculos.init_vars();

        for(double x = 0.0; x <= x_max; x += delta_x){
            for(double t = 0.0; t <= tempo; t += delta_t){
                double y = obj_calculos.calculateY(x,t);
                System.out.println("x: " + obj_calculos.arredondar(x, 2) + " | y: " + y);
            }
        }

        Main.Menu();
    }

    public double getTempo() {
        return tempo;
    }
    public void setTempo(double tempo) {
        this.tempo = tempo;
    }
    public double getErro_max() {
        return erro_max;
    }
    public void setErro_max(double erro_max) {
        this.erro_max = erro_max;
    }
    public double getDelta_x() {
        return delta_x;
    }
    public void setDelta_x(double delta_x) {
        this.delta_x = delta_x;
    }
    public double getX_max() {
        return x_max;
    }
    public void setX_max(double x_max) {
        this.x_max = x_max;
    }
}
