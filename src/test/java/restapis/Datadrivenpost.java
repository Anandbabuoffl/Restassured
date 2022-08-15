package restapis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Datadrivenpost {

	@Test(dataProvider="Data")
	public void postdata(String Empolyee) {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		
		JSONObject jo=new JSONObject();
		jo.put("Title",Empolyee);
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(jo.toJSONString())
		.post("/posts/create")
		.then()
		.statusCode(404);
	}
	
	@DataProvider(name="Data")
	public Object[][] getdata() throws FileNotFoundException {
		File file=new File("");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet= wb.getSheet("Sheet1");
		int rowcount=sheet.getPhysicalNumberOfRows();
        int column=sheet.getRow(0).getPhysicalNumberOfCells();
        
		Object getde[][]= new Object[rowcount][column];
		
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<=column;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()); 
			}
		}
		return (getde);
	}
}
