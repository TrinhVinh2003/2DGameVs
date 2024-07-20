package object;

import entity.ProjectTile;
import main.GamePanel;

public class OBJ_FireBall extends ProjectTile {
    GamePanel gp;
    public OBJ_FireBall(GamePanel gp){
        super(gp);
        this.gp =gp;
        name ="fireBall";
        speed =10;
        maxlife =80;
        life =maxlife;
        attack =2;
        usecost =1;
        alive =false;
        getImage();
    
    }
    public void getImage(){
        up1 = setup("/res/fire/c",gp.tileSize, gp.tileSize);
        up2 = setup("/res/fire/c",gp.tileSize, gp.tileSize);
        down1 = setup("/res/fire/b",gp.tileSize, gp.tileSize);
        down2 = setup("/res/fire/b",gp.tileSize, gp.tileSize);
        left1 = setup("/res/fire/d",gp.tileSize, gp.tileSize);
        left2 = setup("/res/fire/d",gp.tileSize, gp.tileSize);
        right1 = setup("/res/fire/a",gp.tileSize, gp.tileSize);
        right2 = setup("/res/fire/a",gp.tileSize, gp.tileSize);
    }
    
}
