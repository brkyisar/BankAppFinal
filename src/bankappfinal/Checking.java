package bankappfinal;


public class Checking extends Account{
    
    Checking(int accountId, double initialDeposit){
       super(accountId);
       this.setBalance(initialDeposit);
    }
    
   
    @Override
    public AccountType getAccountType() {
        return AccountType.Vadesiz;
    }
    
}

