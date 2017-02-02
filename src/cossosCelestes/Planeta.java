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
public class Planeta extends Astre{
    
    private boolean bAnells;

    public boolean isbAnells() {
        return bAnells;
    }

    public void setbAnells(boolean bAnells) {
        this.bAnells = bAnells;
    }

    @Override
    public String getStrNom() {
        return strNom;
    }

    @Override
    public void setStrNom(String strNom) {
        this.strNom = strNom;
    }

    @Override
    public String getStrDescripcio() {
        return strDescripcio;
    }

    @Override
    public void setStrDescripcio(String strDescripcio) {
        this.strDescripcio = strDescripcio;
    }

    @Override
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
