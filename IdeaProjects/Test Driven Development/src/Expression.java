/**
 * Created by riaz-abed on 2017/01/18.
 */
interface Expression {

    Money reduce(Bank bank, String to);
    Expression plus(Expression addend);
    Expression times(int multiplier);


}
