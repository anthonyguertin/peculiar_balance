
public class Answer {

	public static void main(String[] args) {
		String[] result = answer(/*PUT X IN HERE<<<<<=======*/);
	}
	
    public static String[] answer(int x) { 
        
        String[] peculiar_balance = balanceConversion(convert(x));

        return peculiar_balance;
    }
    
    public static String convert(int x)
    {
        String conversion = "";
        
        while (x > 0)
        {
            conversion = Integer.toString(x % 3) + conversion;
            x /= 3;
        }
        
        
        return conversion;
    }
    
    public static String[] balanceConversion(String ternary)
    {
		
		StringBuilder result = new StringBuilder(ternary).reverse();
		
		for (int i = 0; i < result.length(); i++)
		{
			if (result.charAt(i) == '2' )
			{
				result.setCharAt(i, '-');
				result = calculateCarry(result, i + 1);
			}
		}
		String[] balanced = new String[result.length()];
		for (int i = 0; i < result.length(); i++)
		{
			if (result.charAt(i) == '0')
			{
				balanced[i] = "-";
			} else if (result.charAt(i) == '1')
			{
				balanced[i] = "R";
			} else {
				balanced[i] = "L";
			}
		}
	
		return balanced;
    }
    
    private static StringBuilder calculateCarry(StringBuilder result, int i)
    {
        if (result.length() == i)
		{
			result.append("1");
		} else if (result.charAt(i) == '-')
		{
			result.setCharAt(i, '0');
		} else if (result.charAt(i) == '0')
		{
			result.setCharAt(i, '1');
		} else if (result.charAt(i) == '1')
		{
			result.setCharAt(i, '-');
		} else {
			result.setCharAt(i, '0');
			result = calculateCarry(result, i + 1);
		}
		
		return result;
    }
}
