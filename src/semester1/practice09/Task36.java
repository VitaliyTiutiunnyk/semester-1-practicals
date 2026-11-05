package semester1.practice09;

public class Task36 {
    public static void run(){
        InvestmentPortfolio portfolio = new InvestmentPortfolio("Олексій", 5);
        portfolio.addAsset(new GovernmentBond("UA-BOND", 10000, 0.15));
        portfolio.addAsset(new DividendStock("AAPL", 20000,
                0.10, 0.04, 0.195));

        System.out.println(portfolio);
    }
}
abstract class AbstractAsset {
    private final String ticker;
    protected double investedAmount;

    AbstractAsset(String ticker, double investedAmount) {
        this.ticker = ticker;
        this.investedAmount = investedAmount;
    }

    public abstract double calculateAnnualReturn();

    public double getCurrentValue() {
        return investedAmount + calculateAnnualReturn();
    }

    @Override
    public String toString() {
        return "Актив: " + ticker +
                ", вкладено: " + investedAmount +
                ", річний прибуток: " + calculateAnnualReturn();
    }
}

class GovernmentBond extends AbstractAsset {
    private final double couponRate;

    GovernmentBond(String ticker, double investedAmount, double couponRate) {
        super(ticker, investedAmount);
        this.couponRate = couponRate;
    }

    @Override
    public double calculateAnnualReturn() {
        return investedAmount * couponRate;
    }
}

class DividendStock extends AbstractAsset {
    private final double expectedGrowthRate;
    private final double dividendRate;
    private final double taxRate;

    DividendStock(String ticker, double investedAmount,
                  double expectedGrowthRate, double dividendRate, double taxRate) {
        super(ticker, investedAmount);
        this.expectedGrowthRate = expectedGrowthRate;
        this.dividendRate = dividendRate;
        this.taxRate = taxRate;
    }

    @Override
    public double calculateAnnualReturn() {
        double growth = investedAmount * expectedGrowthRate;
        double dividends = investedAmount * dividendRate;
        double netDividends = dividends * (1 - taxRate);

        return growth + netDividends;
    }
}

class InvestmentPortfolio {
    private final String investorName;
    private final AbstractAsset[] assets;
    private int count;

    InvestmentPortfolio(String investorName, int capacity) {
        this.investorName = investorName;
        assets = new AbstractAsset[capacity];
        count = 0;
    }

    public boolean addAsset(AbstractAsset asset) {
        if (asset == null || count >= assets.length) {
            return false;
        }

        assets[count] = asset;
        count++;
        return true;
    }

    public double getTotalValue() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += assets[i].getCurrentValue();
        }

        return total;
    }

    public double getTotalAnnualReturn() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += assets[i].calculateAnnualReturn();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Інвестор: " + investorName +
                ", вартість портфеля: " + getTotalValue() +
                ", очікуваний річний прибуток: " + getTotalAnnualReturn();
    }
}
