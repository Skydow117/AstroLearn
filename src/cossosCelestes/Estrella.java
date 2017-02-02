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
public class Estrella extends Astre{

    private String brillantor;
    private long anysFinsApagar;

    public Estrella() {
    }

    @Override
    public double calcularVolum() {
        return 0;
    }
    
    @Override
      public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public double getDiametre() {
        return diametre;
    }

    @Override
    public void setDiametre(double diametre) {
        this.diametre = diametre;
    }

    @Override
    public double getMassa() {
        return massa;
    }

    @Override
    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    @Override
    public float getTemperatura() {
        return temperatura;
    }

    @Override
    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String getGalaxia() {
        return galaxia;
    }

    @Override
    public void setGalaxia(String galaxia) {
        this.galaxia = galaxia;
    }

}
