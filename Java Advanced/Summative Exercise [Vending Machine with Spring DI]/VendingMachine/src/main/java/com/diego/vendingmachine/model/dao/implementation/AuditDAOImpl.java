package com.diego.vendingmachine.model.dao.implementation;

import com.diego.vendingmachine.model.dao.AuditDAO;
import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.vendingMachinePersistenceException;
import java.io.*;
import java.time.*;

import org.springframework.stereotype.Component;

@Component("audit_dao")
public class AuditDAOImpl implements AuditDAO {
	 
	public static final String AUDIT_FILE = "audit.txt";

	public void writeAuditEntry(String entry) throws vendingMachinePersistenceException,DataSourceException{
		PrintWriter out = null;
		LocalDateTime timestamp = LocalDateTime.now();
		String path = "src/main/resources/Audits/";

		try { 
		    out = new PrintWriter(new FileWriter(path + timestamp.getYear()+"-"+ timestamp.getMonth()+"_"+timestamp.getHour()+"H"+ timestamp.getMinute()+"M_"+AUDIT_FILE, true));
		} catch (Exception e) {
			if(!e.equals(IOException.class)) {
				throw new DataSourceException("Issue when writting the audit [ERROR WITH FILE]", e.getCause());
			}
			throw new vendingMachinePersistenceException("Issue when writting the audit [ERROR PERSISTING OBJECT]", e.getCause());
		}
		String date = timestamp.getYear()+"-"+
					  timestamp.getMonth()+"-"+
					  timestamp.getDayOfMonth()+" @"+
					  timestamp.getHour() +":"+
					  timestamp.getMinute()+":"+
					  timestamp.getSecond();
		
		out.println(date + " -> " + entry);
		out.flush();
		}

}
