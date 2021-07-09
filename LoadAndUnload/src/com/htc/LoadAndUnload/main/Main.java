package com.htc.LoadAndUnload.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.htc.LoadAndUnload.DAO.ProductInterfaceImpl;

public class Main 
{
	public static void main(String[] args) throws SecurityException, FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		ProductInterfaceImpl impl = new ProductInterfaceImpl();
		
		impl.readFileFromFile();
		
		System.out.println("Load Operation Done!!");
		
		
	}
}
