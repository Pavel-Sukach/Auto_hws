package autohw1.task1.DOMTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMTest {
    private static ArrayList<Employee> medemployees = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/java/autohw1/task1/DOMTest/medemployees.xml"));

        NodeList medEmployeeElements = document.getElementsByTagName("employee");

        String firstName;
        String lastName;
        String position;
        String department;
        int expYears;
        for(int i = 0; i < medEmployeeElements.getLength(); i++){
            Node node = medEmployeeElements.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                position = element.getElementsByTagName("position").item(0).getTextContent();
                department = element.getElementsByTagName("department").item(0).getTextContent();
                expYears = Integer.valueOf(element.getElementsByTagName("experienceYears").item(0).getTextContent());
                medemployees.add(new Employee(firstName,lastName,position,department,expYears));
            }
        }
        for(Employee employee : medemployees){
            System.out.printf("First name: %s, Last name: %s, Position: %s, Department: %s, Experience: %d.\n",
                    employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getDepartment(), employee.getExpYears());
        }

        checkEmployee("Linda Smith orthopedist orthopedics 11");
    }
    public static void checkEmployee(String employeeData) throws IOException, SAXException, ParserConfigurationException {
        String data[] = employeeData.split(" ");
        String fNToCheck = data[0];
        String lNToCheck = data[1];
        String posToCheck = data[2];
        String depToCheck = data[3];
        int exYToCheck = Integer.valueOf(data[4]);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/java/autohw1/task1/DOMTest/medemployees.xml"));

        NodeList medEmployeeElements1 = document.getElementsByTagName("employee");

        String firstName;
        String lastName;
        String position;
        String department;
        int expYears;
        for(int i = 0; i < medEmployeeElements1.getLength(); i++){
            Node node = medEmployeeElements1.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                firstName = element.getElementsByTagName("firstName").item(0).getTextContent();
                lastName = element.getElementsByTagName("lastName").item(0).getTextContent();
                position = element.getElementsByTagName("position").item(0).getTextContent();
                department = element.getElementsByTagName("department").item(0).getTextContent();
                expYears = Integer.valueOf(element.getElementsByTagName("experienceYears").item(0).getTextContent());

                if(firstName.equals(fNToCheck) && lastName.equals(lNToCheck) && position.equals(posToCheck) &&
                department.equals(depToCheck) && expYears==exYToCheck){
                    System.out.println("Employee is found!");
                }
            }
        }
    }
}
