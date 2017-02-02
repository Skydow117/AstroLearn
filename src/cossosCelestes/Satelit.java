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
    
    private double dDistanciaOrbitaMax;
    private double dDistanciaOrbitaMin;
    private String strPlanetaQueOrbita;

    public Satelit() {
        
    }

    public double getdDistanciaOrbitaMax() {
        return dDistanciaOrbitaMax;
    }

    public void setdDistanciaOrbitaMax(double dDistanciaOrbitaMax) {
        this.dDistanciaOrbitaMax = dDistanciaOrbitaMax;
    }

    public double getdDistanciaOrbitaMin() {
        return dDistanciaOrbitaMin;
    }

    public void setdDistanciaOrbitaMin(double dDistanciaOrbitaMin) {
        this.dDistanciaOrbitaMin = dDistanciaOrbitaMin;
    }

    public String getStrPlanetaQueOrbita() {
        return strPlanetaQueOrbita;
    }

    public void setStrPlanetaQueOrbita(String strPlanetaQueOrbita) {
        this.strPlanetaQueOrbita = strPlanetaQueOrbita;
    }

    public String getStrNom() {
        return strNom;
    }

    public void setStrNom(String strNom) {
        this.strNom = strNom;
    }

    public String getStrDescripcio() {
        return strDescripcio;
    }

    public void setStrDescripcio(String strDescripcio) {
        this.strDescripcio = strDescripcio;
    }

    public double getdDiametre() {
        return dDiametre;
    }

    public void setdDiametre(double dDiametre) {
        this.dDiametre = dDiametre;
    }

    public double getdMassa() {
        return dMassa;
    }

    public void setdMassa(double dMassa) {
        this.dMassa = dMassa;
    }

    public double getdVolum() {
        return dVolum;
    }

    public void setdVolum(double dVolum) {
        this.dVolum = dVolum;
    }

    public float getfTemperatura() {
        return fTemperatura;
    }

    public void setfTemperatura(float fTemperatura) {
        this.fTemperatura = fTemperatura;
    }

    public String getStrGalaxia() {
        return strGalaxia;
    }

    public void setStrGalaxia(String strGalaxia) {
        this.strGalaxia = strGalaxia;
    }

    @Override
    public double calculardVolum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
 
}
