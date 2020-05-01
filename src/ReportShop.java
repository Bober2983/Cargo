public class ReportShop {
    private int idshop;
    private int id;
    private String profit;
    private String expenses;
    private String date;

    public ReportShop(int idshop,int id, String profit, String expenses, String date) {
        this.idshop = idshop;
        this.id = id;
        this.profit = profit;
        this.expenses = expenses;
        this.date = date;
    }
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdshop() { return idshop; }

    public void setIdshop(int idshop) {
        this.idshop = idshop;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {this.expenses = expenses;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {this.date = date;}


}
