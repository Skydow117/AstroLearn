/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitatXML;

import java.io.File;
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

/**
 *
 * @author davidcastillomartinez
 */
public class escriptorXML {

    public escriptorXML() {

    }

    public void escriure(String strAstre) {

        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document nodeDocument = docBuilder.newDocument();
            Element elementArrel = nodeDocument.createElement("ultimAstre");
            nodeDocument.appendChild(elementArrel);

            Element nodeAstre = nodeDocument.createElement("astre");
            nodeAstre.appendChild(nodeDocument.createTextNode(strAstre));
            elementArrel.appendChild(nodeAstre);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource origen = new DOMSource(nodeDocument);
            StreamResult sortidaXML = new StreamResult(new File("ultimAstre.xml"));

            transformer.transform(origen, sortidaXML);

            System.out.println("Desat!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

}
