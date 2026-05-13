package edu.teamrocket.domain;

public class Backstage extends NormalItem{
    
    public Backstage(String name, int sellIn, int quality) {
        super(name, quality, sellIn);
    }

    @Override
    public void updateQuality() {
        if (this.getSellIn() > 10) {
            this.computeQuality(this.getQuality() + 1);
        } else if (this.getSellIn() > 5) {
            this.computeQuality(this.getQuality() + 2);
        } else if (this.getSellIn() > 0) {
            this.computeQuality(this.getQuality() + 3);
        } else {
            this.computeQuality(0);
        }
        this.setSellIn();
    }

    @Override
    protected void computeQuality(int quality) {
        super.computeQuality(Math.min(quality, 50));
    }
}