class BankAccount{
    private String ownerName;
    private long iban;
    private double balance;
    public BankAccount(String ownerName, long iban){
        this.ownerName=ownerName;
        this.iban=iban;
        balance=0;
    }

    public long getIban() {
        return iban;
    }
    public void setIban(long iban) {
        this.iban = iban;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        setBalance(getBalance()+amount);
    }
    public void withdraw(double amount){
        if(amount>getBalance()){
            System.out.println("Not enough money in the account!!!");
        } else {
            setBalance(getBalance()-amount);
        }
    }
    public void sendMoney(double amount,BankAccount bankAccount,long iban){
        if(amount>getBalance()){
            System.out.println("Not enough money in the account!!!");
        } else if (bankAccount.getIban()!=iban) {
            System.out.println("Iban does not match!!!");
        } else {
            setBalance(getBalance()-amount);
            bankAccount.setBalance(bankAccount.getBalance()+amount);
        }
    }
    public void displayAccountInfo(){
        System.out.println("Owner's name: "+getOwnerName());
        System.out.println("Iban: "+getIban());
        System.out.println("Balance: "+getBalance());
    }
}
public class Bank {
    public static void main(String[] args) {
        BankAccount account1=new BankAccount("Kemal",12345678912L);
        BankAccount account2=new BankAccount("Efe",12345678913L);
        account1.deposit(125.24);
        account2.deposit(267.25);
        account1.withdraw(34.45);
        account2.withdraw(267.26);
        account1.sendMoney(13.75,account2,12345678913L);
        account1.displayAccountInfo();
        account2.displayAccountInfo();
    }
}
