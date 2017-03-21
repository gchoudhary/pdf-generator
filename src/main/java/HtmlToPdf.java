
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPdf {

	public static void main(String[] args)
	{
		long stratTime = System.currentTimeMillis();
		PdfWriter pdfWriter = null;

		// create a new document
		Document document = new Document();
		try
		{
			String html = VelocityTemplateParser.generateHTML();

			document = new Document();
			// document header attributes
			document.addAuthor("Guruvansh");
			document.addCreationDate();
			document.addProducer();
			document.addCreator("Guruvansh");
			document.addTitle("HTML to PDF using itext");
			document.setPageSize(PageSize.A4);

			OutputStream file = new FileOutputStream(new File("EmployeeList.pdf"));
			pdfWriter = PdfWriter.getInstance(document, file);

			// open document
			document.open();

			XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
			xmlWorkerHelper.getDefaultCssResolver(true);
			xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));

			System.out.println("PDF generated successfully");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally{
			// close the document
			document.close();
			// close the writer
			pdfWriter.close();
			System.out.println("connections closed");
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - stratTime)+ " mili seconds");
	}

}