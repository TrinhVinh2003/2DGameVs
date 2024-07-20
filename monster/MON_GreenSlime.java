package monster;


import java.util.Random;

import entity.Entity;
import main.GamePanel;
import object.OBJ_Rock;


public class MON_GreenSlime extends Entity {
    GamePanel gp;
    public MON_GreenSlime(GamePanel gp){
        super(gp);
        this.gp =gp;
        direction ="down";

        type =2;
        defaultspeed = 1;
        
        name ="monster";
        speed  =defaultspeed;
        life = 4;
        projectile =new OBJ_Rock(gp);
        
        solidArea.x = 8;
        solidArea.y= 16;
        solidArea.width=32;
        solidArea.height=32;
        getImage();

        

    }   
  
    

    public void getImage(){
        up1= setup("/res/monster/boy_up_1",gp.tileSize,gp.tileSize);
        up2= setup("/res/monster/boy_up_2",gp.tileSize,gp.tileSize);
        down1= setup("/res/monster/boy_down_1",gp.tileSize,gp.tileSize);
        down2= setup("/res/monster/boy_down_2",gp.tileSize,gp.tileSize);
        left1= setup("/res/monster/boy_left_1",gp.tileSize,gp.tileSize);
        left2= setup("/res/monster/boy_left_2",gp.tileSize,gp.tileSize);
        right1= setup("/res/monster/boy_right_1",gp.tileSize,gp.tileSize);
        right2= setup("/res/monster/boy_right_2",gp.tileSize,gp.tileSize);
      }
    public void setAction(){
        
        actionLockCounter++;
        if(actionLockCounter ==120){
            Random random =new Random();
            int i =random.nextInt(100)+1;
            if(i<= 25){
                direction="up";

            }
            if(i>25&& i<=50){
                direction ="down";

            }
            if(i>50 && i<=75){
                direction = "left";
            
            }
            if(i>75 && i<=100){
                direction ="right";

            }
            actionLockCounter=0;
            
    }
        
        int i = new Random().nextInt(100)+1;
        if(i>99 && projectile.alive ==false &&shotAvailableCounter ==30 ){
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
            shotAvailableCounter =0;
        }
}


    
}
