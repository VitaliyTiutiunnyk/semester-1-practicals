package semester1.practice10;

public class Task36 {
    public static void run() {
        PrintableDocument[] documents = {
                new FiscalReceipt("FR-001", 1200),
                new WarehouseReport("Звіт за листопад"),
                new FiscalReceipt("FR-002", 2500)
        };

        for (PrintableDocument document : documents) {
            System.out.println(document.formatForPrinter());
            System.out.println();
        }
    }
}

interface PrintableDocument {
    String formatForPrinter();
}

final class FiscalReceipt implements PrintableDocument {
    private final String fiscalNumber;
    private final double totalAmount;
    private final double vatAmount;

    FiscalReceipt(String fiscalNumber, double totalAmount) {
        this.fiscalNumber = fiscalNumber;
        this.totalAmount = totalAmount;
        this.vatAmount = totalAmount * 20 / 120;
    }

    @Override
    public String formatForPrinter() {
        return "=== ФІСКАЛЬНИЙ ЧЕК ===\n"
                + "Номер: " + fiscalNumber + "\n"
                + "Сума: " + totalAmount + " грн\n"
                + "ПДВ (20%): " + String.format("%.2f", vatAmount) + " грн";
    }
}

class WarehouseReport implements PrintableDocument {
    private final String reportName;

    WarehouseReport(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String formatForPrinter() {
        return "=== СКЛАДСЬКИЙ ЗВІТ ===\n"
                + "Назва: " + reportName;
    }
}
