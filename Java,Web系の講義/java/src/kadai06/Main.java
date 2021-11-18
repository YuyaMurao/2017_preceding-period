
package kadai06;

public class Main {
    
    //日用品クラスにセット
    public static void FunctionDaily(DailyNecessities daily){
        daily.setProductName("リセッシュ");
        daily.setPurchasePrice(300);
        daily.setSellingPrice(440);
        daily.setManufacturer("花王");
        daily.profits();
    }
    
    //食品クラスにセット
    public static void FunctionFood(Food food){
        food.setProductName("ローストビーフ");
        food.setPurchasePrice(5460);
        food.setSellingPrice(7800);
        food.setExpirationDate(20190101);
        food.setUnit("g");
        food.setQuantity(100);
        food.profits();
    }
    
    //日用品出力
    public static void outputDaily(DailyNecessities daily){
        System.out.println("【日用品】");
        System.out.println("商品名："+ daily.getProductName());
        System.out.println("仕入れ価格："+ daily.getPurchasePrice() + "円");
        System.out.println("販売価格："+ daily.getSellingPrice() + "円");
        System.out.println("製造元：" + daily.getManufacturer());
        System.out.println("利益："+ daily.getProfits() + "円");
        System.out.println();
    }

    //食品出力    
    public static void outputFood(Food food){
        System.out.println("【食品】");
        System.out.println("商品名："+ food.getProductName());
        System.out.println("仕入れ価格："+ food.getPurchasePrice() + "円");
        System.out.println("販売価格："+ food.getSellingPrice() + "円");
        System.out.println("利益："+ food.getProfits() + "円");
        System.out.println("賞味期限：" + food.getExpirationDate());
        System.out.println("内容量：" + food.getQuantity() + food.getUnit());
        System.out.println("単位当たりの利益："+ food.getBenefitPerUnit() + "円/" + food.getUnit());
    }
    
    public static void main(String []args){
        DailyNecessities daily = new DailyNecessities();
        Food food = new Food();
        
        FunctionDaily(daily);
        FunctionFood(food);
        outputDaily(daily);
        outputFood(food);
    }
}
