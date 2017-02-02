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
public abstract class Astre {
    
    String strNom;
    String strDescripcio;
    double dDiametre;
    double dMassa;
    double dVolum;
    float fTemperatura;
    String strGalaxia;
    
    
    public abstract double calculardVolum();
    
    public abstract void setStrNom(String strNom);

    public abstract String getStrNom();

    public abstract double getdDiametre();

    public abstract void setdDiametre(double dDiametre);

    public abstract double getdMassa();

    public abstract void setdMassa(double dMassa);

    public abstract float getfTemperatura();

    public abstract void setfTemperatura(float fTemperatura);

    public abstract String getStrGalaxia();

    public abstract void setStrGalaxia(String galaxia);
    
    public abstract String getStrDescripcio();
    
    public abstract void setStrDescripcio(String descripcio);
    
}
