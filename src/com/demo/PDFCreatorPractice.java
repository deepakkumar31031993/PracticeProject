package com.demo;

import com.demo.pdf.PDFCreater;
import com.itextpdf.text.Chunk;

public class PDFCreatorPractice {

	static PDFCreater pdfCreator;
	public static void main(String[] args) {
	
	pdfCreator = new PDFCreater("admitCard.pdf");
//	Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	pdfCreator.openPDF();
	String alignment= "CENTER";
	pdfCreator.addHeader(alignment);
	pdfCreator.addNewLine();
	
	pdfCreator.addChunk("ROLL NUMBER");
	pdfCreator.addChunk(String.valueOf(19191919));
	pdfCreator.addNewLine();
	pdfCreator.addCandidateDetails();
/*	pdfCreator.addCandidateDetails("NAMEEELLL", "DEEPAK KUMARRR");
	pdfCreator.addCandidateDetails("NAMEEELLL", "DEEPAK KUMARRR");
	pdfCreator.addCandidateDetails("NAMEEELLL", "DEEPAK KUMARRR");
	pdfCreator.addCandidateDetails("NAMEEELLL", "DEEPAK KUMARRR");
	pdfCreator.addCandidateDetails("NAMEEELLL", "DEEPAK KUMARRR");*/
	pdfCreator.addNewLine();
	pdfCreator.addChunk("NAME");
	pdfCreator.addChunk("\t\t\t"+"DEEPAK KUMAR");
	pdfCreator.addNewLine();
	pdfCreator.addChunk("FATHER'S NAME");
	pdfCreator.addChunk("\t\t\t"+"BHAGWAN SINGH");
	pdfCreator.addNewLine();
	pdfCreator.addChunk("ADDRESS");
	pdfCreator.addChunk("\t\t\t"+"NANGTIHARI");
	pdfCreator.addNewLine();

	//pdfCreator.addImage("D:\\JAVA\\test.jpg");	
	pdfCreator.closeDocument();
		
	}
	
	public static void addHeader() {
		
	}
}
