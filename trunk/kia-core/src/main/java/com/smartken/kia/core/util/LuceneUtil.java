package com.smartken.kia.core.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class LuceneUtil {

	public static void main(String[] args){
		Date startDate=new Date();
		try {
			IndexWriter indexWriter=new IndexWriter("d:\\indexDir", new SimpleAnalyzer(), true);
		    File file=new File("d:\\indexData.txt");
		    Document document=new Document();
		    Field field=new Field("xxx","gagda",true,true,true);
		    document.add(field);
		    indexWriter.addDocument(document);
		    indexWriter.optimize();
		    indexWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
