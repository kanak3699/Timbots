public class MericanoPlant extends Plant{

    public MericanoPlant(){
        name = "mericano";
        plantGrowth = 0;
        plantJolts = 0;
        harvest = 0;
    }
    public MericanoPlant(int m_count, int jolts, int growth) {
        name = "mericano";
        count=growth;                           // count = growth because they Are not initially ready for harvest (initial time remaining till harvest is growth time)
        plantGrowth = growth;
        plantJolts = jolts;
        harvest = 0;
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
