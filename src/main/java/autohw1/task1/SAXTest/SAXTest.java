package autohw1.task1.SAXTest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXTest {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XmlHandler handler = new XmlHandler();
        parser.parse(new File("src/main/java/autohw1/task1/SAXTest/medemployees.xml"), handler);

        for (Employee employee : employees) {
            System.out.println(String.format("First name: %s, Last name: %s, Position: %s, Department: %s, Experience: %d.",
                    employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getDepartment(), employee.getExpYears()));
        }
    }

    private static class XmlHandler extends DefaultHandler {
        private String firstName, lastName, position, department, lastElementName;
        private int expYears;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String data = new String(ch, start, length);
            data = data.replace("\n","").trim();

            if(!data.isEmpty()){
                if(lastElementName.equalsIgnoreCase("firstName")){
                    firstName = data;
                }
                if(lastElementName.equalsIgnoreCase("lastName")){
                    lastName = data;
                }
                if(lastElementName.equalsIgnoreCase("position")){
                    position = data;
                }
                if(lastElementName.equalsIgnoreCase("department")){
                    department = data;
                }
                if(lastElementName.equalsIgnoreCase("experienceYears")){
                    expYears = Integer.valueOf(data);
                }
            }
        }
        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if((firstName != null && !firstName.isEmpty()) && (lastName != null && !lastName.isEmpty()) && (position != null && !position.isEmpty()) &&
                    (department != null && !department.isEmpty()) && (expYears != 0)){
                employees.add(new Employee(firstName,lastName,position,department,expYears));
                firstName = null;
                lastName = null;
                position = null;
                department = null;
                expYears = 0;
            }
        }
    }
}