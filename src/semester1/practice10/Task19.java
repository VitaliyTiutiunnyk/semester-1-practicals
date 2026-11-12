package semester1.practice10;

public class Task19 {
    public static void run() {
        AbstractFinancialInstrument[] instruments = {
                new TechGrowthStock("NVDA", 10),
                new BlueChipStock("KO", 20),
                new FixedTermDeposit("DEPOSIT", 10000)
        };

        System.out.println("Фінансові інструменти:");

        for (AbstractFinancialInstrument instrument : instruments) {
            System.out.println("\nТип: " + instrument.getClass().getSimpleName());
            System.out.println("Ринкова вартість: "
                    + instrument.getMarketValueUah() + " грн");

            if (instrument instanceof Tradable tradable) {
                System.out.println("Покупка 5 одиниць: " + tradable.buy(5));
                System.out.println("Продаж 2 одиниць: " + tradable.sell(2));
                System.out.println("Вартість після операцій: "
                        + instrument.getMarketValueUah() + " грн");
            }

            if (instrument instanceof DividendPaying dividendPaying) {
                System.out.println("Річні виплати: "
                        + dividendPaying.calculateAnnualDividend() + " грн");
            }

        }
    }
}
    abstract class AbstractFinancialInstrument {
        private final String ticker;
        protected int quantity;

        AbstractFinancialInstrument(String ticker, int quantity) {
            this.ticker = ticker;
            this.quantity = quantity;
        }

        public abstract double getMarketValueUah();
    }

    interface Tradable {
        boolean buy(int qty);

        boolean sell(int qty);
    }

    interface DividendPaying {
        double calculateAnnualDividend();
    }

    class TechGrowthStock extends AbstractFinancialInstrument implements Tradable {
        private static final double price = 2500;

        TechGrowthStock(String ticker, int quantity) {
            super(ticker, quantity);
        }

        @Override
        public double getMarketValueUah() {
            return quantity * price;
        }

        @Override
        public boolean buy(int qty) {
            if (qty <= 0) return false;
            quantity += qty;
            return true;
        }

        @Override
        public boolean sell(int qty) {
            if (qty <= 0 || qty > quantity) return false;
            quantity -= qty;
            return true;
        }

    }

    class BlueChipStock extends AbstractFinancialInstrument implements Tradable, DividendPaying {
        private static final double price = 1800;
        private static final double dividendRate = 0.05;

        BlueChipStock(String ticker, int quantity) {
            super(ticker, quantity);
        }

        @Override
        public double getMarketValueUah() {
            return quantity * price;
        }

        @Override
        public double calculateAnnualDividend() {
            return getMarketValueUah() * dividendRate;
        }

        @Override
        public boolean buy(int qty) {
            if (qty <= 0) return false;
            quantity += qty;
            return true;
        }

        @Override
        public boolean sell(int qty) {
            if (qty <= 0 || qty > quantity) return false;
            quantity -= qty;
            return true;
        }
    }

    class FixedTermDeposit extends AbstractFinancialInstrument implements DividendPaying {
        private static final double INTEREST_RATE = 0.10;

        FixedTermDeposit(String ticker, int quantity) {
            super(ticker, quantity);
        }

        @Override
        public double getMarketValueUah() {
            return quantity;
        }

        @Override
        public double calculateAnnualDividend() {
            return getMarketValueUah() * INTEREST_RATE;
        }
    }
