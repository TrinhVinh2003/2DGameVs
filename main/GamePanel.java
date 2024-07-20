package main;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    static int originalTileSize = 16;
    static int scale =3;
    public final int tileSize = originalTileSize *3;
    public final int maxScreenCol =16;
    public final int maxScreenRow =12;
    int FPS =60; 
    public int i =0;

    public final int maxWorldCol =50;
    public final int maxWorldRow =50;
    public final int worldWidth  =tileSize*maxWorldCol;
    public final int worldHeight =tileSize*maxWorldRow;
    TileManager tileM = new TileManager(this);
    public final int screenWidth = tileSize * maxScreenCol;
    public final  int screenHeight = tileSize*maxScreenRow;
    Thread gameThread;
    public KeyHandler keyH = new KeyHandler(this);
    public CollisionChecker cChecker =new CollisionChecker(this);
    public Player player = new Player(this, keyH);
    public UI ui =new UI(this);
    public  int gameState;
    public int gamelevel;

    public int easy =1;
    public int normal =1;
    public int hard =1;
    public Entity npc[]  =new Entity[20];
    ArrayList<Entity> entityList  =new ArrayList<>();
    public  ArrayList<Entity> projectileList =new ArrayList<>();
    public final int titleState=0;
    public final int playState =1;
    public final int pauseState= 2;
    public final int LevelState=3;
    public final int GameOverState =4;
    public final int Winnerstate =5;
    public AssetSetter aSetter= new AssetSetter(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        
    }
    public void setupGame(){
        aSetter.setMonster(i);
        gameState = titleState;
    }
    public void retry(){
        player.setDeFaultPositions();
        player.restoreLifeAndMan();
        aSetter.setMonster(i);
    }
    public void restart(){
        player.setDeFaultValues();
        player.setDeFaultPositions();
        player.restoreLifeAndMan();
        aSetter.setMonster(i);
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime =System.nanoTime() + drawInterval;

        
        while(gameThread != null){
        
            
            update();

            repaint();
            try{
            double remainingTime =nextDrawTime -System.nanoTime();
            remainingTime = remainingTime/1000000;
            if(remainingTime<0 ){
                remainingTime=0;
            } 
            Thread.sleep((long) remainingTime);
            nextDrawTime += drawInterval;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            }
        }
    
    
    

    public void update() {
       
        if(gameState == playState){
            player.update();    
            for(int i =0;i< npc.length;i++){
                if(npc[i] !=null){
                    if(ui.Num ==0){
                        
                        
                    }
                    if(ui.Num ==1){
                        npc[i].speed = 3;
                       
                    }
                    if(ui.Num ==2){
                        npc[i].speed = 4;
                        
                    }
                    if(npc[i].alive == true && npc[i].dying ==false){
                        npc[i].update();
                    }
                    if(npc[i].alive ==false){
                        
                      
                        npc[i] = null;
                        
                    }
                }
                
            }
           
            
           
            for(int i =0;i< projectileList.size();i++){
                if(projectileList.get(i) !=null){
                    if(ui.Num ==0){
                        projectileList.get(i).speed = 10;
                    }
                    if(ui.Num ==1){
                        projectileList.get(i).speed =11;
                    }
                    if(ui.Num ==2){
                        projectileList.get(i).speed = 13;
                    }
                    if(projectileList.get(i).alive == true ){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive ==false){
                        projectileList.remove(i);
                    }
            }}
            
        }
        if(gameState == pauseState){

        }
      
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        long drawStart = 0;
        if (keyH.checkDrawTime ==true){
            drawStart= System.nanoTime();
        }

        if(gameState ==titleState){
            ui.draw(g2);
        }else{
            tileM.draw(g2);
            entityList.add(player);
            for(int i =0;i<npc.length;i++){
                if(npc[i] != null){
                    entityList.add(npc[i]);
                }
              
            }
            for(int i =0;i<projectileList.size();i++){
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
              
            }

            Collections.sort(entityList,new Comparator<Entity>(){
                public int compare(Entity o1, Entity o2){
                    int result = Integer.compare(o1.worldX,o2.worldY );
                    return result;
                }
            });
            for(int i = 0;i< entityList.size();i++){
                entityList.get(i).draw(g2);

            }
            entityList.clear();
        
            
            ui.draw(g2);
        }

        
        // debug
        if(keyH.checkDrawTime ==true){

        
            long drawEnd  = System.nanoTime();
            long passed =drawEnd - drawStart;
            g2.setColor(Color.white );
            g2.drawString("draw Time: "+passed,10, 400);  
            System.out.print("drawTime :"+passed);
        }
        g2.dispose();
    }



}
