package DDT;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFCellStyle;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class XLUtils 
	{
		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static XSSFCellStyle style;
		
		
		
		public static int getRowCount(String xlfile,String xlsheet) throws IOException 
		{
			int rowcount;
			fi=new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			rowcount = ws.getLastRowNum();
			wb.close();
			fi.close();
			return rowcount;	
		}
		public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
		{
			int cellcount;
			fi= new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row =  ws.getRow(rownum);
			cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
			
		}
		public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
		{
			String data;
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			try 
			{
				data = cell.getStringCellValue();
				return data;
				
			} catch (Exception e) {
				data="";
				return data;
			}
		}
			
		public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
		{
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.createCell(colnum);
			cell.setCellValue(data);
			
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			fi.close();
			fo.close();
				
		}
		public static void fillGreenColour(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			style = wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			
			fo=new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		public static void fillRedColour(String xlfile,String xlsheet,int rownum,int colnum) throws IOException 
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			style = wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		
		}
			
	}
