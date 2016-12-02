package json2xsd.converter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

import org.w3c.dom.Document;

import com.ethlo.schematools.jsons2xsd.Jsons2Xsd;
import com.ethlo.schematools.jsons2xsd.XmlUtil;
import com.ethlo.schematools.jsons2xsd.Jsons2Xsd.OuterWrapping;

public class Converter {
    public static void main( String[] args ) throws IOException
    {
    	//The following commented out lines are used for testing in Eclipse :
    	//InputStream inputStream = new FileInputStream("src/main/java/resources/jsonSchema.json");
	//Reader jsonSchema = new InputStreamReader(inputStream);
	Reader jsonSchema = new InputStreamReader(System.in);
	Document doc = Jsons2Xsd.convert(jsonSchema, "json2xsd", OuterWrapping.ELEMENT, "json2xsd");
	String temp = XmlUtil.asXmlString(doc.getDocumentElement());		
	PrintWriter out = new PrintWriter(new FileOutputStream("xsdSchema.xml", true),  true);
	out.println(temp);
	System.out.println("The file xsdSchema.xml is ready.");
    }    
}
