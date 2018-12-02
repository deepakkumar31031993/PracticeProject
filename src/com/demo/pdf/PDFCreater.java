package com.demo.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFCreater {
	
	private static String pdfFile;
	private static Document document;
	private static PdfWriter pdfWriter;
	
	public PDFCreater(String filename) {
		pdfFile = filename;
	}
	
	public void openPDF() {
		
		try {
			document = new Document();
			pdfWriter=PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
			document.open();
			System.out.println("pdf Docuement opened");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public void addChunk(String text) {
	
		addToDocument(new Chunk(text));
	}
	
	public void addChunk(String text, Font font) {
		Chunk chunk = new Chunk(text, font);
		addToDocument(chunk);
		
	}
	
	public void addNewLine() {
		addToDocument(new Paragraph("\n"));
	}
	public void addImage(String imageFilePath) {
		try {
 			System.out.println("image file path " + imageFilePath);
 			//Path path = Paths.get(imageFilePath.toURI());
			//Path path = Paths.get(ClassLoader.getSystemResource(imageFilePath).toURI());
			Image img = Image.getInstance(imageFilePath);
			addToDocument(img);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	
	public PdfPCell getCell(Chunk text, int alignment) {
	    PdfPCell cell = new PdfPCell(new Phrase(text));
	    cell.setPadding(0);
	    cell.setHorizontalAlignment(alignment);
	    cell.setBorder(PdfPCell.NO_BORDER);
	    //cell.setBorder(PdfPCell.BOX);
	    return cell;
	}
	public void addCandidateDetails() {
		 PdfPTable table = new PdfPTable(3);
		 table.setWidthPercentage(100);
		 table.setHorizontalAlignment(Element.ALIGN_LEFT);
		 try {
				table.setTotalWidth(new float[]{2,3,2});
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// the cell object
        PdfPCell cell;
        cell = getCell(new Chunk("Name : "), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("DEEPAK"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell= getCell(new Chunk("").setUnderline(0.5f, -1), Element.ALIGN_LEFT);
        cell.setBorder(PdfPCell.BOX);
        cell.setRowspan(7);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("ROLL Nu"), Element.ALIGN_LEFT);
        table.addCell(cell);
        cell=getCell(new Chunk("323323hdkshdkshkshdskhdshdsdbdsjdls\njdsljlsjsljd\ndjskldjsdj\n "), Element.ALIGN_LEFT);
        table.addCell(cell);
        addToDocument(table);
	}
	/*public void addCandidateDetails(String key, String value) {
		 PdfPTable table = new PdfPTable(2);
		 table.setWidthPercentage(50);
		 table.setHorizontalAlignment(Element.ALIGN_LEFT);
		 try {
			table.setTotalWidth(new float[]{1,2 });
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        // the cell object
	        PdfPCell cell;
	        cell = new PdfPCell(new Phrase(key+" : "));
	        cell.setPadding(0);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        table.addCell(cell);
	        cell = new PdfPCell(new Phrase(value));
	        cell.setPadding(0);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        table.addCell(cell);
	       
	        addToDocument(table);
	}*/
	public void addText(Chunk text, String alignment) {
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(100);
		if(alignment.equalsIgnoreCase("LEFT")) {
			table.addCell(getCell(text, PdfPCell.ALIGN_LEFT));
		}else if(alignment.equalsIgnoreCase("RIGHT")) {
			table.addCell(getCell(text, PdfPCell.ALIGN_RIGHT));
		}else if(alignment.equalsIgnoreCase("CENTER")) {
			System.out.println("center alignmetnt");
			table.addCell(getCell(text, PdfPCell.ALIGN_CENTER));
		}
		addToDocument(table);
		
	}
	public void addHeader(String alignment)  {
		Chunk chunk = new Chunk();
		chunk.setUnderline(0.5f, -1);
		addText(new Chunk("E- ADMIT CARD").setUnderline(1.5f, -1), alignment);
		addText(new Chunk("SSB").setUnderline(1.5f, -1), alignment);
		addText(new Chunk("RECRUITMENT").setUnderline(1.5f, -1), alignment);
		
	}
	
	public void addToDocument(Element element) {
		try {
			document.add(element);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	public void closeDocument() {
		document.close();
		System.out.println("document closed..!!");
	}

	
}
