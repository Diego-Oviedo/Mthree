package com.diego.service.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ImageIcon;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import com.diego.vendingmachine.model.dao.AuditDAO;
import com.diego.vendingmachine.model.dao.DataSourceException;
import com.diego.vendingmachine.model.dao.InventoryException;
import com.diego.vendingmachine.model.dao.vendingMachinePersistenceException;
import com.diego.vendingmachine.model.dao.implementation.AuditDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.InventoryDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.ItemDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.PaymentDAOImpl;
import com.diego.vendingmachine.model.dao.implementation.SaleDAOImpl;
import com.diego.vendingmachine.model.dto.Inventory;
import com.diego.vendingmachine.model.dto.Item;
import com.diego.vendingmachine.model.dto.Sale;
import com.diego.vendingmachine.service.InsufficientFundsException;
import com.diego.vendingmachine.service.InventoryService;
import com.diego.vendingmachine.service.ItemService;
import com.diego.vendingmachine.service.NoItemInventoryException;
import com.diego.vendingmachine.service.PaymentService;
import com.diego.vendingmachine.service.SaleService;
import com.diego.vendingmachine.service.implementation.InventoryServiceImpl;
import com.diego.vendingmachine.service.implementation.ItemServiceImpl;
import com.diego.vendingmachine.service.implementation.PaymentServiceImpl;
import com.diego.vendingmachine.service.implementation.SaleServiceImpl;

@Component("Service_test")
public class VendingMachineServiceTest {

	@Autowired
	@Qualifier("inventory_service")
	private InventoryService test_service_inventory;

	@Autowired
	@Qualifier("item_service")
	private ItemService test_service_item;

	@Autowired
	@Qualifier("sale_service")
	private SaleService test_service_sale;

	@Autowired
	@Qualifier("payment_service")
	private PaymentService test_service_payment;

	@Autowired
	@Qualifier("audit_dao")
	private AuditDAO audit_dao;
	
	public VendingMachineServiceTest() {
		test_service_inventory = new InventoryServiceImpl();
		test_service_item = new ItemServiceImpl();
		test_service_sale = new SaleServiceImpl();
		test_service_payment = new PaymentServiceImpl();
		audit_dao = new AuditDAOImpl("test_");
	}

	@Test
	void testEntryASale() throws DataSourceException, InventoryException, InsufficientFundsException,
			vendingMachinePersistenceException, NoItemInventoryException, IOException {
		// ARRANGE
		String testFile = "src/test/Test_07";
		new FileWriter(testFile);

		Item item_01 = new Item();

		item_01.setSKU("ITM00TST");
		item_01.setItem_description("Test Item");
		item_01.setUnit_price(new BigDecimal("3.68").setScale(2, RoundingMode.UNNECESSARY));
		item_01.setIcon(new ImageIcon("src/main/resources/icons/itemDefault_icon.png"));
		item_01.getIcon().setDescription("itemDefault_icon.png");

		// ACT
		try {
			Inventory inventory = test_service_inventory.createInventory(testFile);

			List<Item> item_added = test_service_item.createItem(item_01, inventory, 5);

			Sale sale_test = new Sale();
			sale_test.setSales_number("SLE0001");
			sale_test.setSales_date(LocalDate.now());
			sale_test.setSold_item(item_01);

			test_service_payment.receivePayment(new BigDecimal("5"), sale_test.getSold_item().getUnit_price());

			test_service_sale.entrySale(inventory, sale_test);

			test_service_inventory.updateInventory();
			
			audit_dao.writeAuditEntry(sale_test.toString());

			//ASSERT
		} catch (DataSourceException | InventoryException | InsufficientFundsException | 
				vendingMachinePersistenceException | NoItemInventoryException | IOException e) {
			
		} catch (Exception e){
			fail("Incorrect exception was thrown.");
		}
	}

}
