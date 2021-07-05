package com.diego.vendingmachine.view;

import java.math.BigDecimal;
import java.util.*;

import javax.swing.ImageIcon;

import com.diego.vendingmachine.model.dto.*;

public interface vendingMachineView {
	
	public Item displayStock (Inventory inventory);
	
	public int printOutOfStock();
	
	public BigDecimal printReceivePayment(Item item_selected);
	
	public int printRefund(BigDecimal refund,Item item_selected);
	
	public int printCloseSale(Sale sale,Map<String, BigDecimal> change);
	
	public int print(String label, String msg);
	
	public int print(String label, String msg, ImageIcon icon);
	
	public int readInt(String label, String prompt);

	public int readInt(String label, String prompt, int min, int max);
	
	public String readString(String label, String prompt);

	public String readString(String string, String string2, ImageIcon icon);

}
