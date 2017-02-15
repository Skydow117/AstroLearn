/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cossosCelestes;

/**
 *
 * @author davidcastillomartinez
 */
public class Planeta extends Astre implements Comparable<Planeta> {

    private boolean anells;
    private int periode;
    private int distanciaEstrella;

    public Planeta() {
    }

    public Planeta(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public int getDistanciaEstrella() {
        return distanciaEstrella;
    }

    public void setDistanciaEstrella(int distanciaEstrella) {
        this.distanciaEstrella = distanciaEstrella;
    }

    public Planeta(int periode, double massa, int distanciaEstrella) {
        this.massa = massa;
        this.periode = periode;
        this.distanciaEstrella = distanciaEstrella;

    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public boolean isAnells() {
        return anells;
    }

    public void setAnells(boolean anells) {
        this.anells = anells;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getDiametre() {
        return diametre;
    }

    public void setDiametre(double diametre) {
        this.diametre = diametre;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(String galaxia) {
        this.galaxia = galaxia;
    }

    @Override
    public double calcularVolum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //proximitat al sol
    @Override
    public int compareTo(Planeta o) {
        int resultado = 0;
        if (this.distanciaEstrella < o.distanciaEstrella) {
            resultado = 1;
        } else if (this.distanciaEstrella > o.distanciaEstrella) {
            resultado = -1;
        }  else {
            resultado = 0;
        }
        return resultado;
    }

}
