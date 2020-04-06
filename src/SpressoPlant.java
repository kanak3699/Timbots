public class SpressoPlant extends Plant {
    public SpressoPlant(){
        name = "spresso";
        plantGrowth = 0;
        plantJolts = 0;
    }
    public SpressoPlant(int  s_count, int jolts, int growth) {
        name = "spresso";
        count=s_count;
        plantGrowth = growth;
        plantJolts = jolts;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPlantGrowth(int growth) {
        this.plantGrowth = growth;
    }

    public void setPlantJolts(int jolts) {
        this.plantJolts = jolts;
    }

    public String getName(){
        return name;
    }

    public int getGrowth(){
        return plantGrowth;
    }
    public int getPlantJolts(){
        return plantJolts;
    }

}