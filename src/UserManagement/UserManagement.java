package UserManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class UserManagement {


	static ArrayList<User> al = new ArrayList();
	static
	{
		try {
			loadDataFromFileToArrayList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void userManagement() throws IOException {
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true )
		{
			System.out.println(" ******WELCOME TO USER MANAGMENT** ");
			System.out.println(" 1.Add User ");
			System.out.println(" 2.Edit User ");
			System.out.println(" 3.Delete User ");
			System.out.println(" 4.Search User ");
			System.out.println(" 5.Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			if(optionselectedbyuser == UserOptions.QUIT)
			{
				File file = new File("C:\\Users\\NIKITA HAJARE\\nikita-eclipse-workspace\\___TO DO LIST___\\src\\To Do.txt");
				
				FileWriter fr = new FileWriter(file,false);
				
				BufferedWriter br = new BufferedWriter(fr);
				
				for(User u1:al)
				{
					br.write(u1.Username+","+u1.LoginName+","+u1.Password+","+u1.UserRole+"\n");
				}
				br.close();
				file = null;
				System.out.println(" !!!! PROGRAM CLOSED !!!! ");
				CanIKeepRunningTheProgram = false;
			}
			else if(optionselectedbyuser == UserOptions.ADD_USER)
			{
				Adduser();
			}
			else if(optionselectedbyuser == UserOptions.SEARCH_USER)
			{
				System.out.println(" Enter the user name to search : ");
				scan.nextLine();
				String searchuser = scan.nextLine();
				Search(searchuser);
			}
			else if(optionselectedbyuser == UserOptions.EDIT_USER)
			{
				System.out.println(" Enter the user name to edit : ");
				scan.nextLine();
				String edituser = scan.nextLine();
				Edit(edituser);
			}
			else if(optionselectedbyuser == UserOptions.DELETE_USER)
			{
				System.out.println(" Enter the user name to delete : ");
				scan.nextLine();
				String deleteuser = scan.nextLine();
				Delete(deleteuser);
			}
		}
		System.out.println(" *After While Loop *");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).Username);
			System.out.println(al.get(i).LoginName);
			System.out.println(al.get(i).Password);
			System.out.println(al.get(i).UserRole);
		}}
	}
	public static void Adduser()
	{
		Scanner scan = new Scanner(System.in);
		User u1 = new User();
		
		System.out.println(" Enter the User Name : ");
		u1.Username = scan.nextLine();
		System.out.println(" Enter the Login Name : ");
		u1.LoginName = scan.nextLine();
		System.out.println(" Enter the Password : ");
		u1.Password = scan.nextLine();
		System.out.println(" Enter the Confirm Password : ");
		u1.ConfirmPassword = scan.nextLine();
		System.out.println(" Enter the User Role : ");
		u1.UserRole = scan.nextLine();
		
		al.add(u1);
	}
	public static void Search (String searchuser)
	{
		for(User u1:al)
		{
			if(u1.Username.equalsIgnoreCase(searchuser))
			{
				System.out.println(u1.Username);
				System.out.println(u1.LoginName);
				System.out.println(u1.Password);
				System.out.println(u1.UserRole);
				return;
				
			}
		}
		System.out.println(" USER NOT FOUND ");
	}
	
	//**** Edit Task Function ***

	public static void Edit (String edituser)
	{
		for(User u1:al)
		{
			if(u1.Username.equalsIgnoreCase(edituser))
			{
				Scanner scan = new Scanner(System.in);
				System.out.println(" Editing User Is : "+u1.Username);
				
				System.out.println(" New User Name is :");
				u1.Username = scan.nextLine();
				System.out.println(" New Login Name is : ");
				u1.LoginName = scan.nextLine();
				System.out.println(" New Password is : ");
				u1.Password = scan.nextLine();
				System.out.println(" New Confirm Password is : ");
				u1.ConfirmPassword = scan.nextLine();
				System.out.println(" New User Role is : ");
				u1.UserRole = scan.nextLine();
				
				System.out.println(" INFORMATION UPDATED ");
				return;
			}
		}
	}
	public static void Delete(String deleteuser)
	{
		Iterator<User>itr = al.iterator();
		while(itr.hasNext())
		{
			User u1 = itr.next();
			if(u1.Username.equalsIgnoreCase(deleteuser))
			{
				itr.remove();
				System.out.println(" User "+u1.Username+" has been deleted ");
				return;
			}
		}
		System.out.println(" USER NOT FOUND ");
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\NIKITA HAJARE\\nikita-eclipse-workspace\\___TO DO LIST___\\src\\To Do.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String line ="";
		
		while((line = br.readLine())!=null)
		{
		   User u1 = new User();
		   
		   String[] userDataArray = line.split(",");
		   
		   if(userDataArray.length>3)
		   {
			   u1.Username = userDataArray[0];
			   u1.LoginName = userDataArray[1];
			   u1.Password = userDataArray[2];
			   u1.UserRole = userDataArray[3];
			   
			   al.add(u1);
		   }
		}
		br.close();
		fr.close();
		file = null;
	}
	public static boolean validateUserandPassword(String login ,String password)
	{
		 Iterator<User>itr = al.iterator();
		 while(itr.hasNext())
		 {
			 User u1 = itr.next();
			 if(u1.LoginName.equalsIgnoreCase(login)&&u1.Password.equalsIgnoreCase(password))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	
	

}