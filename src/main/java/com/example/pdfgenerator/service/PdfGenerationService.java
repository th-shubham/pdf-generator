package com.example.pdfgenerator.service;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.InputStream;

@Service
public class PdfGenerationService {

    private final FopFactory fopFactory;

    @Autowired
    public PdfGenerationService(FopFactory fopFactory) {
        this.fopFactory = fopFactory;
    }

    public ByteArrayOutputStream generatePdf(String xmlData, InputStream xlsData) throws IOException, SAXException {
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, new ByteArrayOutputStream());

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();

        Source xmlSource = new StreamSource(new StringReader(xmlData));
        Result result = new SAXResult(fop.getDefaultHandler());

        transformer.transform(xmlSource, result);

        return (ByteArrayOutputStream) fop.getOutputStream();
    }
}
