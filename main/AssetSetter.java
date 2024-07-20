package main;

import monster.MON_GreenSlime;

public class AssetSetter{
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }
    public void setMonster(int i){
       
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*23;
        gp.npc[i].worldY = gp.tileSize*21;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*21;
        gp.npc[i].worldY = gp.tileSize*36;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*23;
        gp.npc[i].worldY = gp.tileSize*37;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*23;
        gp.npc[i].worldY = gp.tileSize*21;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*21;
        gp.npc[i].worldY = gp.tileSize*38;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*29;
        gp.npc[i].worldY = gp.tileSize*21;
        i++;
        gp.npc[i]=new MON_GreenSlime(gp);
        gp.npc[i].worldX = gp.tileSize*23;
        gp.npc[i].worldY = gp.tileSize*21;
    }
}