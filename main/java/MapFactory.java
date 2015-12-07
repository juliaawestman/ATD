package main.java;

import main.java.tile.Tile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;

/**
 * Class:       TileMap
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-12-01
 */
public class MapFactory {

    private NodeList mapList;

    /*Will contain all types of tiles in order to save time when needing
    * the same class several times. */
    private Hashtable<String, Class<?>> tileTypes;

    public MapFactory(String mapFilePath) throws IOException, SAXException {
        validateMap(new StreamSource(mapFilePath));
        mapList = getMaps(new InputSource(mapFilePath));
        tileTypes = new Hashtable<String, Class<?>>();
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
        Map map = null;
        for (int i = 0; i < mapList.getLength(); i++){
            Node node = mapList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (mapName.compareTo(getTagValue("name", element)) == 0){
                    map = loadMap(element);
                }
            }
        }
        return map;
    }


    private Map loadMap(Element e) {
        Map map = new Map();
        NodeList mapInfo = e.getChildNodes();

        System.out.println(getTagValue("name", e));
        map.setName(getTagValue("name", e));

        System.out.println(Integer.parseInt(getTagValue("waves", e)));
        map.setWaves(Integer.parseInt(getTagValue("waves", e)));

        System.out.println(Integer.parseInt(getTagValue("winScore", e)));
        map.setWinScore(Integer.parseInt(getTagValue("winScore", e)));

        for (int i = 0; i < mapInfo.getLength(); i++){
            Node node = mapInfo.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String nodeName = node.getNodeName();
                if (nodeName.compareTo("tile") == 0) {
                    try {
                        Tile t = constructTile(node);
                        map.addTile(t);
                    } catch (WrongClassTypeException e1) {
                        e1.printStackTrace();
                        //TODO should probably send it further "up"
                    }
                }
            }
        }

        return map;
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
        Node nValue = nlList.item(0);
        return nValue.getNodeValue();
    }

    private Tile constructTile(Node node) throws WrongClassTypeException {
        Node tileTypeNode = node.getAttributes().getNamedItem("tileType");

        //TODO fix this if possible
        /*Gets the name of the tile that should be loaded*/
        String type = "main.java.tile." + tileTypeNode.getNodeValue();
        Class<?> tileType = tileTypes.get(type);

        if (tileType == null){
            tileType = readClass(type);
        }

        Tile tile = null;

        //WOEKING HERE
        //tileType.getConstructor()

        try {
            tile = (Tile) tileType.newInstance();
        } catch (InstantiationException e) {
            //TODO exception handling
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return tile;
    }

    /**
     * Loads a tile class into the program, if the
     * TODO better description
     * @param className
     * @return
     */
    private Class<?> readClass(String className) throws WrongClassTypeException {
        Class c = null;

        try {
            /*Create an url to the directory the class should exist in*/
            URL classUrl = (new java.io.File("main/java/tile/")).toURI().toURL();

            /*start an class loader that use URLs*/
            URL[] classUrls = {classUrl};
            URLClassLoader ucl = new URLClassLoader(classUrls);

            c = ucl.loadClass(className);
        } catch (ClassNotFoundException e) {
            //TODO exception handling
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        /*Check if the class loaded actually is a subclass of Tile*/
        if(!Tile.class.isAssignableFrom(c)){
            throw new WrongClassTypeException();
        }

        tileTypes.put(c.getName(), c);
        return c;
    }

    /**
     * Checks if the map given is valid according to the schema specified.
     *
     * @param map the path to the map.
     * @return true if the map is valid, else false.
     */
    private boolean validateMap(StreamSource map) throws IOException, SAXException {
        String schemaPath = "../resources/test2.xsd";

        String schemaLang = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
        URL url = getClass().getResource(schemaPath);
        Schema schema = factory.newSchema(new StreamSource(url.openStream()));
        Validator validator = schema.newValidator();
        validator.validate(map);
        return true;
    }

}
