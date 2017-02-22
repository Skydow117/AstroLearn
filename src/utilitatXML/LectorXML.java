/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitatXML;

import astreList.AstreList;
import cossosCelestes.Astre;
import cossosCelestes.Estrella;
import cossosCelestes.Planeta;
import cossosCelestes.Satelit;
import excepcionsPropies.XmlNoTrobatException;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author davidcastillomartinez
 */
public class LectorXML {

    public LectorXML() {

    }

    AstreList<Astre> astres = new AstreList<Astre>();
    private int ultimPlaneta;

    public void adquirir() throws XmlNoTrobatException {
        try {

            File planetesXML = new File("fitxersPrograma/astres.xml");
            System.out.println(planetesXML.getAbsolutePath());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(planetesXML);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("astre");
            System.out.println("==========================");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    if (obtenirContingut("tipus", element).equals("planeta")) {

                        Planeta planeta = new Planeta(obtenirContingut("nom", element), obtenirContingut("descripcio", element), Integer.parseInt(obtenirContingut("distanciaestrella", element)), Double.parseDouble(obtenirContingut("diametre", element)), Boolean.parseBoolean(obtenirContingut("anells", element)), Double.parseDouble(obtenirContingut("massa", element)), Double.parseDouble(obtenirContingut("volum", element)), Float.parseFloat(obtenirContingut("temperatura", element)), obtenirContingut("periodeorbital", element));

                        astres.afegir(planeta);
                        System.out.println(planeta.getNom());
                        System.out.println(planeta.getDescripcio());
                    }

                    if (obtenirContingut("tipus", element).equals("satelit")) {

                        Satelit satelit = new Satelit(obtenirContingut("nom", element), obtenirContingut("descripcio", element), Double.parseDouble(obtenirContingut("diametre", element)), Double.parseDouble(obtenirContingut("massa", element)), Double.parseDouble(obtenirContingut("volum", element)), Float.parseFloat(obtenirContingut("temperatura", element)), obtenirContingut("periodeorbital", element), obtenirContingut("planetaorbita", element), Double.parseDouble(obtenirContingut("distanciaorbitamax", element)), Double.parseDouble(obtenirContingut("distanciaorbitamin", element)));

                        astres.afegir(satelit);
                        System.out.println(satelit.getNom());
                        System.out.println(satelit.getDescripcio());
                    }

                    if (obtenirContingut("tipus", element).equals("estrella")) {

                        Estrella estrella = new Estrella(obtenirContingut("nom", element), obtenirContingut("descripcio", element), obtenirContingut("brillantor", element), Double.parseDouble(obtenirContingut("diametre", element)), Long.parseLong(obtenirContingut("anysapagar", element)), Double.parseDouble(obtenirContingut("massa", element)), Double.parseDouble(obtenirContingut("volum", element)), Float.parseFloat(obtenirContingut("temperatura", element)), obtenirContingut("galaxia", element));
                        astres.afegir(estrella);
                        System.out.println(estrella.getNom());
                        System.out.println(estrella.getDescripcio());
                    }
                }
            }
        } catch (Exception ex) {
            XmlNoTrobatException excepcio = new XmlNoTrobatException("No s'ha trobat el fitxer astres.xml");
            excepcio.printStackTrace();
            throw excepcio;
        }

        try {
            File planetesXML = new File("fitxersPrograma/ultimAstre.xml");
            System.out.println(planetesXML.getAbsolutePath());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(planetesXML);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("ultimAstre");
            System.out.println("==========================");

            Node node = nodes.item(0);

            Element element = (Element) node;

            System.out.print(obtenirContingut("astre", element));
            ultimPlaneta = Integer.parseInt(obtenirContingut("astre", element));

        } catch (Exception ex) {
            XmlNoTrobatException excepcio = new XmlNoTrobatException("No s'ha trobat el fitxer ultimAstre.xml");
            excepcio.printStackTrace();
            throw excepcio;
        }
    }

    public int getUltimPlaneta() {
        return ultimPlaneta;
    }

    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }

    public Astre obtenirPlaneta(int index) {

        if (index <= astres.mida()) {
            return astres.agafar(index);

        } else {
            return null;
        }
    }

}
