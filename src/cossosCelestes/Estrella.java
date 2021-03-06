package cossosCelestes;

/**
 * Classe que representa un astre de tipus estrella.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class Estrella extends Astre {

    private String brillantor;
    private long anysFinsApagar;
    private String galaxia;

    /**
     * Constructor buit.
     */
    public Estrella() {
    }

    /**
     * Constructor amb tots els atributs.
     * 
     * @param nom
     * @param descripcio
     * @param brillantor
     * @param diametre
     * @param anysFinsApagar
     * @param massa
     * @param volum
     * @param temperatura
     * @param galaxia 
     */
    public Estrella(String nom, String descripcio, String brillantor, double diametre, long anysFinsApagar, double massa, double volum, float temperatura, String galaxia) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.brillantor = brillantor;
        this.diametre = diametre;
        this.anysFinsApagar = anysFinsApagar;
        this.volum = volum;
        this.massa = massa;
        this.galaxia = galaxia;
        this.temperatura = temperatura;

    }

    /**
     * Calcula el volum i el retorna.
     * 
     * @return Double
     */
    @Override
    public double calcularVolum() {
        return 0;
    }

    public String getGalaxia() {
        return galaxia;
    }

    public void setGalaxia(String galaxia) {
        this.galaxia = galaxia;
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
    public String getPeriodeOrbital() {
        return periodeOrbital;
    }

    @Override
    public void setPeriodeOrbital(String galaxia) {
        this.periodeOrbital = galaxia;
    }

    @Override
    public String getDescripcio() {
        return this.descripcio;
    }

    public String getBrillantor() {
        return brillantor;
    }

    public void setBrillantor(String brillantor) {
        this.brillantor = brillantor;
    }

    public long getAnysFinsApagar() {
        return anysFinsApagar;
    }

    public void setAnysFinsApagar(long anysFinsApagar) {
        this.anysFinsApagar = anysFinsApagar;
    }
    
    

}
