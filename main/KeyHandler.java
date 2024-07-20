package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{
    GamePanel gp;
    public boolean upPressed,downPressed,leftPressed , rightPressed,spacePressed,shotKeyPressed;
    boolean checkDrawTime =false;
    public KeyHandler(GamePanel gp){
        this.gp =gp;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
        int code =e.getKeyCode();
        if(gp.gameState== gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum =2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum =0;
                }
            }
           
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum ==0){
                    gp.gameState =gp.playState;
                }
                if(gp.ui.commandNum==1){
                    gp.gameState = gp.LevelState;
                }
                if(gp.ui.commandNum == 2){
                    System.out.print("dddd");
                    System.exit(0);
                }
            }
        }


        
    
        else if(gp.gameState == gp.playState){
            if(code == KeyEvent.VK_W){
                upPressed = true;
            }
            else if(code == KeyEvent.VK_S){
                downPressed= true;

            }
            else if(code == KeyEvent.VK_A){
                leftPressed =true;
            }
            else if(code == KeyEvent.VK_D){
                rightPressed =true;
            }
            else if(code == KeyEvent.VK_P){
                if(gp.gameState == gp.playState){
                    gp.gameState = gp.pauseState;

                }
                if(gp.gameState == gp.pauseState){
                  
                    gp.gameState = gp.playState;
                }
            }
            else if(code == KeyEvent.VK_T){
                if(checkDrawTime ==false){
                    checkDrawTime =true;
                }else if(checkDrawTime ==true){
                    checkDrawTime =false;
                }
                
            }
            else if(code == KeyEvent.VK_F){
                shotKeyPressed =true;
            }
            else if(code ==KeyEvent.VK_SPACE){
               
                    spacePressed = true;
            }
        }
        else if(gp.gameState ==gp.LevelState){
            if(code == KeyEvent.VK_W){
                gp.ui.Num--;
                if(gp.ui.Num<0){
                    gp.ui.Num =2;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.Num++;
                if(gp.ui.Num>2){
                    gp.ui.Num =0;
                }
            }
           
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.Num ==0){
                    
                    gp.gameState =gp.playState;
                  
                }
                if(gp.ui.Num==1){
                    gp.gameState = gp.playState;
                }
                if(gp.ui.Num == 2){

                    gp.gameState = gp.playState;
                }
            }
            }
        else if(gp.gameState ==gp.GameOverState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum =1;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum =0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum ==0){
                    gp.gameState =gp.playState;
                    gp.retry();
                }
                else if(gp.ui.commandNum==1){
                    gp.gameState = gp.titleState;
                    gp.restart();
                }
                
            }
        }
        else if(gp.gameState ==gp.Winnerstate){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum =1;
                }
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>1){
                    gp.ui.commandNum =0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum ==0){
                    gp.gameState =gp.playState;
                    gp.retry();
                }
                else if(gp.ui.commandNum==1){
                    gp.gameState = gp.titleState;
                    gp.restart();
                }
                
            }
        }
        }
        
    
        
    
    //}

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        int code =e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed=false;

        }
        if(code == KeyEvent.VK_A){
            leftPressed =false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed =false;
        }
        if(code == KeyEvent.VK_F){
            shotKeyPressed =false;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
