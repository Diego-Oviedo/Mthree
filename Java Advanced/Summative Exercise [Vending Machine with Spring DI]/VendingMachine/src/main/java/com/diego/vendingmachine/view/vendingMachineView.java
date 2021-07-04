package com.diego.vendingmachine.view;

import java.util.*;
import com.diego.vendingmachine.model.dto.*;

public interface vendingMachineView {
	
	public void print(String label, String msg);
	
	public int readInt(String label, String prompt);

	public int readInt(String label, String prompt, int min, int max);
	
	public String readString(String label, String prompt);
	
	public Item displayMultipleObjects (String prompt,String label,Inventory inventory);

}
