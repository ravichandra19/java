package com.htc.LoadAndUnload.DAO;

import java.io.IOException;
import java.sql.SQLException;

import com.htc.LoadAndUnload.entity.Product;

public interface ProductInterface
{
	

		public void readFileFromFile() throws IOException, SQLException;
		public boolean insertToTable(Product obj) throws SQLException, IOException;

}
