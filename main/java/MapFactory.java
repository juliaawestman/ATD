package main.java;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import main.java.tile.Tile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

/**
 * Class:       TileMap
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-12-01
 */
public class MapFactory {

    NodeList mapList;

    public MapFactory(String mapFilePath) throws IOException, SAXException {
        validateMap(new StreamSource(mapFilePath));
        mapList = getMaps(new InputSource(mapFilePath));
    }

    private NodeList getMaps(InputSource maps) throws IOException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(maps);
            Element data=doc.getDocumentElement();
            data.normalize();
            return doc.getElementsByTagName("map");
        } catch (ParserConfigurationException e) {
            throw new IOException("Unable to configure parser");
        } catch (SAXException e) {
            throw new IOException("Not correct format");
        }
    }

    /**
     * Will generate the specified map from the file storing the maps.
     *
     * @param mapName the name of the desired map
     * @return the map asked for, if it doesn't exist null will be returned
     */
    public Map makeMap(String mapName){
        for (int i = 0; i < mapList.getLength(); i++){
            Node node = mapList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (mapName.compareTo(getTagValue("name", element)) == 0){
                    loadMap(node);
                }
            }
        }
        return null;
    }


    private void loadMap(Node n) {

    }

    /**
     * Will return the value held by a tag in the xml document.
     *
     * @param tag the name of the tag
     * @param element the element holding the tag
     * @return a string representing the value
     */
    private String getTagValue(String tag, Element element) {
        NodeList nlList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        return nValue.getNodeValue();
    }

    private Tile constructTile(){
        return null;
    }

    /**
     * Checks if the map given is valid.
     *
     * @param map the path to the map.
     * @return true if the map is valid, else false.
     */
    private boolean validateMap(StreamSource map) throws IOException, SAXException {
        String schemaLang = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
        URL url = getClass().getResource("../resources/mapTemplate.xsd");
        Schema schema = factory.newSchema(new StreamSource(url.openStream()));
        Validator validator = schema.newValidator();
        validator.validate(map);
        return true;
    }

}
