package com.smartken.kia.core.test;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class MengoDBTestCase {

	
	public static void main(String[] args){
		MongoURI uri=new MongoURI("");
		try {
			Mongo mongo=new Mongo();
			DB db=mongo.getDB("xxx");
			DBCollection dc=db.getCollection("");
			DBCursor dcr= dc.find();
			while(dcr.hasNext()){
				DBObject dbo= dcr.next();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
