
public class Tester {
	
	public static void main(String[] args) {
		Budget myBudget = new Budget(10.25, 24.0, .15);
		myBudget.addExpense("Media", "Crunchyroll", 6.95);
		myBudget.addExpense("Media", "Hulu", 11.99);
		myBudget.addExpense("Media", "Twitch", 8.99);
		myBudget.addExpense("Media", "Apple Music", 9.99);
		myBudget.addExpense("myBanking", "Service Transfer", 25.0);
		myBudget.addExpense("myBanking", "Paycheck Holding", 100.0 * 26.0 / 12.0);
		myBudget.addExpense("Housing", "Rent", 314.16);
		System.out.println(myBudget.printRecurringExpenses());
		System.out.println("$" + String.format("%.2f", myBudget.getMonthlyBudget()));
		System.out.println("$" + String.format("%.2f", myBudget.getWeeklyBudget()));
	}

}
