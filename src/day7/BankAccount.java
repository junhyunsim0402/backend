package day7;

public class BankAccount {
    String accountNumber;
    String ownerName;
    int balance;
    public BankAccount(String accountNumber,String ownerName,int balance){
        this.accountNumber=accountNumber;
        this.ownerName=ownerName;
        this.balance=balance;
    }
    public int Deposit(int deposit){
        return balance+=deposit;
    }
    public int Withdraw(int withdraw){
        return balance-=withdraw;
    }
}
