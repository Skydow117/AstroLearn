package excepcionsPropies;

/**
 * Excepció personalitzada per quan no troba el fitxer xml.
 * 
 * @author davidcastillomartinez i estevecabrerapuigdomenech
 */
public class XmlNoTrobatException extends Exception {
    public XmlNoTrobatException(String message) {
        super(message);
    }
}