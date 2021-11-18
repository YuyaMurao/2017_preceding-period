package kadai06;

public class Product {
    private String productName;
    private int purchasePrice = 0;//仕入れ価格
    private int sellingPrice = 0;//販売価格
    private int profits = 0;//利益

    public void profits(){
        profits = sellingPrice - purchasePrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setProfits(int profits) {
        this.profits = profits;
    }

    public String getProductName() {
        return productName;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getProfits() {
        return profits;
    }
}
