package distatest;
import org.testng.annotations.Test;
import basepckg.Basecls;
import distpage.Distapagecls;
import utilies.Excelutilies;


public class Distatestcls extends Basecls {
	
	@Test(priority=1)
	public void hpop() throws Exception 
	{
		
		 obj=new Distapagecls(driver);
		 obj.closePopup();
	     obj.loginpage();
		
		String xl=("C:\\Users\\Shilpa\\Desktop\\Selenium_Works\\Autoprojectdatadriven.xlsx");
		String Sheet="Login";
		int rowcount=Excelutilies.getRowCount(xl,Sheet);

	    for(int i=1;i<=rowcount;i++)
		{
			String UserName=Excelutilies.getCellValString(xl,Sheet,i,0);
			System.out.println("username----" +UserName);
			
			String Pwd=Excelutilies.getCellValString(xl,Sheet,i,1);
			System.out.println("password----"+Pwd);
			
			driver.get("https://www.distacart.com/account/login");
			
			obj.login(UserName,Pwd);
			
			String expecturl="https://www.distacart.com/account/login";
			String actualurl=driver.getCurrentUrl();
			
			if(actualurl.equals(expecturl))
			{
				System.out.println("Login failed");
	
			}
			
			else
			{
				System.out.println("Login successful");
			}
		}
	      obj.homepage();
	      obj.addtocartpage();
	      obj.checkoutpage();
	      obj.deliverydetails("Maria","Deo","RoseDale hguiol","Dublin","24467","345677900005");
	      obj.logoutpage();
	      obj.contactuspage();			
	}
	}
	
	
	
	


