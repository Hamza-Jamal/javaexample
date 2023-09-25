import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("account.dat"));
        BankAccount account=(BankAccount) inputStream.readObject();
        System.out.println(account.getName()+"  "+account.getBalance());
    }
}


class BankAccount implements Serializable{
    private final String name;
    private int balance;
    public BankAccount(String name){
        this.name=name;
        balance=0;
    }
    public String getName(){
        return name;
    }
    public void setBalance(int deposit){
        balance+=deposit;
    }
    public int getBalance(){
        return balance;
    }

}
