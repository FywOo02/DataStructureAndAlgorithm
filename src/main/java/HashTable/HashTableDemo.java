package HashTable;


import java.util.Scanner;

/**
 * @Author: Cho
 * @Date: 2022/8/20 20:27
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("add: add the employee");
            System.out.println("list: show the employees");
            System.out.println("find： find the employee");
            System.out.println("exit: exit the system");

            key = sc.next();
            switch (key){
                case "add":
                    System.out.println("enter the id");
                    int id = sc.nextInt();
                    System.out.println("enter the name");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                case "find":
                    System.out.println("Please enter the id of emp that you to find");
                    id = sc.nextInt();
                    hashTable.findEmpById(id);
                default:
                    break;
            }
        }
    }
}

// create the hash table
class HashTable{
    private EmployeeLinkedList[] empLinkedListsArray;
    private int size;

    public HashTable(int size){
        empLinkedListsArray = new EmployeeLinkedList[size];
        for (int i=0; i<size; i++){
            empLinkedListsArray[i] = new EmployeeLinkedList();
        }
        this.size = size;
    }

    public void add(Emp emp){
        // According to the id of emp to get the right list for adding
        int empLinkedListArrNo = hashFun(emp.id);
        empLinkedListsArray[empLinkedListArrNo].add(emp);
    }

    // write a hash function
    public int hashFun(int id){
        return id % size;
    }

    public void list(){
        for (int i=0; i<size; i++){
            empLinkedListsArray[i].list(i);
        }
    }

    public void findEmpById(int id){
        int empLinkedListArrNo = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListArrNo].findEmpById(id);
        if(emp != null){
            System.out.printf("Find the employee(id:%d) at list %d\n",emp.id,(empLinkedListArrNo+1));
        }else {
            System.out.println("Cannot find this employee");
        }
    }
}

/**
 * represent a employee
 */
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeLinkedList{
    private Emp headNode;

    // add the employee
    public void add(Emp emp){
        if(headNode == null){
            headNode = emp;
            return;
        }
        Emp curTemp = headNode;
        while(true){
            if(curTemp.next == null){
                break;
            }
            curTemp = curTemp.next;
        }
        curTemp.next = emp;
    }

    //Iterate the information of employees
    public void list(int no){
        if (headNode == null){
            System.out.printf("The list %d is empty now.\n",(no+1));
            return;
        }
        System.out.printf("The list %d information is： ",(no+1));
        Emp curTemp = headNode;
        while (true){
            System.out.printf("[id=%d name=%s]\t",curTemp.id,curTemp.name);
            if(curTemp.next == null){
                break;
            }
            curTemp = curTemp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id){
        if(headNode == null){
            System.out.println("this list is empty");
            return null;
        }
        Emp curEmp = headNode;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}