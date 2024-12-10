// User function Template for C

int maximumProfit(int prices[], int pricesSize) {
    if (pricesSize <= 1) return 0; // No profit if less than 2 prices
    
    int minPrice = prices[0];
    int maxProfit = 0;
    
    for (int i = 1; i < pricesSize; i++) {
        // Update the minimum price encountered so far
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }
        // Calculate profit and update maximum profit if applicable
        int profit = prices[i] - minPrice;
        if (profit > maxProfit) {
            maxProfit = profit;
        }
    }
    
    return maxProfit;
}