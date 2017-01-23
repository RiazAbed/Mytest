/**
 * Created by riaz-abed on 2017/01/18.
 */
class Money implements Expression{
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }


    public boolean equals(Object object) {

        Money money = (Money) object;
        return ((this.amount == money.amount) && (this.currency.equals(money.currency())));

    }

    String currency() {
        return this.currency;
    }


    public Expression times(int multiplier) {

        return new Money(amount * multiplier, currency);
    }

    public Expression plus (Expression addend){

        return new Sum(this, addend);
    }

    public Money reduce(Bank bank,String to){
        int rate = bank.rate(currency,to);

        return new Money(amount/ rate, to);

    }








}