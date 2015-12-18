
import java.util.HashMap;
import java.util.LinkedList;

public class Budget {
	
	private double wage;
	private double weeklyHours;
	private double taxRate;
	
	private HashMap<String, LinkedList<Expenses>> recurringExpenses;
	
	public Budget(double wage, double weeklyHours, double taxRate) {
		this.wage = wage;
		this.weeklyHours = weeklyHours;
		this.taxRate = taxRate;
		recurringExpenses = new HashMap<>();
	}
	
	public void addExpense(String category, String name, double amount) {
		if(recurringExpenses.get(category) == null) {
			recurringExpenses.put(category, new LinkedList<Expenses>());
		}
		recurringExpenses.get(category).add(new Expenses(name, amount));
	}
	
	private double getWeeklyExpenses() {
		return getMonthlyExpenses() * 12.0 / 52.0;
	}
	
	private double getMonthlyExpenses() {
		double total = 0;
		for(String key: recurringExpenses.keySet()) {
			for (Expenses expense: recurringExpenses.get(key)) {
				total += expense.getAmount();
			}
		}
		return total;
	}
	
	public double getMonthlyBudget() {
		double gross = wage * (1.0 - taxRate) * weeklyHours * 52.0 / 12.0;
		return gross - getMonthlyExpenses();
	}
	
	public double getWeeklyBudget() {
		double gross = wage * (1.0 - taxRate) * weeklyHours;
		return gross - getWeeklyExpenses();
	}
	
	public String printRecurringExpenses() {
		String expenses = "";
		for(String key: recurringExpenses.keySet()) {
			for (Expenses expense: recurringExpenses.get(key)) {
				expenses += expense + "\n";
			}
		}
		return expenses;
	}

}
