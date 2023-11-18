import java.util.Scanner;

public class DepositCalculator {
    int precision = 2;
    double yearRate = 0.06;
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay;
        pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(pay, precision);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double pay;
        pay = amount + amount * yearRate * depositPeriod;

        return round(pay, precision);
    }

    double round(double value, int precision) {
        double scale;
        scale = Math.pow(10, precision);

        return Math.round(value * scale) / scale;
    }

    void calculateDepositProfit() {
        int amount;
        int period;
        int action;
        double profit = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            profit = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            profit = calculateComplexPercent(amount, yearRate, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + profit);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositProfit();
    }
}
