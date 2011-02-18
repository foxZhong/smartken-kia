package com.trusteach;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.trusteach.drv.mapper.booked.ILimitInfoMapper;
import com.trusteach.drv.mapper.booked.ILimitMapper;
import com.trusteach.drv.mapper.booked.IWeekRecordMapper;
import com.trusteach.drv.mapper.sys.IDictMapper;
import com.trusteach.drv.model.BookedLimitInfoModel;
import com.trusteach.drv.model.BookedLimitModel;
import com.trusteach.drv.model.BookedWeekRecordModel;
import com.trusteach.drv.model.DictModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SqlSessionFactory _SqlSessionFactory;
		String resource ="mybatis3-local.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			_SqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		    try {
//		    	IWeekRecordMapper iwm= _SqlSessionFactory.openSession().getMapper(IWeekRecordMapper.class);
//		    	ArrayList<BookedWeekRecordModel> bwrs= iwm.selectAll();
//		    	BookedWeekRecordModel bwr=(BookedWeekRecordModel) iwm.selectEqPk(22);
//		        bwr=(BookedWeekRecordModel) iwm.selectEqWeekNum(bwr);
//		        System.out.println(bwrs.size());
		        ILimitMapper<BookedLimitModel> ilm=_SqlSessionFactory.openSession().getMapper(ILimitMapper.class);
		        BookedLimitModel bl=new BookedLimitModel();
		        bl.setWeekNum(46);
		        bl.setDayofweek(4);
		        ArrayList<BookedLimitModel> bls=ilm.select(bl);
		        System.out.print(bls.get(0).toJson());
		        
		        IDictMapper<DictModel> dictMapper=_SqlSessionFactory.openSession().getMapper(IDictMapper.class);
		        DictModel dm=new DictModel();
		        dm.setTypeName("考试场次");
		        ArrayList<DictModel> dms= dictMapper.select(dm);
		        dm.setTypeName("考试地点");
		        dms= dictMapper.select(dm);
		        System.out.println(dms.get(0).toJson().toString());
		        System.out.println(dms.get(0).toUrlParam());
		        Element el=dms.get(0).toXmlElement();
		        System.out.println(el.asXML());
		        Document doc=dms.get(0).toXmlDocucmnt();
		        System.out.println(doc.asXML());
		        BookedWeekRecordModel week=new BookedWeekRecordModel();
		        week.setIWeekNum(52);
		        IWeekRecordMapper<BookedWeekRecordModel> weekMapper=_SqlSessionFactory.openSession().getMapper(IWeekRecordMapper.class);
		        ArrayList<BookedWeekRecordModel> listweek=weekMapper.select(week);
		        System.out.println(listweek.size());
		        ILimitInfoMapper<BookedLimitInfoModel> llm=_SqlSessionFactory.openSession().getMapper(ILimitInfoMapper.class);
		        llm.selectAll();
//		    	for(Iterator<BookedWeekRecordModel> b=bwrs.iterator();b.hasNext();)
//		    	{
//		    		String str=b.next().toJson().toString();
//		    		System.out.println(str);
//		    	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
