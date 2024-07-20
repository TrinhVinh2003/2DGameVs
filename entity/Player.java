package entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;



import main.GamePanel;
import main.KeyHandler;
import object.OBJ_FireBall;


public class Player extends Entity {
  
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY =gp.screenHeight/2- (gp.tileSize/2);
        attacking =false;
        solidArea.x = 37;
        solidArea.y= 40;
        solidArea.width=32;
        solidArea.height=32;
        attackArea.width =36;
        attackArea.height =36;
        setDeFaultValues();
        getPlayerImage();
        getAttackImage();
    }
    public void setDeFaultPositions(){
        worldX =gp.tileSize*21;
        worldY =gp.tileSize*21;
        direction ="down";

    }
    public void restoreLifeAndMan(){
        maxlife = 9;
        invincible =false;
        kill=0;
        
    }
    public void setDeFaultValues(){
        worldX = gp.tileSize*21;
        worldY =gp.tileSize*21;
        speed = 4;
        direction ="down";
        //  Player status
        maxlife = 9;
        projectile =new OBJ_FireBall(gp);
        //attack =getAttack();
       
        }
    /**
     * 
     */
    public void getPlayerImage(){
        up1= setup("/res/player/boy_up_1",gp.tileSize,gp.tileSize);
        up2= setup("/res/player/boy_up_2",gp.tileSize,gp.tileSize);
        down1= setup("/res/player/boy_down_1",gp.tileSize,gp.tileSize);
        down2= setup("/res/player/boy_down_2",gp.tileSize,gp.tileSize);
        left1= setup("/res/player/boy_left_1",gp.tileSize,gp.tileSize);
        left2= setup("/res/player/boy_left_2",gp.tileSize,gp.tileSize);
        right1= setup("/res/player/boy_right_1",gp.tileSize,gp.tileSize);
        right2= setup("/res/player/boy_right_2",gp.tileSize,gp.tileSize);
      }
   
      public void getAttackImage(){
        attackup1= setup("/res/player/boy_attack_up_1",gp.tileSize,gp.tileSize*2);
        attackup2= setup("/res/player/boy_attack_up_2",gp.tileSize,gp.tileSize*2);
        attackdown1= setup("/res/player/boy_attack_down_1",gp.tileSize,gp.tileSize*2);
        attackdown2= setup("/res/player/boy_attack_down_2",gp.tileSize,gp.tileSize*2);
        attackleft1= setup("/res/player/boy_attack_left_1",gp.tileSize*2,gp.tileSize);
        attackleft2= setup("/res/player/boy_attack_left_2",gp.tileSize*2,gp.tileSize);
        attackright1= setup("/res/player/boy_attack_right_1",gp.tileSize*2,gp.tileSize);
        attackright2= setup("/res/player/boy_attack_right_2",gp.tileSize*2,gp.tileSize);
      }
    public void update(){
        if(attacking ==true ){
            attacking1();
            
        }
        else if(keyH.upPressed ==true || keyH.downPressed ==true ||keyH.leftPressed==true|| keyH.rightPressed ==true||keyH.spacePressed ==true){
            if(keyH.upPressed ==true    ){
                direction = "up";
            }
            else if(keyH.downPressed ==true){
                direction ="down";
            }
            else if(keyH.leftPressed ==true){
                direction = "left";
        
            }
            else if(keyH.rightPressed ==true){
                direction ="right";
        
            }
         
            collisionOn  =false;
            gp.cChecker.checkTile(this);
            if(keyH.spacePressed==true){
                attacking = true;
            }

            int npcindex = gp.cChecker.checkEntity(this, gp.npc);
            contractMonster(npcindex);
            
           
            
            //if colision =false , player can move
            if(collisionOn ==false && gp.keyH.spacePressed ==false ){
                switch(direction){
                case "up": 
                    worldY -= speed;
                    break;
                case "down":    
                    worldY+=speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX +=speed;
                    break;
                }
            }
            gp.keyH.spacePressed =false;
            
            spriteCounter++;
            if(spriteCounter >12){
                if (spriteNum ==1){
                    spriteNum =2;
                } else if(spriteNum ==2){
                    spriteNum =1;
                }
                spriteCounter =0;
            }
          
        } else {
            Standcounter++;
            if(Standcounter==20){
                spriteNum =1;
                Standcounter =0;
            
        }
        if(gp.keyH.shotKeyPressed ==true &&projectile.alive ==false){
            projectile.set(worldX, worldY, direction, true, this);
            gp.projectileList.add(projectile);
        }
        if(invincible ==true){
            invincibleCounter++;
            if(invincibleCounter>30){
                invincible =false;
                invincibleCounter = 0;
            }
        }
        if(maxlife >9){
            maxlife =9;
        }
        if(maxlife <=0){
            gp.gameState =gp.GameOverState;
        }
    }
    }
    private void attacking1() {
        spriteCounter++;
        if(spriteCounter<=5){
            spriteNum =1;
        }
        if(spriteCounter >5 && spriteCounter <=25){
            spriteNum =2;
            int currentWorldX =worldX;
            int currentWorldY= worldY;
            int solidAreaWidth= solidArea.width;
            int solidAreaHeight = solidArea.height;

            switch(direction){
            case "up": worldY-=attackArea.height;break;
            case "down":worldY+=attackArea.height;break;
            case "left":worldX-=attackArea.width;break;
            case "right":worldX+=attackArea.width;break;

            }
            solidArea.width =attackArea.width;
            solidArea.height  =attackArea.height;

            int monsterIndex = gp.cChecker.checkEntity(this, gp.npc);
            damageMonster(monsterIndex,attack);
            worldX =currentWorldX;
            worldY =currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height =solidAreaHeight;

        }
        if(spriteCounter>25){
            spriteNum =1;
            spriteCounter=0;
            attacking =false;
        }
        
    }
    void damageMonster(int i, int attack) {
        if(i!=999){

            if(gp.npc[i].invincible ==false){
                
                gp.npc[i].life -=1;
                gp.npc[i].invincible =true;
                
                if(gp.npc[i].life <=0){
                    gp.npc[i]=null;
                    kill +=1;
                }
            }
        }
   
        if(kill ==7){
            gp.gameState =gp.Winnerstate;
        }
    }
    public void contractMonster(int i){
        if(i != 999){
            if(invincible ==false){
                maxlife-=1;
                invincible =true;
            }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY  =screenY;
        switch(direction){
            case "up":
                if(attacking ==false){
                    if(spriteNum ==1){image =up1;}
                    if(spriteNum ==2){image =up2;}
                }
                if(attacking ==true){
                    tempScreenY = screenY -gp.tileSize;
                    if(spriteNum ==1){image =attackup1;}
                    if(spriteNum ==2){image =attackup2;}
                }
                break;
            case "down":
                if(attacking ==false){
                    if(spriteNum ==1){ image =down1;}
                    if(spriteNum ==2){ image =down2;}
                }
                if(attacking ==true){
                    if(spriteNum ==1){ image =attackdown1;}
                    if(spriteNum ==2){ image =attackdown2;}}
                break;
            case "left":
                
                if(attacking ==false){
                    if(spriteNum ==1){image =left1;}
                    if(spriteNum ==2){image =left2;}}
                if(attacking ==true){
                    tempScreenX = screenX -gp.tileSize;
                    if(spriteNum ==1){image =attackleft1;}
                    if(spriteNum ==2){image =attackleft2;}}
                break;
            case "right":
                if(attacking ==false){
                    if(spriteNum ==1){image =right1;}
                    if(spriteNum ==2){image =right2;}}
                if(attacking == true){
                    if(spriteNum ==1){image =attackright1;}
                    if(spriteNum ==2){image =attackright2;}}
                break;
        }
        g2.drawImage(image,tempScreenX  ,tempScreenY,null);
        //g2.setFont(new Font("Arial",Font.PLAIN,26));
        //g2.setColor(Color.white);
        //g2.drawString("Invinciable:"+invincibleCounter,10 , 400);
    }
    
}
