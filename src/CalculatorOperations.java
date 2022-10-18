
public class CalculatorOperations {

    // Format numbers for calculator display
    public static String numberFormat(double total){
        if (total % 1.0 != 0)
            return String.format("%s", total);
        else
            return String.format("%.0f", total);
    }
}
