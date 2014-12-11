package UnitLab.UnitLab;

public class ATM {
   
    private double Money;
    private Card CardInsert;

	//Можно задавать количество денег в банкомате 

	public ATM(double moneyInATM) {
		this.Money = moneyInATM;
		this.CardInsert = null;
	}

    
    public double getMoneyInATM() {
    	 return Money;
        
    }
    
    public boolean validateCard(Card card, int pinCode){
         if (!card.isBlocked() && card.checkPin(pinCode)) 
         {
        	 CardInsert=card;
        	 return true;
         }
         return false;
        		 
    }
 
    public double checkBalanse() throws NoCardInsertedException{
		if (CardInsert == null) throw new NoCardInsertedException("It's impossible to check balanse. Card not exsist");
		return CardInsert.getAccount().getBalance();
	}
	public double getCash(double amount) 
			throws NoCardInsertedException, NotEnoughMoneyInAccount, NotEnoughMoneyInATM {
		
		if (CardInsert == null) 
			throw new NoCardInsertedException("It's impossible to get cash. Card not exsist");
		if (checkBalanse() < amount) 
			throw new NotEnoughMoneyInAccount("Not enought money in account");
		if (getMoneyInATM() < amount) 
			throw new NotEnoughMoneyInATM("Not enought money in ATM");
		
		CardInsert.getAccount().withdrow(amount);
		Money -= amount;
		return CardInsert.getAccount().getBalance();
	}
    		
    
         
}

