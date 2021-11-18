package kadai06;

public class Food extends Product{
    private int expirationDate;//賞味期限
    private String unit;//販売単位
    private int quantity;//販売量
    private int benefitPerUnit;//単位当たりの利益
    
    public void BenefitPerUnit(){
        benefitPerUnit = super.getProfits() / quantity;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBenefitPerUnit() {
        BenefitPerUnit();
        return benefitPerUnit;
    }
}
