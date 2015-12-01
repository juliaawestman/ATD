package src.main.java;

import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.net.URL;

/**
 * Class:       tileMap
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-12-01
 */
public class tileMap {

    public tileMap(String mapPath){
        validateMap(mapPath);
    }

    /**
     * Checks if the map given is valid.
     *
     * @param mapPath the path to the map.
     * @return true if the map is valid, else false.
     */
    public boolean validateMap(String mapPath){
        try {
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            URL url = getClass().getResource("../resources/mapTemplate.xsd");
            System.out.println(url);
            Schema schema = factory.newSchema(new StreamSource(url.openStream()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(mapPath));
        } catch (SAXException ex) {
            //TODO error handling
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
