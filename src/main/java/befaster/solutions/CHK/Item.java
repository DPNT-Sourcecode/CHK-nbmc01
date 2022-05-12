package befaster.solutions.CHK;

public class Item {
    private char SKU;
    private int fullPrice;

    public Item(char SKU, int fullPrice) {
        this.SKU = SKU;
        this.fullPrice = fullPrice;
    }

    public char getSKU() {
        return SKU;
    }

    public void setSKU(char SKU) {
        this.SKU = SKU;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }
}
