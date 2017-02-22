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

    public Planeta(String nom, String descripcio, int distanciaEstrella, double diametre, boolean anells, double massa, double volum, float temperatura, String periodeOrbital) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.distanciaEstrella = distanciaEstrella;
        this.diametre = diametre;
        this.anells = anells;
        this.volum = volum;
        this.massa = massa;
        this.periodeOrbital = periodeOrbital;
        this.temperatura = temperatura;

    }
    
    

    public Planeta(int periode, double massa, int distanciaEstrella) {
        this.massa = massa;
        this.periode = periode;
        this.distanciaEstrella = distanciaEstrella;

    }

    public int getDistanciaEstrella() {
        return distanciaEstrella;
    }

    public void setDistanciaEstrella(int distanciaEstrella) {
        this.distanciaEstrella = distanciaEstrella;
    }
    
    public double getVolum(){
    return this.volum;
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

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getPeriodeOrbital() {
        return periodeOrbital;
    }

    public void setPeriodeOrbital(String galaxia) {
        this.periodeOrbital = galaxia;
    }

    @Override
    public double calcularVolum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getAnells() {
        return anells;
    }

    //proximitat al sol
    @Override
    public int compareTo(Planeta o) {
        int resultado = 0;
        if (this.distanciaEstrella < o.distanciaEstrella) {
            resultado = 1;
        } else if (this.distanciaEstrella > o.distanciaEstrella) {
            resultado = -1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

}
