package cossosCelestes;

/**
 * Classe Asteroide. Per guardar les dades d'un esteroide. És filla d'Astre.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public abstract class Asteroide extends Astre {

    private String claseEspectral;
    private float densitat;
    private String areaDeProximitat;

    /**
     * Constructor buit.
     */
    public Asteroide() {
    }

    /**
     * Constructor amb el nom i la descripció.
     * 
     * @param nom nom
     * @param descripcio descripcio
     */
    public Asteroide(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
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

    /**
     * Classe que clacularà el volum.
     * 
     * @return double volum 
     */
    @Override
    public abstract double calcularVolum();

    /**
     * Classe que clacularà la densitat.
     * 
     * @return double densitat 
     */
    public abstract double calcularDensitat();

    /**
     * Classe que determinarà la classe espectral de l'asteroide.
     * 
     * @return double volum 
     */
    public abstract double determinarClaseEspectral();

}
