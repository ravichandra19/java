package com.htc.LoadAndUnload.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.LoadAndUnload.dbconnection.DBConnector;
import com.htc.LoadAndUnload.entity.Product;

public class ProductInterfaceImpl implements ProductInterface
{

	@Override
	public void readFileFromFile() throws IOException, SQLException 
	{
		
		File file = new File("C:\\Users\\ravichandra\\Documents\\Product.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0); 
		Iterator<Row> itr = sheet.iterator();
		Row row = itr.next();
		int insert_table_counter = 0;
		int read_file_counter = 0;
		while (itr.hasNext()) 
		{
			row = itr.next();
			Iterator<Cell> cellIterator = row.cellIterator(); 
			while (cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				int ProductId = (int) cell.getNumericCellValue();

				cell = cellIterator.next();
				String Productname = cell.getStringCellValue();

				cell = cellIterator.next();
				double ProductPrice = cell.getNumericCellValue();
				cell = cellIterator.next();
				String ProductType = cell.getStringCellValue();

				Product obj = new Product(ProductId, Productname, ProductPrice, ProductType);

				insertToTable(obj);
			}
			// System.out.println("");
		}
	}

	  @Override
   public boolean insertToTable(Product obj) throws SQLException, IOException 
	{
		boolean status = false;

		Connection con = DBConnector.getConnection();

		
		PreparedStatement ps = con.prepareStatement(
				"INSERT INTO product(prod_id, name, price, type) VALUES(?,?,?,?)");

		ps.setInt(1, obj.getProductId());
		ps.setString(2, obj.getProductName());
		ps.setDouble(3, obj.getProductPrice());
		
		ps.setString(4, obj.getProductType());
		status = !ps.execute(); 
		return status;
	}
		
		
	

}
