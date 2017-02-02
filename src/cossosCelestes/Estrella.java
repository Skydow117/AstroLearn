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

    private String strBrillantor;
    private long lAnysFinsApagar;

    public Estrella() {
    }

    public String getStrBrillantor() {
        return strBrillantor;
    }

    public void setStrBrillantor(String strBrillantor) {
        this.strBrillantor = strBrillantor;
    }

    public long getlAnysFinsApagar() {
        return lAnysFinsApagar;
    }

    public void setlAnysFinsApagar(long lAnysFinsApagar) {
        this.lAnysFinsApagar = lAnysFinsApagar;
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

    @Override
    public void setdDiametre(double dDiametre) {
        this.dDiametre = dDiametre;
    }

    @Override
    public double getdMassa() {
        return dMassa;
    }

    @Override
    public void setdMassa(double dMassa) {
        this.dMassa = dMassa;
    }

    public double getdVolum() {
        return dVolum;
    }

    public void setdVolum(double dVolum) {
        this.dVolum = dVolum;
    }

    @Override
    public float getfTemperatura() {
        return fTemperatura;
    }

    @Override
    public void setfTemperatura(float fTemperatura) {
        this.fTemperatura = fTemperatura;
    }

    @Override
    public String getStrGalaxia() {
        return strGalaxia;
    }

    @Override
    public void setStrGalaxia(String strGalaxia) {
        this.strGalaxia = strGalaxia;
    }

    @Override
    public double calculardVolum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
