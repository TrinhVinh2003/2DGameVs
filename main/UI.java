package main;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import entity.Entity;
import object.Obj_Heart;
    
public class UI {
    GamePanel gp;
    Graphics2D g2;
    BufferedImage heart1,heart2,heart3,heart4,heart5,heart6,heart7,heart8,heart9,sky;
    Font arial_40;
    Image image0;
    public int commandNum =0;
    public int Num =0;
    public int titleScreenState =0;
    public UI(GamePanel gp){
        this.gp= gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        Entity heart = new Obj_Heart(gp);
        heart1 =heart.image;
        heart2 =heart.image1;
        heart3 =heart.image2;
        heart4 =heart.image3;
        heart5 =heart.image4;
        heart6 =heart.image5;
        heart7 =heart.image6;
        heart8 =heart.image7;
        heart9 =heart.image8;
        sky =heart.image0; 
        
    }
    public void draw(Graphics2D g2) {
        this.g2=g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
       
        if(gp.gameState == gp.titleState){
            
            drawTitleScreen(g2);
        }
        if(gp.gameState == gp.LevelState){
            drawLevelScreen();
        }
        
        if(gp.gameState==gp.playState){
            drawplayerlife();      
        }
        if(gp.gameState== gp.pauseState){
            drawpausescreen();
            drawplayerlife();
        }
        if(gp.gameState ==gp.GameOverState){
            drawGameOverState();
        }
        if(gp.gameState ==gp.Winnerstate){
            drawWinnerstate();
        }
       
        
    }
    private void drawWinnerstate() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        int x;
        int y ;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110F));
        text ="Winner";
        g2.setColor(Color.black);
        x =getXforcenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);
        //main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);
        //retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text ="Retry";
        x = getXforcenteredText(text);
        y+=gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum ==0){
            g2.drawString("->", x-40, y);
            
        }
        text ="Quit";
        x =getXforcenteredText(text);
        y+=55;
        g2.drawString(text, x, y);
        if(commandNum ==1){
            g2.drawString("->", x-40, y);
            
        }
    }
    private void drawGameOverState() {
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0, gp.screenWidth, gp.screenHeight);
        int x;
        int y ;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,110F));
        text ="Game Over";
        g2.setColor(Color.black);
        x =getXforcenteredText(text);
        y = gp.tileSize*4;
        g2.drawString(text, x, y);
        //main
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);
        //retry
        g2.setFont(g2.getFont().deriveFont(50f));
        text ="Retry";
        x = getXforcenteredText(text);
        y+=gp.tileSize*4;
        g2.drawString(text,x,y);
        if(commandNum ==0){
            g2.drawString("->", x-40, y);
            
        }
        text ="Quit";
        x =getXforcenteredText(text);
        y+=55;
        g2.drawString(text, x, y);
        if(commandNum ==1){
            g2.drawString("->", x-40, y);
            
        }
    
    }
    private void drawLevelScreen() {
        g2.setColor(new Color(0,0,0));
        g2.drawImage(sky, 0, 0, null);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,70F));
        g2.setColor(Color.white);
        String text ="Easy";
        int x= gp.screenWidth/2 -(48*2);
        int y =48*5;
        g2.drawString(text, x, y);
        if(Num ==0){
            g2.drawString("->", x-48, y);
            
        }
        text ="Normal";
        x= gp.screenWidth/2 -(48*2);
        y+=48;
        g2.drawString(text, x, y);
        if(Num ==1){
            g2.drawString("->", x-48, y);
            
        }

        text ="Hard";
        x= gp.screenWidth/2 -(48*2);
        y+=48;
        g2.drawString(text, x, y);
        if(Num ==2){
            g2.drawString("->", x-48, y);
            
        }

    }
    public void drawpausescreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text ="PAUSE";
        int x = getXforcenteredText(text);
       
          
        int y = gp.screenHeight/2 ;
        g2.drawString(text, x, y);
    }
    public int getXforcenteredText(String text){
        int length =(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 -length/2;
        return x;
    
    }
    public void drawplayerlife() {
       
        int x =gp.tileSize/2;
        int y =gp.tileSize/2;
        
        if(gp.player.maxlife <= 1 ){
            g2.drawImage(heart9, x,y,null); }
        if(gp.player.maxlife== 2 ){
            g2.drawImage(heart8, x,y,null);}
        if(gp.player.maxlife== 3 ){ 
            g2.drawImage(heart7, x,y,null);}
        if(gp.player.maxlife== 4 ){ 
            g2.drawImage(heart6, x,y,null);}
        if(gp.player.maxlife== 5 ){ 
            g2.drawImage(heart5, x,y,null);}
        if(gp.player.maxlife== 6 ){ 
            g2.drawImage(heart4, x,y,null);}
        if(gp.player.maxlife== 7 ){ 
            g2.drawImage(heart3, x,y,null);}
        if(gp.player.maxlife== 8 ){ 
            g2.drawImage(heart2, x,y,null);}
        if(gp.player.maxlife== 9 ){ 
            g2.drawImage(heart1, x,y,null);}

      
      
    }
    
    
    public void drawTitleScreen(Graphics2D g2){
       

        g2.setColor(new Color(0,0,0));
        g2.drawImage(sky, 0, 0, null);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,70F));
        String text ="Game hay quá haha";
        
        int y =48 *3;
        g2.setColor(Color.gray);
        g2.drawString(text,105,y+5);
        g2.setColor(Color.red);
        g2.drawString(text,100, y); 
        //image character
        int x = gp.screenWidth/2 -(48*2)/2;
        y += 48*2;
        g2.drawImage(gp.player.down1, x,y,48*2,48*2,null);
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        
        text ="New Game";
        x= gp.screenWidth/2 -(48*2);
        y+=48*3.5;
        g2.drawString(text, x, y);
        if(commandNum ==0){
            g2.drawString("->", x-48, y);
            
        }
        text ="Level";
        x= gp.screenWidth/2 -(48*2);
        y+=48;
        g2.drawString(text, x, y);
        if(commandNum ==1){
            g2.drawString("->", x-48, y);
            
        }

        text =" Quit";
        x= gp.screenWidth/2 -(48*2);
        y+=48;
        g2.drawString(text, x, y);
        if(commandNum ==2){
            g2.drawString("->", x-48, y);
            
        }
        
         
    }
}
