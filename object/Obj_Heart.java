package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

public class Obj_Heart extends Entity{
    GamePanel gp;

 
    UtilityTool uTool =new UtilityTool();
    public Obj_Heart(GamePanel gp){
        super(gp);
        this.gp =gp;
        name ="Heart";
        try{
            image =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau1.png"));
            image1 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau2.png"));
            image2 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau3.png"));
            image3 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau4.png"));
            image4 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau5.png"));
            image5 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau6.png"));
            image6 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau7.png"));
            image7 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau8.png"));
            image8 =ImageIO.read(getClass().getResourceAsStream("/res/mau/mau9.png"));
            image0 = ImageIO.read(getClass().getResourceAsStream("/res/skyimage/sky.png"));
            image= uTool.scaleImage(image,gp.tileSize*3,gp.tileSize*2);
            image1 =uTool.scaleImage(image1,gp.tileSize*3,gp.tileSize*2);
            image2 =uTool.scaleImage(image2,gp.tileSize*3,gp.tileSize*2);
            image3=uTool.scaleImage(image3,gp.tileSize*3,gp.tileSize*2);
            image4 =uTool.scaleImage(image4,gp.tileSize*3,gp.tileSize*2);
            image5 =uTool.scaleImage(image5,gp.tileSize*3,gp.tileSize*2);
            image6 =uTool.scaleImage(image6,gp.tileSize*3,gp.tileSize*2);
            image7 =uTool.scaleImage(image7,gp.tileSize*3,gp.tileSize*2);
            image8= uTool.scaleImage(image8,gp.tileSize*3,gp.tileSize*2);
            image0 = uTool.scaleImage(image0,gp.screenWidth,gp.screenHeight);

            


        }catch(IOException e){
            e.printStackTrace();
        }

    }

}