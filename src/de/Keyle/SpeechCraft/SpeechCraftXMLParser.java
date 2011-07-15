package de.Keyle.SpeechCraft;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SpeechCraftXMLParser {

	Document dom;
	Map<String,String> Lables = new HashMap<String,String>();
	
	public SpeechCraftXMLParser(){
		parseXmlFile("employees.xml");
		parseDocument();
	}
	
	
	
	private void parseXmlFile(String strXmlFile){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(strXmlFile);
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	

	private void parseDocument(){
		//get the root element
		Element docEle = dom.getDocumentElement();

		//get a nodelist of  elements
		NodeList pluginName = docEle.getElementsByTagName("plugin");
		Element elBuff =  (Element)pluginName.item(0);
		String pluginName_str = elBuff.getAttribute("name");
		
		NodeList nl = docEle.getElementsByTagName(pluginName_str);
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the employee element
				Element el = (Element)nl.item(i);

				ReadStings(el);
			}
		}
	}
	
	
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	
	/*private int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}*/
	
	private void ReadStings(Element ele){
	
		Lables.put(ele.getAttribute("lable"), getTextValue(ele,"message"));

	}
	
	
}
