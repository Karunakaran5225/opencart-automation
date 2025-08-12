package com.opencart.dataprovider;

import org.testng.annotations.DataProvider;

import com.opencart.utility.NewExcelLibrary;

public class DataProviders {
//
//		NewExcelLibrary obj= new NewExcelLibrary();
////		@DataProvider(name = "<Dp Name>")
//		@DataProvider(name = "credentials")
//		public Object[][] getcredentials() {
//		    // Total rows count
//		    int rows = obj.getRowCount("<Credentials>");
//		    
//		    // Total columns count
//		    int columns = obj.getColumnCount("<Credentials>");
//		    
//		    int actRows = rows -1; // excluding header row
//		    
//		    Object[][] data = new Object[actRows][columns];
//		    
//		    for (int i = 0; i < actRows; i++) {
//		        for (int j = 0; j < columns; j++) {
//		            data[i][j] = obj.getCellData("<Credentials>", j, i + 2);
//		        }
//		    }
//		    
//		    return data;
//		}
//
//
//	}
//
	NewExcelLibrary obj= new NewExcelLibrary();
@DataProvider(name = "credentials")

public Object[][] getCredentials() {
    String sheetName = "Credentials"; // actual sheet name
    int rows = obj.getRowCount(sheetName);
    int columns = obj.getColumnCount(sheetName);

    if (rows <= 1 || columns <= 0) {
        System.out.println("No valid data found in sheet: " + sheetName);
        return new Object[0][0]; // avoids NegativeArraySizeException
    }

    int actRows = rows - 1; // excluding header row
    Object[][] data = new Object[actRows][columns];

    for (int i = 0; i < actRows; i++) {
        for (int j = 0; j < columns; j++) {
            data[i][j] = obj.getCellData(sheetName, j, i + 2);
        }
    }
    return data;
}
}
