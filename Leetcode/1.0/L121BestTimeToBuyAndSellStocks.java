class L121BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE, minPrice = prices[0];
        for(int priceToday: prices){
            minPrice = Math.min(minPrice, priceToday);
            maxProfit = Math.max(maxProfit, priceToday - minPrice);
        }
        return maxProfit;
    }
}