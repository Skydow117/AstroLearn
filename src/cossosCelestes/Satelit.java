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
public class Satelit extends Astre{
    
    private String planetaQueOrbita;
    private double distanciaOrbitaMax;
    private double distanciaOrbitaMin;

    public String getPlanetaQueOrbita() {
        return planetaQueOrbita;
    }

    public void setPlanetaQueOrbita(String planetaQueOrbita) {
        this.planetaQueOrbita = planetaQueOrbita;
    }

    public double getDistanciaOrbitaMax() {
        return distanciaOrbitaMax;
    }

    public void setDistanciaOrbitaMax(double distanciaOrbitaMax) {
        this.distanciaOrbitaMax = distanciaOrbitaMax;
    }

    public double getDistanciaOrbitaMin() {
        return distanciaOrbitaMin;
    }

    public void setDistanciaOrbitaMin(double distanciaOrbitaMin) {
        this.distanciaOrbitaMin = distanciaOrbitaMin;
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
    
    
    
}
