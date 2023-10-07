package ToDoManagement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class ToDoManagement {


	static ArrayList<ToDo> al = new ArrayList();
	static
	{
		try {
			loadDataFromFileToArrayList();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public static void todoManagement() throws IOException {
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true )
		{
			System.out.println(" ******WELCOME TO ToDo MANAGMENT** ");
			System.out.println(" 1.Add Task ");
			System.out.println(" 2.Edit Task ");
			System.out.println(" 3.Delete Task ");
			System.out.println(" 4.Search Task ");
			System.out.println(" 5.Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			if(optionselectedbyuser == ToDoOptions.QUIT)
			{
				File file = new File("C:\\\\Users\\\\NIKITA HAJARE\\\\nikita-eclipse-workspace\\\\___TO DO LIST___\\\\src\\\\ToDoManagement\\\\To Do.txt");
				
				FileWriter fr = new FileWriter(file,false);
				
				BufferedWriter br = new BufferedWriter(fr);
				
				for(ToDo u1:al)
				{
					br.write(u1.number+","+u1.name+","+u1.mark+"\n");
				}
				br.close();
				file = null;
				System.out.println(" !!!! PROGRAM CLOSED !!!! ");
				CanIKeepRunningTheProgram = false;
			}
			else if(optionselectedbyuser == ToDoOptions.ADD_TASK)
			{
				AddToDo();
			}
			else if(optionselectedbyuser == ToDoOptions.SEARCH_TASK)
			{
				System.out.println(" Enter the task number to search : ");
				scan.nextLine();
				String searchtask = scan.nextLine();
				SearchToDo(searchtask);
			}
			else if(optionselectedbyuser == ToDoOptions.EDIT_TASK)
			{
				System.out.println(" Enter the task number to edit : ");
				scan.nextLine();
				String edittask = scan.nextLine();
				EditToDo(edittask);
			}
			else if(optionselectedbyuser == ToDoOptions.DELETE_TASK)
			{
				System.out.println(" Enter the task number to delete : ");
				scan.nextLine();
				String deletetask = scan.nextLine();
				DeleteToDo(deletetask);
			}
		}
		System.out.println(" *After While Loop *");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).number);
			System.out.println(al.get(i).name);
			System.out.println(al.get(i).mark);
		}}
	}
	public static void AddToDo()
	{
		Scanner scan = new Scanner(System.in);
		ToDo u1 = new ToDo();
		
		System.out.println("Enter Task_Number: ");
		u1.number = scan.nextLine();
		
		System.out.println("Enter Task_Name: ");
		u1.name = scan.nextLine();
		
		System.out.println("Enter Task_Mark: ");
		u1.mark = scan.nextLine();
		
		System.out.println("Task Number is :"+u1.number);
		System.out.println("Task Name is :"+u1.name);
		System.out.println("Task Mark is :"+u1.mark);
		
		al.add(u1);
	}
	public static void SearchToDo(String Tasknumber)
	{
		for(ToDo u1:al)
		{
			if(u1.name.equalsIgnoreCase(Tasknumber))
			{
				System.out.println("Task Number is :"+u1.number);
				System.out.println("Task Name is :"+u1.name);
				System.out.println("Task Mark is :"+u1.mark);
				return;
				
			}
		}
		System.out.println(" TASK NOT FOUND ");
	}
	
	//**** Edit Task Function ***

	public static void EditToDo(String Tasknumber) {
		for(ToDo u1:al) {
			if(u1.number.equalsIgnoreCase(Tasknumber)) {
				Scanner scan = new Scanner(System.in);
				
				System.out.println("Enter Task_Number: "+u1.number);
				
				System.out.println("New Task_Name is: ");
				u1.name = scan.nextLine();
				
				System.out.println("New Task_Number is: ");
				u1.number = scan.nextLine();
				
				System.out.println("New Task_Mark is: ");
				u1.mark = scan.nextLine();

				System.out.println("Task Information updated");
				return;
			}
		}
		System.out.println("!!! Task Not Found !!!");

	}
	
	//**** Delete Task Function ****

	
	public static void DeleteToDo(String Tasknumber)
	{
		Iterator<ToDo>itr = al.iterator();
		while(itr.hasNext())
		{
			ToDo u1 = itr.next();
			if(u1.number.equalsIgnoreCase(Tasknumber))
			{
				itr.remove();
				System.out.println(" User "+u1.number+" has been deleted ");
				return;
			}
		}
		System.out.println(" TASK NOT FOUND ");
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\\\Users\\\\NIKITA HAJARE\\\\nikita-eclipse-workspace\\\\___TO DO LIST___\\\\src\\\\ToDoManagement\\\\To Do.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		String line ="";
		
		while((line = br.readLine())!=null)
		{
		   ToDo u1 = new ToDo ();
		   
		   String[] userDataArray = line.split(",");
		   
		   if(userDataArray.length>2)
		   {
			   u1.number = userDataArray[0];
			   u1.name = userDataArray[1];
			   u1.mark = userDataArray[2];			   
			   al.add(u1);
		   }
		}
		br.close();
		fr.close();
		file = null;
	}
}