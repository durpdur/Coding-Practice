class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int numOfCustomer = accounts.length;
        int highestAccountVal = 0;

        for (int i = 0; i < numOfCustomer; i++) {
            int numOfAccounts = accounts[i].length;
            System.out.println(i);
            int currentAccountVal = 0;
            for (int j = 0; j < numOfAccounts; j++) {
                currentAccountVal += accounts[i][j];
                System.out.println(currentAccountVal);
            }

            if (highestAccountVal < currentAccountVal) {
                highestAccountVal = currentAccountVal;
            }
        }

        return highestAccountVal;
    }

    public static void main(String[] args) {
        int[][] accounts = { { 6, 59, 64, 19, 30, 76, 71, 86, 90, 25, 56, 17, 19, 72, 61, 56, 24, 40, 35, 39, 67, 28,
                52, 11, 82, 72, 8, 82, 81, 47 } };

        int maxAccount = maximumWealth(accounts);

        System.out.println(maxAccount);
    }
}