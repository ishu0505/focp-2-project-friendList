import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class friendsCRUD {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        int choice = -1;
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        File file = new File("friend.txt");
        ArrayList<Friend> list = new ArrayList<Friend>();
        ObjectOutputStream oos =  null;
        ObjectInputStream ois = null;
        ListIterator li = null;

//
        System.out.println("Username - admin  ");
        System.out.println("Password - admin");
        System.out.println("Enter username: ");
        String uname = scan.nextLine();

        if(uname.equals("admin")){
            System.out.println("Enter password: ");
            String pass = scan.nextLine();
            if (pass.equals("admin")){

                System.out.println("login successfull");

                if (file.isFile()){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    list = (ArrayList<Friend>)ois.readObject();
                    ois.close();
                }

                do {
                    System.out.println("1. Insert ");
                    System.out.println("2. Display ");
                    System.out.println("3. Search");
                    System.out.println("4. Delete");
                    System.out.println("5. Update");
                    System.out.println("0. EXIT ");
                    System.out.println("Enter your choice : ");
                    choice = scanInt.nextInt();

                    switch (choice){
                        case 1:
                            System.out.println("How many friends do you want to add ? : ");
                            int n = scanInt.nextInt();

                            for (int i = 0 ; i<n; i++) {
                                System.out.println("Enter Friend's Name: ");
                                String friendName = scan.nextLine();

                                System.out.println("Enter Friend's Contact Info: ");
                                String contact = scan.nextLine();

                                System.out.println("Enter Friend's address: ");
                                String address = scan.nextLine();

                                list.add(new Friend(friendName, contact, address));

                            }
                            oos = new ObjectOutputStream(new FileOutputStream(file));
                            oos.writeObject(list);
                            oos.close();
                            break;

                        case 2:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                list = (ArrayList<Friend>) ois.readObject();
                                ois.close();


                                System.out.println("------------------------------------");

                                li = list.listIterator();
                                while (li.hasNext()) {
                                    System.out.println(li.next());
                                }

                                System.out.println("------------------------------------");
                            }else {
                                System.out.println("You have no friends......");
                            }

                            break;
                        case 3:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                list = (ArrayList<Friend>)ois.readObject();
                                ois.close();

                                boolean found = false;
                                System.out.println("Enter Friend Name to search details : ");
                                String searchName = scan.nextLine();
                                System.out.println("------------------------------------");

                                li = list.listIterator();
                                while (li.hasNext()) {
                                    Friend f = (Friend) li.next();
                                    if (f.friendName.equals(searchName)) {
                                        System.out.println(f);
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Friend not found.......... ");
                                }

                                System.out.println("------------------------------------");
                            }else {
                                System.out.println("You have no friends......");
                            }
                            break;
                        case 4:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                list = (ArrayList<Friend>)ois.readObject();
                                ois.close();

                                boolean found = false;
                                System.out.println("Enter Friend Name to search details : ");
                                String searchName = scan.nextLine();
                                System.out.println("------------------------------------");

                                li = list.listIterator();
                                while (li.hasNext()) {
                                    Friend f = (Friend) li.next();
                                    if (f.friendName.equals(searchName)) {
                                        li.remove();
                                        System.out.println(f.friendName + " removed from friend list.....");
                                        found = true;
                                    }
                                }
                                if (found) {
                                    oos = new ObjectOutputStream(new FileOutputStream(file));
                                    oos.writeObject(list);
                                    oos.close();
                                }else {
                                    System.out.println("Friend not found.......... ");
                                }

                                System.out.println("------------------------------------");
                            }else {
                                System.out.println("You have no friends......");
                            }
                            break;

                        case 5:
                            if (file.isFile()) {
                                ois = new ObjectInputStream(new FileInputStream(file));
                                list = (ArrayList<Friend>)ois.readObject();
                                ois.close();

//                        while (li.hasNext()) {
//                            System.out.println(li.next());
//                        }

                                boolean found = false;
                                System.out.println("Enter the friend's name to update data : ");
                                String searchName = scan.nextLine();
                                System.out.println("------------------------------------");

                                li = list.listIterator();
                                while (li.hasNext()) {
                                    Friend f = (Friend) li.next();
                                    if (f.friendName.equals(searchName)) {
                                        found = true;
                                        System.out.println(f);


                                        System.out.println("Enter new Contact info:");
                                        String friendContact = scan.nextLine();

                                        System.out.println("Enter new address info:");
                                        String friendAddress = scan.nextLine();

                                        li.set(new Friend(searchName, friendContact, friendAddress));
                                        System.out.println(f.friendName+ "'s data updated...");




                                    }
                                }
                                if (found) {
                                    oos = new ObjectOutputStream(new FileOutputStream(file));
                                    oos.writeObject(list);
                                    oos.close();
                                }else {
                                    System.out.println("Friend not found.......... ");
                                }

                                System.out.println("------------------------------------");
                            }else {
                                System.out.println("You have no friends......");
                            }
                            break;
                    }
                }while(choice!=0);


            }else {
                System.out.println("incorrect password...");
            }


        }else {
            System.out.println("No such user found....");
        }

  //


    }
}
