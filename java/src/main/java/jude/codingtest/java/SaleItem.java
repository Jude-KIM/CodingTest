package jude.codingtest.java;

public class SaleItem implements Comparable<SaleItem> {

    int id,count;
    public SaleItem(int id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public int compareTo(SaleItem saleItem) {
        return this.count - saleItem.count;
    }
}
