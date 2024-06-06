import java.util.ArrayList;  
import java.util.Scanner;
class invalidOptionEnteredException extends Exception  
{
    public invalidOptionEnteredException(String s)
    { 
        super(s);
    }
}
class tasks
{
    static void validate(int choice) throws invalidOptionEnteredException   
    {
        if(5<choice) 
        {
            System.out.println();
            throw new invalidOptionEnteredException("The option is invalid...please enter between 1 and 4");
        }
    } 
    public static void  addATask(String task,ArrayList<String> array)  // add an task into the list
    {
        if(array.contains(task))  // if task already exsists in the list
        {
            System.out.println();
            System.out.println("This task is already exists in the list");
            System.out.println();
        }
        else  
        {
            array.add(task);
            System.out.println();
            System.out.println("The task is added successfully into the list...");
        } 

    }
    public static void removeATask(String removeTask,ArrayList<String> array)  // remove an task
    {
        if(array.contains(removeTask))
        {
           array.remove(removeTask);
           System.out.println();
           System.out.println("The task is removed successfully from the list...");
        }
        else
        {
           System.out.println();
           System.out.println("There is no this kind of task in the list");
           System.out.println();
        }
    }
    public static void addAtSpecificIndex(int specificIndex,String specifictask,ArrayList<String> array) // adding an task at specific index
    {
        if(array.contains(specifictask))
        {
            System.out.println();
            System.out.println("This task is already exists in the list");
            System.out.println();
        }
        else
        {   
            array.add(specificIndex-1,specifictask);
            System.out.println();
            System.out.println("The task is added successfully into the list...");
        }

    }
    public static void showList(ArrayList<String> array)   // Display the list
    {
           System.out.println();
           System.out.println("-----------------------------------------");
           System.out.println("|\tS.No\t|\tTask\t\t|");
           System.out.println("-----------------------------------------");
           for(int i=0;i<array.size();i++)
           {
            System.out.println("|\t"+(i+1)+"\t|\t"+array.get(i)+"\t\t|");
           }
           System.out.println("-----------------------------------------");
    }
}
class ToDoList extends tasks{
    public static void main(String ar[])
    {
        System.out.println("\t\t\t-:::  TO DO LIST  :::-");
        Scanner sc=new Scanner(System.in);
        int choice=0;
        ArrayList<String> array=new ArrayList<String>();
        boolean modifications=false;
        do{
                
                boolean invalidOption=false;         // if user enters greater than the below options
                do                                        
                {   invalidOption=false;
                    System.out.println("1.Add a Task");
                    System.out.println("2.Remove a Task");
                    System.out.println("3.Add Task at specific index");
                    System.out.println("4.Display the list");
                    System.out.println("5.Exit");
                    System.out.println();
                    System.out.print("Enter your choice : ");
                    choice=sc.nextInt();
                    try{
                        validate(choice);  
                    }
                    catch(invalidOptionEnteredException e)
                    {
                        System.out.println("Exception occurred : "+e.getMessage());
                        System.out.println();
                        invalidOption=true;
                    }
                }while(invalidOption);
                switch (choice) 
                {
                    case 1:
                            System.out.print("Enter a task to add : ");   
                            String task=sc.next();
                            addATask(task,array);
                            showList(array);
                            break;
                    case 2:
                            System.out.print("Enter a task to remove : ");
                            String removeTask=sc.next();
                            removeATask(removeTask,array);
                            showList(array);
                            break; 
                    case 3:
                            System.out.print("Enter a index, where you want to append : ");
                            int specificIndex=sc.nextInt();
                            System.out.print("Enter a task to add : ");
                            String specifictask=sc.next();
                            addAtSpecificIndex(specificIndex,specifictask,array);
                            showList(array);
                            break;
                    case 4: 
                            showList(array); 
                            break;
                    case 5: System.exit(5);;
                }
                System.out.println();
                System.out.print("For any modifications enter  1...otherwise enter  0  : "); // for any modifications in the list
                int t=sc.nextInt();
                System.out.println();
                if(t==1) 
                    modifications=true;
                else                         
                {
                    modifications=false;
                }
            }while(modifications);
            System.out.println();
            System.out.println("The final list is : "); 
            System.out.println();
            showList(array);
    }
}
