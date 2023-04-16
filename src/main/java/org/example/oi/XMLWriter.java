package org.example.oi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class XMLWriter {
    private static final Log log = LogFactory.getLog(XMLWriter.class.getName());
    public static void generateXML(AllListStUn allListStUn) {
        log.info("start generateXML. (Creat file xml)");
        log.debug("generateXML work");
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy") ;
        String curDate = dateFormat.format(date);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AllListStUn.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // определяем название файла, куда будем сохранять
            File requestFile = new File("all_un_st_" + curDate + ".xml");
            marshaller.marshal(allListStUn, requestFile);
        } catch (JAXBException e) {
            log.debug("create xml faild", e);
        }
        log.info("finish generateXML.");
    }
}
