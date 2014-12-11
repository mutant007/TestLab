package UnitLab.UnitLab;

public class MyATM {

    public static void main(String[] args) throws NotEnoughMoneyInATM, NotEnoughMoneyInAccount, NoCardInsertedException {
        double moneyInATM = 1000;
        ATM atm = new ATM(moneyInATM);
        Card card = null;
        atm.validateCard(card, 1234);
        atm.checkBalanse();
        atm.getCash(999.99);        
    }
}
