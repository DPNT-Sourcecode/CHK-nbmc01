package befaster.solutions.CHK;

public class Item {
    private char sku;
    private int fullPrice;

    public Item(char sku, int fullPrice) {
        this.sku = sku;
        this.fullPrice = fullPrice;
    }

    public char getSku() {
        return sku;
    }

    public void setSku(char sku) {
        this.sku = sku;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }
}

