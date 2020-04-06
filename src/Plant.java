public class Plant {
    protected String name;
    protected int count = 0;
    protected int X_coord = 0;
    protected int Y_coord = 0;
    protected int plantJolts = 0;
    protected int plantGrowth = 0;
    protected int harvest;

    protected void setVal(int jolts, int growth){
        this.plantJolts = jolts;
        this.plantGrowth = growth;
    }

    public boolean isNotHarvested(){
        if(this.harvest == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public void setHarvested(){
        this.harvest=1;
    }

    public void resetCount(){
        this.count=this.plantGrowth;
    }

    public int getCounter() {
        return count;
    }

    public void setX_coord(int X_coord){
        this.X_coord = X_coord;
    }

    public void setY_coord(int Y_coord){
        this.Y_coord = Y_coord;
    }

    public int getX_coord(){
        return X_coord;
    }

    public int getY_coord(){
        return Y_coord;
    }

}
