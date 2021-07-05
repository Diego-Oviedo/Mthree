package com.diego.vendingmachine.view;

import java.util.*;

import javax.swing.ImageIcon;

import com.diego.vendingmachine.model.dto.*;

public interface vendingMachineView {
	
	public int print(String label, String msg);
	
	public int printOutOfStock();
	
	public int print(String label, String msg, ImageIcon icon);
	
	public int readInt(String label, String prompt);

	public int readInt(String label, String prompt, int min, int max);
	
	public String readString(String label, String prompt);
	
	public Item displayMultipleObjects (String prompt,String label,Inventory inventory);

	public String readString(String string, String string2, ImageIcon icon);

}
