package entity;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.Color;

import main.GamePanel;
import main.UtilityTool;

import java.awt.Rectangle;
public class Entity{
    GamePanel gp;
  
    public String name;
    public boolean collision =false;
    public int worldX,worldY;
    public Rectangle solidArea =new Rectangle(0,0,48,48);
    public  Rectangle attackArea  = new Rectangle(0,0,0,0);
    public int speed;
    public BufferedImage up1 ,up2,down1, down2 ,left1,left2 ,right1,right2;
    public BufferedImage attackup1,attackup2,attackdown1,attackdown2,attackleft1,attackleft2,attackright1,attackright2;
    public String direction;
    boolean attacking =false;
    public BufferedImage image,image1,image2,image3,image4,image5,image6,image7,image8,image0;
    public int Standcounter =0;
    public int spriteCounter = 0;
    public int spriteNum =1;
    public int actionLockCounter = 0;
    public boolean invincible  =false;
    public int invincibleCounter =0;
    public int shotAvailableCounter =0;
   
    public int dyingCounter=0;
    public boolean collisionOn =false;
    public int solidAreaDefaildY,solidAreaDefaultX;
    public int usecost;
    public boolean alive =true;
    public boolean dying =false;
    public int defaultspeed;
    public boolean hpOn  =false;

    public int kill =0;
    //Character status
    public int type;
    public int maxmana;
    public int attack;
    public int mana;
    public int hp;
    public int maxlife;
    public int life;
    public int hpCounter=0;
    public ProjectTile projectile;
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX  = worldX - gp.player.worldX +gp.player.screenX;
        int screenY  = worldY - gp.player.worldY +gp.player.screenY;
        if(worldX + gp.tileSize >gp.player.worldX -gp.player.screenX && 
            worldX - gp.tileSize < gp.player.worldX +gp.player.screenX &&
            worldY +gp.tileSize > gp.player.worldY -gp.player.screenY &&
            worldY -gp.tileSize < gp.player.worldY +gp.player.screenY ){
            
                switch(direction){
                case "up":
                    if(spriteNum ==1){
                            image =up1;
                    }
                    if(spriteNum ==2){
                        image =up2;
                    }
                    break;
                case "down":
                    if(spriteNum ==1){
                        image =down1;
                    }
                    if(spriteNum ==2){
                        image =down2;
                    }
                    break;
                case "left":
                    if(spriteNum ==1){
                        image =left1;
                    }
                    if(spriteNum ==2){
                            image =left2;
                        }
                        break;
                case "right":
                    if(spriteNum ==1){
                        image =right1;
                    }
                    if(spriteNum ==2){
                        image =right2;
                         }
                    break;
                }
                if(invincible ==true){
                    hpOn =true;
                    hpCounter=0;
                    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.3f));
                }
                if(dying ==true){
                    dying =false;
                    alive =false;
                }
                if(type ==2 && hpOn ==true){
                    if(life==4){
                        hp =gp.tileSize;
                    }
                    
                    if(life==3){
                        hp =gp.tileSize -12;
                    }
                    if(life==2){
                        hp =gp.tileSize -24;
                    } 
                    if(life==1){
                        hp =gp.tileSize -36;
                    }
                    g2.setColor(new Color(35,35,35));
                    g2.fillRect(screenX-1, screenY-16, gp.tileSize+2, 12);
                    g2.setColor(new Color(255,0,30));
                    g2.fillRect(screenX, screenY-15,hp, 10);
                    hpCounter++;
                    if(hpCounter>=600){
                        hpCounter =0;
                        hpOn= false;
                    }
                }   
                
                g2.drawImage(image,screenX  ,screenY,null);
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
            }
            
            
               
            
    }
    public void damagePlayer(int attack){
        if(gp.player.invincible==false){
            gp.player.maxlife -=1;
            gp.player.invincible = true;
        }   
    }
   

    public void setAction(){

    }
    public void update(){
        setAction();
        collisionOn =false;
        gp.cChecker.checkTile(this);
        boolean contractPlayer = gp.cChecker.CheckPlayer(this);
        if(this.type == 2 && contractPlayer ==true){
            damagePlayer(attack);
        }
        if(collisionOn ==false){
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
        spriteCounter++;
        if(spriteCounter >12){
            if (spriteNum ==1){
                spriteNum =2;
            } else if(spriteNum ==2){
                spriteNum =1;
            }
            spriteCounter =0;
        }
        
        if(invincible ==true){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible =false;
                invincibleCounter = 0;
            }
        }
        if(shotAvailableCounter<30){
            shotAvailableCounter++;
        }
        
        
      
    }
    
    public BufferedImage setup(String imagePath,int width,int height){
        UtilityTool uTool =new UtilityTool();
        BufferedImage image= null;
        try{
            image  =ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
            image =uTool.scaleImage(image, width,height);

        }catch(IOException e){
            e.printStackTrace();

        }
        return image;
    }

    

    



}