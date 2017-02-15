/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitatXML;

import cossosCelestes.Planeta;
import excepcionsPropies.xmlNoTrobatException;
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
public class lectorXML {

    public lectorXML() {

    }

    ArrayList<Planeta> planetes = new ArrayList<Planeta>();
    private int ultimPlaneta;

    public void adquirir() throws xmlNoTrobatException {
        try {

            File planetesXML = new File("planetes.xml");
            System.out.println(planetesXML.getAbsolutePath());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(planetesXML);
            doc.getDocumentElement().normalize();

            System.out.println("arrel " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("planeta");
            System.out.println("==========================");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    Planeta planeta = new Planeta(obtenirContingut("nom", element), obtenirContingut("descripcio", element));
                    planetes.add(planeta);
                    System.out.println(planeta.getNom());
                    System.out.println(planeta.getDescripcio());
                }
            }
        } catch (Exception ex) {
            xmlNoTrobatException excepcio = new xmlNoTrobatException("No s'ha trobat el fitxer planetes.xml");
            excepcio.printStackTrace();
            throw excepcio;
        }

        try {
            File planetesXML = new File("ultimAstre.xml");
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
            xmlNoTrobatException excepcio = new xmlNoTrobatException("No s'ha trobat el fitxer ultimAstre.xml");
            excepcio.printStackTrace();
            throw excepcio;
        }
    }

    public int getUltimPlaneta(){
        return ultimPlaneta;
    }
    
    private static String obtenirContingut(String etiqueta, Element element) {
        NodeList nodes = element.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node node = (Node) nodes.item(0);
        return node.getNodeValue();
    }

    public Planeta obtenirPlaneta(int index) {

        if (index <= planetes.size()) {
            return planetes.get(index);

        } else {
            return null;
        }
    }

}
