/*
This file stores User data to a file and provides methods to encrypt the password,
as well as to validate login and change password "securely"
@version 1.0
CEN 3031
File: User.java
*/
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class User{

    private String fileName = "userData.txt";
    private int score;
    private String username, password;

    /* 
    Creates the file if none exists, and writes the username and password.
    Each is followed by a newline
    */
    public User(String username, String password){
            File f = new File(fileName);
           // setPassword(password);
           // setUserName(Username);
            try (FileWriter fileWrite = new FileWriter(f)){
                fileWrite.write(username + "\n" + encrypt(password) + "\n" + "0\n");
                fileWrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
       
    /* 
    Reads line by line, looking for a match in the username.
    If the line matches the username, and the next line (when decrypted) matches the password,
    true is returned. Else, false is returned.
    */
    public boolean loginCheck(String userName, String password){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            for (String next = reader.readLine(); next != null; next = reader.readLine()){
                if (next.equals(userName)){
                    if (decrypt(reader.readLine()).equals(password)){       /* Changed to .equals() from == */
                        return true;
                    }
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }
    
    /*
    Uses loginCheck to validate user and rewrites password,
    returns true if success, false if wrong username or password.
    */
    public boolean changePassword(String username, String password, String newPassword){
        if(loginCheck(username,password)){
            ArrayList<String> userData = new ArrayList<String>();
            File f = new File(fileName);
            try{
            BufferedReader reader = new BufferedReader(new FileReader(f));

            //Going through file and adding each string to an arrayList,
            //Except replacing old password with new password
            for (String next = reader.readLine(); next != null; next = reader.readLine()){
                if (next == decrypt(password)){
                   userData.add(newPassword);
                }
                else{ 
                userData.add(next);
                }
            }
        reader.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        //Deleting file and creating new one from ArrayList
            f.delete();
            File file = new File(fileName);
            try (FileWriter fileWrite = new FileWriter(file)){
                for (int i = 0; i < userData.size(); i++){
                    fileWrite.write(userData.get(i) + "\n");
                }
                fileWrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }   
            return true;
        }
        return false;
    }

    public void addScore(String username, String password){
         
    }

    public boolean resetScore(String username, String password){

        return true;
    }

    public int retrieveScore(String username, String password){
        
        return 0;
    }

    //Encrypts by casting to an int, adding to ascii value, and casting back to char
    public String encrypt(String password){
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            passwordArray[i] = (char) ((int) passwordArray[i] + 3);
        }
        password = new String(passwordArray);
        return password;
    }
    //Decrypts the exact opposite way of encrypt()
    public String decrypt(String password){
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < password.length(); i++) {
            passwordArray[i] = (char) ((int) passwordArray[i] - 3);
        }
        password = new String(passwordArray);
        return password;
    }
}