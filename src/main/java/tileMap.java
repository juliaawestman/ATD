package src.main.java;

import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

/**
 * Class:       tileMap
 *
 * Author:      Erik Moström
 * cs-user:     dv14emm
 * Date:        2015-12-01
 */
public class tileMap {

    public tileMap(){

    }

    public void readMap(String schemaName) {
        try {
            String schemaLang = "http://www.w3.org/2001/XMLSchema";
            SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
            Schema schema = factory.newSchema(new StreamSource("../mapTemplate.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(schemaName));
        } catch (SAXException ex) {
            //TODO Fix error handling
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
