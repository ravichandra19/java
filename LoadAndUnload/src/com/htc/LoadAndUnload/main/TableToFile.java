package com.htc.LoadAndUnload.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.LoadAndUnload.dbconnection.DBConnector;
import com.htc.LoadAndUnload.entity.Product;

public class TableToFile 
{
	public static void main(String[] args) throws SQLException, IOException 
	{
		ArrayList<Product> prds = new ArrayList<>();
		Connection con = DBConnector.getConnection();
		Statement stmt = con.createStatement();

		ResultSet rs = stmt
				.executeQuery("SELECT prod_id, name, price, type FROM Product");
		while (rs.next()) {
			prds.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),rs.getString(5)));
		}

		System.out.println(prds);

		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet spreedsheet = wb.createSheet("Product");
		FileOutputStream fos = new FileOutputStream("Product.xlsx");
		XSSFRow row;
		int rowno = 0;
		int cellno = 0;

		row = spreedsheet.createRow(rowno);
		Cell cell = row.createCell(cellno);

		cell = row.createCell(cellno);
		cell.setCellValue("ProductId");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("ProductName");
		cellno++;

		cell = row.createCell(cellno);
		cell.setCellValue("ProductPrice");
		cellno++;

		

		cell = row.createCell(cellno);
		cell.setCellValue("ProductType");
		cellno++;
		rowno++;

		for (Product val : prds) {
			row = spreedsheet.createRow(rowno);

			cellno = 0;
			cell = row.createCell(cellno);
			cell.setCellValue(val.getProductId());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(val.getProductName());
			cellno++;

			cell = row.createCell(cellno);
			cell.setCellValue(val.getProductPrice());
			cellno++;

			

			cell = row.createCell(cellno);
			cell.setCellValue(val.getProductType());
			cellno++;

			rowno++;

		}

		wb.write(fos);

		fos.close();
		System.out.println("Excel File Created!!");
	}
}
