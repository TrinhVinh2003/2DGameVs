package object;

import entity.ProjectTile;
import main.GamePanel;

public class OBJ_Rock extends ProjectTile {
    GamePanel gp;
    public OBJ_Rock(GamePanel gp){
        super(gp);
        this.gp =gp;
        name ="rock";
        speed =3;
        maxlife =100;
        life =maxlife;
        attack =2;
        usecost =1;
        alive =false;
        getImage();
    
    }
    public void getImage(){
        up1 = setup("/res/fire/fireball_up_1",gp.tileSize, gp.tileSize);
        up2 = setup("/res/fire/fireball_up_2",gp.tileSize, gp.tileSize);
        down1 = setup("/res/fire/fireball_down_1",gp.tileSize, gp.tileSize);
        down2 = setup("/res/fire/fireball_down_2",gp.tileSize, gp.tileSize);
        left1 = setup("/res/fire/fireball_left_1",gp.tileSize, gp.tileSize);
        left2 = setup("/res/fire/fireball_left_2",gp.tileSize, gp.tileSize);
        right1 = setup("/res/fire/fireball_right_1",gp.tileSize, gp.tileSize);
        right2 = setup("/res/fire/fireball_right_2",gp.tileSize, gp.tileSize);
    }
}
