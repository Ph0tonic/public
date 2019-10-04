class BankAccount {
    public enum CurrencyType { DOLLAR, EURO, POUND };

    public BankAccount(CurrencyType currencyType, double amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    private CurrencyType currencyType;
    private double amount;

    public boolean add(CurrencyType addedType, double amount) throws Exception {
        assert(amount >= 0);
        double inCurrency = convert(amount, addedType, currencyType);
        amount += inCurrency;
        return true;
    }

    public boolean remove(CurrencyType removedType, double amount) throws Exception {
        assert(amount >= 0);
        double inCurrency = convert(amount, removedType, currencyType);

        if(inCurrency > amount) {
            return false;
        }
        amount -= inCurrency;
        return true;
    }

    private double convert(double amount, CurrencyType from, CurrencyType to) throws Exception {
        if(from == to) {
            return amount;
        }
        else if(to == CurrencyType.DOLLAR && from == CurrencyType.EURO) {
            return 1.15 * amount;
        }
        else if(to == CurrencyType.DOLLAR && from == CurrencyType.POUND) {
            return 1.31 * amount;
        }
        else if(to == CurrencyType.EURO && from == CurrencyType.DOLLAR) {
            return 0.87 * amount;
        }
        else if(to == CurrencyType.EURO && from == CurrencyType.POUND) {
            return 1.14 * amount;
        }
        else if(to == CurrencyType.POUND && from == CurrencyType.DOLLAR) {
            return 0.76 * amount;
        }
        else if(to == CurrencyType.POUND && from == CurrencyType.EURO) {
            return 0.88 * amount;
        }
        throw new Exception("Unknown currency conversion");
    }
    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public double getAmount() {
        return amount;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount(BankAccount.CurrencyType.EURO, 9001);
        account.add(BankAccount.CurrencyType.DOLLAR, 100);
        account.remove(BankAccount.CurrencyType.POUND, 10);
        System.out.println("Balance: " + account.getAmount());
    }
}
