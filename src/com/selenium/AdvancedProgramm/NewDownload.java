package com.selenium.AdvancedProgramm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewDownload {

	static String filename= "";
	static WebDriver driver;
	static boolean isFirstFlag = false;
	static boolean chekingForMaintance = false;
	static int runCount = 1;
	String a;
	
	//Actual PDF path
	static String folder_name_of_downloded_PDF ="";
	
	//Main path
	static String PA_Data_Main_Path="E:\\MyData\\";
	
	/**
	 * set Date for Date Filed Filter
	 * @return nothing 
	 */
	static void setCourtDatadate() throws InterruptedException {	
		
		//get current date
		  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		  Calendar cal = Calendar.getInstance();
		  
		//Date before current date( choose Yesterday date )
		  cal.add(Calendar.DATE, -1);   
		  dateFormat.format(cal.getTime()).toString();		  
		 
		  
		 // click on first Calendar Icon & set value in first date Element 
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_drpFiled_beginDateChildControl_DateTextBox']")).click();
	
		driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_drpFiled_beginDateChildControl_DateTextBox']")).sendKeys(dateFormat.format(cal.getTime()).toString());

		
		 // click on second Calendar Icon & set value in second date Element 
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_drpFiled_endDateChildControl_DateTextBox']")).click();
	
		driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_drpFiled_endDateChildControl_DateTextBox']")).sendKeys(dateFormat.format(cal.getTime()).toString());
	
		
		// Click on Search button
		driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_btnSearch']")).click();
	}
	
	
	
	/**
	 * court data from table
	 * @param fileValue : Filename to write data from table
	 * @param pdfStoragePath : path to Store the downloaded PDF
	
	 * @return nothing 
	 */
	
	static void courtData(String fileValue,String pdfStoragePath) throws InterruptedException, IOException {
		
		       
		//if no records found on some element in place of table 
         if (driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphResults_gvDocket']/tbody/tr/td")) .getText().equalsIgnoreCase("No Records Found")) {
			       
        	      System.out.println("In CourtData1 :No record Found  ");
		
		  } else {
			  
			 // table view container element 
			WebElement table_element = driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphResults_gvDocket']"));
			
			// reading "tr" tag & create list of "tr" tag  
			List<WebElement> tr_collection = table_element.findElements(By.tagName("tr"));

			// loop for reading table row by row using "tr" tag collection 
			for (int j = 1; j < tr_collection.size(); j++) {
				
				// reading "td" tag & create list of "td" tag  
				List<WebElement> td_collection = tr_collection.get(j).findElements(By.tagName("td"));
				
				//
				String data[] = new String [13];	 
				if (td_collection.size() > 14) {
					
					  if(!td_collection.get(10).getText().matches(".*[a-zA-Z]+.*")){
						  
//					System.out.println("Docket no:   	");
					data[0] = td_collection.get(7).getText();
//					System.out.println(a);
					
//					System.out.println("Court office:	");				
					  data[1]= td_collection.get(8).getText();
//					System.out.println(b);				
					
//					System.out.println("Short Caption:	");					
					  data[2]= td_collection.get(9).getText().trim();
//					System.out.println(c);
					
//					System.out.println("Filing Date:	"	);				
					  data[3]= td_collection.get(10).getText();
//					System.out.println(d);
					
//					System.out.println("Country:	");
					  data[4]= td_collection.get(11).getText();
//					System.out.println(e);
					
//					System.out.println("Case Status :	");
					  data[5]= td_collection.get(12).getText().trim();
//					System.out.println(f);
					
//					System.out.println("Primary Participent :	");
					 String s = td_collection.get(13).getText();
//					System.out.println(g);
					  
					 // first name,middle name,last name from data[8] which contains space & comma as delimiter
					 if(s.contains(","))
					 {
						 String[] name = s.split(",") ;
						  data[8]= name[0].trim();
						  if(name.length!=1)
						  {
							if(name[1].trim()!=null){
								String[] remName = name[1].trim().split(" ");
								if (remName.length >= 3) {
									data[6]= remName[0]; 

									if(remName.length == 3){
										data[7]= remName[1] + " " + remName[2];
									}
									else {
										data[7]= remName[1] + " " + remName[2]+" "+ remName[3];
									}
								}
								else if (remName.length == 2) {
									data[6]= remName[0];
									data[7]= remName[1];
								}
								else if (remName.length == 1) {
									data[6]= remName[0];
									data[7]= "";
								}
								else{
									data[6]= "";
									data[7]= "";
								}
							}
							else {
								data[6] = "";
								data[7] = "";
							}
						  }
						  else{
							  data[6] = "";
								 data[7] = "";
								 data[8]= s;
								
						  }
					 }
					 else{
						 data[6] = "";
						 data[7] = "";
						 data[8]= s;
					 }
				
				if (td_collection.size() >= 17) {
					
//					System.out.println("OTN no :		");
					data[9] = td_collection.get(15).getText();
//					System.out.println(h);
				}
				if (td_collection.size() >= 18) {
					
//					System.out.println("lOTN no :		");
					data[10]= td_collection.get(16).getText();
//					System.out.println(i1);
				}
				if (td_collection.size() >= 19) {
					
//					System.out.println("cOMPLAINT NO 	");
					data[11]= td_collection.get(17).getText().trim();
				}
				if (td_collection.size() >= 21) {
					
//					System.out.println("dob :		");
					data[12]= td_collection.get(19).getText();
				}
			
				/*When to download PDF and write record in to file 
				 * conditions :
				 * 1) Short Caption start with "Comm." 
				 * 2) Case Must be Active
				 * 3) Complaint number should not be blank*/
				
				System.out.println("Docket Number:"+data[0]);
				if(data[2].contains("Comm.") &&  data[5].equalsIgnoreCase("Active") && !data[11].equals(""))
				{
					fileAppend(fileValue, data);
					
		             String fileName = pdfStoragePath+""+td_collection.get(7).getText()+".pdf";
		     	
		             // creating URL to download PDF  with attaching DocketNumber from collected data from table
		     		URL link = new URL("https://ujsportal.pacourts.us/DocketSheets/MDJReport.ashx?docketNumber="+td_collection.get(7).getText()); 
		     		
		     		// Download PDF function
		     		pdfDownload(fileName,link);
				}
												  
					  }  //Inner If "td"
			   }   //Outer if "tr"
			}//For loop      
		} //Else part records Found
	}// Method ends

	

	/**
	 * Writing file
	 * @param fileNameToWrite : fileName
	 * @return fileNameToWrite :filename
	 */
	
	static String createFile(String fileNameToWrite){
			
		// create csv format file column name as  
		 String titles[] = {"Docket Number","Court Office","Short Caption","Filing Date","County","Case Status","First_Name","Middle_Name","Last_Name","OTN","LOTN",
				              "Police Incident/ Complaint Number","Date of Birth"};
		
		String s1 = "";
		//set header to column
		for (int h = 0; h < titles.length; h++) {

			s1 = s1 + titles[h] + ";";
		}

		FileWriter writer;
		try {
			writer = new FileWriter(fileNameToWrite, true);
			writer.append(s1 + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Exception In createFile ");
			
			// e.printStackTrace();
		}

		return fileNameToWrite;
	 }
	
	

	/**
	 * Append file
	 * @param fileName : fileName
	 * @return data[] all values which fetched
	 */
	static void fileAppend(String fileName, String data[]) {
		// use to append data in file
		String s = "";

		for (int h = 0; h < data.length; h++) {

			s = s + data[h] + ";";
		}

		FileWriter writer;
		try {
			writer = new FileWriter(fileName, true);
			writer.append(s + "\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("Exception in fileAppend");
			
			// e.printStackTrace();
		}
	}
	
	/**
	 * Append file
	 * @param fileName : fileName to save with name
	 * @return URL link : Url to download file
	 */
	static void pdfDownload(String fileName,URL link) throws IOException{	
		
		// without opening in browser download the file and save at specified location with specified( Docket Number.pdf) name
		
			InputStream in = new BufferedInputStream(link.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			byte[] response = out.toByteArray();

			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(response);
			fos.close();
			// End download code

			System.out.println("Pdf Downloded Finished");

		
	}

	/**
	 * Fetching Data from web portal
	 * @param startFrom : County number 
	 * @param countyDirectoryPath : path to Store the downloaded PDF
	 * @param fileDate : Directory name where Store the downloaded PDF 
	 * @return nothing 
	 */
	public static void getDataFromWeb(int startFrom,String countyDirectoryPath,String fileDate) {
		
		// store county number to start from 
		int startcounty = startFrom;	 	
		
		try {
			
			// script fails at any county i.e. "startFrom" 
			// OR 
			//if at first county then "isFirstFlag=true"
			
			if(startFrom > 31 || isFirstFlag )
		    {
				// this block execute to resume script from that county where stuck.  
				
				// Print the message  in log file
				System.out.println("Driver Reload");
				
				//closing previously opened driver
				driver.close();
				
				// open the driver to run load site & download records
				driver = new FirefoxDriver();
				
				// to maximize browser window.
				driver.manage().window().maximize() ;
				
				// load URL in opened driver / browser
			    driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJ.aspx");	
			    
			    // to wait till data load on page
				Thread.sleep(20000);
		    }
			
			// script runs first time 
			if(startFrom==31 && !isFirstFlag)
			{
				// this block execute to script first time.  
				
				// open the driver to run load site & download records
				driver = new FirefoxDriver();
				
				// to maximize browser window.
				driver.manage().window().maximize() ;
				
				// load URL in opened driver / browser
			    driver.get("https://ujsportal.pacourts.us/DocketSheets/MDJ.aspx");	
			    
			    // to wait till data load on page
				Thread.sleep(20000);
			}
			
//			to select element of Search Type by using firePath
			Select select = new Select(driver.findElement(By.xpath("//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_ddlSearchType']")));
			
//			to set element value Search Type:Date Filed 
			select.selectByIndex(1);

//			time to wait till set the value of search type & load the complete page
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
			
//			to select element of County by using firePath of County
			Select select1 = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_ddlCounty']")));
			
//			list of county
			List<WebElement> county = select1.getOptions();

//			total number of county 
//			int countySize = county.size()-36;//for first 30 county
			int countySize = county.size();//for first 30 county
			
			
			// loop for county wise data fetching with startFrom value
			for (int combo1 = startFrom ; combo1 < countySize ; combo1++) {
				System.out.println("County number going to Fetch : "+combo1);
				
				//maintain county number to resume script if stuck at any county while running
				startcounty = combo1;
				
				//current county  PDF Storage directory path like county first "1"
		    	String countyStoragePath = countyDirectoryPath+""+combo1+"/pdf_storage/";
		    	
		    	//create directory of specified path
		    	createDirectory(countyStoragePath);	
		    	
				//create .csv file to store table viewed record for that county 
		    	String countyDocketWebfile = countyDirectoryPath +""+combo1+"/"+ fileDate + ".csv";
		    	String fileValue = createFile(countyDocketWebfile);
						
		    	//set value of county to element "County" from list
				Select select4 = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_ddlCounty']")));
				
				// current county list item set to county dropdown 
				select4.selectByIndex(combo1);

				//wait till load the Court Office
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(20000);

				//to select element of Court Office by using firePath of Court Office
				Select select2 = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_ddlCourtOffice']")));
				
				//getting list of Court Office
				List<WebElement> e = select2.getOptions();

				
				// loop for court Office for that county
				for (int combo = 1; combo < e.size(); combo++) {
					
					//to select element of Court Office by using firePath of Court Office
					Select select3 = new Select(driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphSearchControls_udsDateFiled_ddlCourtOffice']")));
					
					//set Court Office from Court_Office list
					select3.selectByIndex(combo);					
					Thread.sleep(1000);
					
					// set Date Filed in date search field
					setCourtDatadate();

					//result of search Filter "No Records Found" Element
					if (driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ctl00_cphMain_cphDynamicContent_cphResults_gvDocket']/tbody/tr/td")).getText().equalsIgnoreCase("No Records Found")) {
						System.out.println("In Main : No record Found  ");

					} else {
						//result of search Filter if record found in table view
						
						//Read table considering 100 Rows
						for (int k = 0; k < 100; k++) {
							System.out.println("Value of K="+k);
							
							// Select the table by using cssSelector element  
							WebElement page1 = driver.findElement(By.cssSelector(".PageNavigationContainer"));
							
							//list of div element count 
							List<WebElement> pageno1 = page1.findElements(By.tagName("div"));

							System.out.println("pageno1.size() "+pageno1.size());
							if (pageno1.size() != 0) {
								System.out.println("else pageno.size>0)");
								
								// Select the page by using cssSelector element  under div tag
								WebElement page = driver.findElement(By.cssSelector(".PageNavigationContainer"));
								
								// Select the "a" tag under div tag
								List<WebElement> pageno = page.findElements(By.tagName("a"));

								try {
									// if next page disable check
									if (pageno.get(pageno.size() - 2).getAttribute("disabled").matches("disabled")) {

										// to read the data of particular table page 
										courtData(fileValue,countyStoragePath);
									} else {
										// to read the data of particular table page 
										courtData(fileValue,countyStoragePath);
										break;
									}

								} catch (Exception ex) {
									
									System.out.println("Exception In Table rows  For loop ");
									
									// for last page record 
									courtData(fileValue,countyStoragePath);
									pageno.get(pageno.size() - 2).click();
									Thread.sleep(15000);

								}// catch

							} else {
								// no pagination Single block of record i.e  size:10 
								
								System.out.println("else pageno.size==0)");
								
								
								// to read the data of particular table page 
								courtData(fileValue,countyStoragePath);
								break;
							}
						} // loop of K Table rows
					}
				}
				runCount = 0;
			}

		} catch (Exception e) {
			//lot of to do
			e.printStackTrace();
			System.out.println("Exception In getDataFromWeb *******");
			
			
			// if at the start of script exception occurs then start script from same position i.e county number = 1
    		if(startcounty == 31)
    			isFirstFlag = true;
    		
			
			runCount++;
			/* If Site stuck at or not responding due to maintenance then we put in side thread before that we delete current county directory with downloaded records */
			if(runCount==1)
			{
				//delete existing folder of county
				String deleteDir = countyDirectoryPath+""+startcounty;
				System.out.println("File Going to delete :"+deleteDir);
				File file = new File(deleteDir);
				
				try {
					if(file.exists())
					delete(file);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				try {
	    			
	    			// till the site response wait and again hit to site from current county     			
	    			System.out.println("in side thread sleep");
					Thread.sleep(900000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				getDataFromWeb(startcounty,countyDirectoryPath,fileDate);
			}
			
			
			
    		
			//recall method startCounty
    		if(runCount==2)
    		{
    			if(!chekingForMaintance)
    			{
    				chekingForMaintance = true;
        			startcounty = startcounty+1;
        			runCount = 0;
        			getDataFromWeb(startcounty,countyDirectoryPath,fileDate);
    			}
    			else{
    				startcounty = startcounty-1;
    				runCount = 2;
    				chekingForMaintance = false;
        			getDataFromWeb(startcounty,countyDirectoryPath,fileDate);
    			}
    		}
    		if (runCount > 2){
    			//delete existing folder of county
				String deleteDir = countyDirectoryPath+""+startcounty;
				System.out.println("File Going to delete :"+deleteDir);
				File file = new File(deleteDir);
				
				try {
					if(file.exists())
					delete(file);
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				try {
					String fileCreatedDate = fileDate.replaceAll("_", "/");
	    			// till the site response wait and again hit to site from current county     			
	    			System.out.println("in side thread sleep");
					Thread.sleep(900000);
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch b lock
					e1.printStackTrace();
				}
				
				getDataFromWeb(startcounty,countyDirectoryPath,fileDate);
    		}
    		
		}
	}
	/**
	 * create directory with provided path 
	 * @param strDirectoy : County number 
	 * @return boolean: directory created true else false 
	 */
		//create directory with provided path 
	public static boolean createDirectory(String strDirectoy) {
		boolean success = false;
		File file = new File(strDirectoy);
		if(file.exists()){
			success = true;
		}else{
			file.mkdirs();
			success = true;
			System.out.println("Directory: " + strDirectoy + " created");
		}
		return success;
	}
		
	/**
	 * delete directory with provided path 
	 * @param File : file object to delete(complete directory delete with internal directory also)
	 * @return boolean: directory created true else false 
	 */
	 public static void delete(File file)
		    	throws IOException{
		 
		    	if(file.isDirectory()){
		 
		    		//directory is empty, then delete it
		    		if(file.list().length==0){
		 
		    		   file.delete();
//		    		   System.out.println("Directory is deleted : " + file.getAbsolutePath());
		 
		    		}else{
		 
		    		   //list all the directory contents
		        	   String files[] = file.list();
		 
		        	   for (String temp : files) {
		        	      //construct the file structure
		        	      File fileDelete = new File(file, temp);
		 
		        	      //recursive delete
		        	     delete(fileDelete);
		        	   }
		 
		        	   //check the directory again, if empty then delete it
		        	   if(file.list().length==0){
		           	     file.delete();
//		        	     System.out.println("Directory is deleted : " + file.getAbsolutePath());
		        	   }
		    		}
		 
		    	}else{
		    		//if file, then delete it
		    		file.delete();
//		    		System.out.println("File is deleted : " + file.getAbsolutePath());
		    	}
		    }
	
	
	
	 /**
		 * main
		 * @return nothing
		 */
		
	public static void main(String[] args) {	
		
		try {
			
			//Reading  properties file ( Config.proprties )
			//Properties prop = Utils.getReadFilePath();
			
			//getting storage/file path from Properties files
	//	PA_Data_Main_Path = prop.getProperty("PA_Data_Main_Path");
			
			// create file object for particular path
			File directory = new File(PA_Data_Main_Path);    
			
			if(!directory.exists()){
				 
		           System.out.println("Directory does not exist.");
		           
		        }else{
		        	
		        	//delete directory if exists 
		        	 delete(directory);

		        }
			
			//create  directory
			createDirectory(PA_Data_Main_Path);

			System.out.println("Started DataFetching");
        	
			//get current date (MM_dd_yyyy)
			DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 0); 
			String fileDate = dateFormat.format(cal.getTime()).toString();
			
			
			folder_name_of_downloded_PDF = fileDate.trim();
			
			//create current date  directory like "MM_dd_yyyy"
			String countyDirectoryPath = PA_Data_Main_Path+""+folder_name_of_downloded_PDF+"/";
			
	    	//create current date  directory
	    	boolean isFileCreated = createDirectory(countyDirectoryPath); 	
	    	
	    	if(isFileCreated)
	    	{
	    		
	    		
//	    		fetching Data from PA site
	    		getDataFromWeb(31,countyDirectoryPath,fileDate); 
	    	}    	
	    	
	    	// Insert into DB after success of script for decision to run other script or shoot the mail if failure script 
	    	Connection con = null;
	    //	con = DBConnection.createConnection();  
	    	
	    	       
			System.out.println("EveryThing Finished");
			
//			after finished script need to close the driver
			driver.quit();
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception In Main ");
			
		}
	}//main End
}