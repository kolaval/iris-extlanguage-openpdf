package test.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.intersystems.gateway.Service;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ExampleOpenPdf implements Service {
	public static final float MARGIN_BOTTOM = 65f;
	public static final float MARGIN_LEFT = 30f;
	public static final float MARGIN_RIGHT = 25f;
	public static final float MARGIN_TOP = 260f;

	public static Font fontNormal;
	public static Font fontBold;

	private ByteArrayOutputStream pdfStream;
	private PdfWriter pdfWriter;

	@Override
	public byte[] execute(byte[] arg0) throws Throwable {
		// Receive json from IRIS
		String json = new String(arg0, "UTF-8");
		JsonElement jsonTree = new JsonParser().parse(json);
		JsonObject jsonObject = jsonTree.getAsJsonObject();

		// Setup PDF
		fontNormal = new Font(Font.COURIER, 10, Font.NORMAL);
		fontBold = new Font(Font.COURIER, 12, Font.BOLD);

		pdfStream = new ByteArrayOutputStream();
		pdfWriter = null;

		Document document = new Document(PageSize.A4, MARGIN_LEFT, MARGIN_RIGHT, MARGIN_TOP, MARGIN_BOTTOM);
		pdfWriter = PdfWriter.getInstance(document, pdfStream);
		document.open();

		JsonArray companyArray = jsonObject.getAsJsonArray("Companies");
		for (JsonElement companyElement : companyArray) {
			JsonObject company = companyElement.getAsJsonObject();

			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100f);
			table.setWidths(new int[] { 500, 500 });
			PdfPCell cell = new PdfPCell(new Phrase(company.get("Name").getAsString(), fontBold));
			cell.setBorder(Rectangle.BOX);
			cell.setColspan(2);
			table.addCell(cell);

			JsonArray employeeArray = company.getAsJsonArray("Employees");
			for (JsonElement element : employeeArray) {
				JsonObject employee = element.getAsJsonObject();

				cell = new PdfPCell(new Phrase(employee.get("Name").getAsString(), fontNormal));
				cell.setBorder(Rectangle.BOX);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(employee.get("Title").getAsString(), fontNormal));
				cell.setBorder(Rectangle.BOX);
				table.addCell(cell);
			}

			document.add(table);
		}

		if (document.isOpen()) {
			document.close();
		}

		//FileOutputStream fstream;
		//fstream = new FileOutputStream("C:\\deleteme\\example.pdf");
		//fstream.write(pdfStream.toByteArray());
		//fstream.close();

		return pdfStream.toByteArray();
	}

}
