package cossosCelestes;

/**
 * Classe per definifir astres.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public abstract class Astre {

    String nom;
    String descripcio;
    double diametre;
    double massa;
    double volum;
    float temperatura;
    String periodeOrbital;

    /**
     * Calcula el volum i el retorna.
     * 
     * @return Double
     */
    public abstract double calcularVolum();

    public abstract void setNom(String nom);

    public abstract String getNom();

    public abstract double getDiametre();

    public abstract void setDiametre(double diametre);

    public abstract double getMassa();

    public abstract void setMassa(double massa);

    public abstract float getTemperatura();

    public abstract double getVolum();

    public abstract void setTemperatura(float temperatura);

    public abstract String getPeriodeOrbital();

    public abstract void setPeriodeOrbital(String periodeOrbital);

    public abstract String getDescripcio();

}
