package com.tcs.main;

import java.util.Scanner;


public class UserInformationMain 
{

	public static void main(String args[])
	{
		try {
		//List<String> lst = new LinkedList<>();
		//UserService userv = new UserServiecImpl();
		
		System.out.println("Main Menu");
		System.out.println("Select an option from below");
		System.out.println("1. Add a user");
		System.out.println("2. Modify a user");
		System.out.println("3. Delete a user");
		System.out.println("4. See Details of User");
		System.out.println("5. See Details of all Users");
		
		
		while(true) 
		{	
			System.out.println("Select a menu option: ");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int option=sc.nextInt();
			
			switch(option)
			{
				case 1:
					boolean flag =adduser();
					if(flag) 
					{
						break;
					}
					else
					{
						continue;
					}
				case 2:
					boolean flag1 =modifyUser();
					if(flag1) 
					{
						break;
					}
					else
					{
						continue;
					}
				case 3:
					deleteUser();
					break;
					
				case 5:
					viewAll();
					break;
					
				case 4:
					viewSelectUser();
					break;
				
				default:
				{
					System.out.println("Invalid input");
				}
			
			}
			
			System.out.println("Continue(Y/N): ");
			String cont = sc.next();
			
			if(ApplicationConstants.NO_CODE.equalsIgnoreCase(cont)) 
			{
				break;
			}
		
	}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void viewSelectUser() 
	{
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter User ID:");
		String uid = sc.next();
		
		for(UserData user : ApplicationConstants.users) 
		{
			if(user.getEmpID().equals(uid)) 
			{
				System.out.println("================================= Single User=======================================");
				System.out.println("User ID: " + user.getEmpID() + "\n" + "User Name: " + user.getName() + "\n" + "User Age: " + user.getAge() + "\n" +  "User ID: "  + user.getAddress() + "\n\n");
				break;
			}
		}
		System.out.println("User details displayed!");
		
	}

	private static void deleteUser() 
	{
		System.out.println("Enter User ID:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		String uid = sc.next();
		
		for(UserData user : ApplicationConstants.users) 
		{
			if(user.getEmpID().equals(uid)) {
				ApplicationConstants.users.remove(user);
				break;
			}
		}
		System.out.println("User deleted ....");
	}

	
	private static void viewAll() 
	{
		System.out.println("=============================Users=============================");
		for(UserData user : ApplicationConstants.users) 
		{
			System.out.println("User ID: " + user.getEmpID() + "\n" + "User Name: " + user.getName() + "\n" + "User Age: " + user.getAge() + "\n" +  "User ID: "  + user.getAddress() + "/n/n");
		}
	}

	
	
	private static boolean modifyUser() 
	{
		Scanner sc = new Scanner(System.in); 		
		System.out.println("Enter User ID:");
		
		String uid = sc.next();
		
		for(UserData user : ApplicationConstants.users) 
		{
			if(user.getEmpID().equals(uid)) 
			{
				System.out.println("Select a field to edit from below" + "\n" + "1. Name \n 2. Address \n 3. Age \n");
				int choice=sc.nextInt();
				
				switch(choice) 
				{
						
					case 1:
							
						System.out.print("Enter Name:");
						if(sc.hasNext("[A-Za-z]*")) 
						{
							String name = sc.nextLine();
							user.setName(name);
						}
						else
						{
								System.out.print("Invalid Input\n");
						}
						break;
						
					case 2:
							
						System.out.print("Enter Address:");
						if(sc.hasNext("[A-Za-z0-9]*")) 
						{
							String address = sc.nextLine();
							user.setAddress(address);
						}
						else
						{
							System.out.print("Invalid Input\n");
						}
						break;
							
					case 3:
							
						System.out.print("Enter Age:");
						if(sc.hasNextInt()) 
						{
							int age = sc.nextInt();
							user.setAge(age);
						}
						else
						{
							System.out.print("Invalid Input\n");
						}
						break;
						
					default:
					
						System.out.println("Invalid input\n");	
						break;
				}
			}
		}
		return true;	
	}

	private static boolean adduser() 
	{
				
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 		
		UserData new_user = new UserData();
		
		System.out.print("Enter Name:");
		if(sc.hasNext("[A-Za-z]*")) 
		{
			String name = sc.nextLine();
			new_user.setName(name);
		}
		else
		{
			System.out.print("Invalid Input");
			return false;
		}
		
		System.out.print("Enter Address:");
		
		if(sc.hasNext("[A-Za-z0-9]*")) 
		{
			String address = sc.nextLine();
			new_user.setAddress(address);
		}
		else
		{
			System.out.print("Invalid Input");
			return false;
		}
		
		System.out.print("Enter Age:");
		
		if(sc.hasNextInt()) 
		{
			int age = sc.nextInt();
			new_user.setAge(age);
		}
		else
		{
			System.out.print("Invalid Input");
			return false;
		}
		
		new_user.createID();
				
		ApplicationConstants.users.add(new_user);
		System.out.println("User added ...");
		
		return true;
		
		/*
		 * String userdata = "Darshan|adrress|21|"; String []values =
		 * userdata.split("\\|"); values[0]
		 */
	}
		
}