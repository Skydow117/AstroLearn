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

    public Satelit(String nom, String descripcio,double diametre,double massa,double volum,float temperatura,String periodeOrbital,String planetaQueOrbita, double distanciaOrbitaMax,double distanciaOrbitaMin ) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.diametre = diametre;
        this.volum=volum;
        this.massa=massa;
        this.periodeOrbital=periodeOrbital;
        this.temperatura=temperatura;
        this.planetaQueOrbita=planetaQueOrbita;
        this.distanciaOrbitaMax=distanciaOrbitaMax;
        this.distanciaOrbitaMin=distanciaOrbitaMin;
       
    }

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
    
    
    
}
