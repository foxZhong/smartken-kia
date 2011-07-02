package com.smartken.kia.core.util;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import org.bson.BSON;
import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class MongodbUtil {

	
	public static void main(String[] args){
		try {
			Mongo mongo=new Mongo("127.0.0.1");
			DB db= mongo.getDB("test");
			DBCollection dbCollection= db.getCollection("kia");
			DBObject dbObject=new BasicDBObject();
		
			dbObject.put("_id", "hhlin");
			dbObject.put("name", "hhlin");
			dbObject.put("birthday", new Date());
			dbObject.put("age", 28);
			try {
				byte[] bs=FileUtil.toBytes("h:\\test.jpg");
				dbObject.put("photo", bs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dbCollection.save(dbObject);
		
			//dbCollection.remove(new BasicDBObject());
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
