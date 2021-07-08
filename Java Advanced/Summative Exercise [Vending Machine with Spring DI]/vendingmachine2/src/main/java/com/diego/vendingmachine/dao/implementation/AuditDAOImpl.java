package com.diego.vendingmachine.dao.implementation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.diego.vendingmachine.dao.AuditDAO;
import com.diego.vendingmachine.dao.DataSourceException;
import com.diego.vendingmachine.dao.vendingMachinePersistenceException;

@Component("audit_dao")
public class AuditDAOImpl implements AuditDAO {

	public void writeAuditEntry(String entry) throws vendingMachinePersistenceException, DataSourceException {
		PrintWriter out = null;
		LocalDateTime timestamp = LocalDateTime.now();
		String date = timestamp.getYear() + "-" + timestamp.getMonth() + "-" + timestamp.getDayOfMonth() + " @"
				+ timestamp.getHour() + ":" + timestamp.getMinute() + ":" + timestamp.getSecond();
		String path = "src/main/resources/Audits/";

		try {
			out = new PrintWriter(new FileWriter(path + "AUDIT" + timestamp.getYear() + "-" + timestamp.getMonth() + "_"
					+ timestamp.getHour() + "H" + timestamp.getMinute() + "M" + ".txt", true));

			out.println(date + " -> " + entry);
			out.flush();
			out.close();

		} catch (IOException e) {
			throw new DataSourceException("Error when writting the audit [ERROR WITH FILE] [DAO layer]", e.getCause());
		} catch (Exception e) {
			throw new vendingMachinePersistenceException("Error when writting the audit [ERROR PERSISTING OBJECT]",
					e.getCause());
		}
	}

}
