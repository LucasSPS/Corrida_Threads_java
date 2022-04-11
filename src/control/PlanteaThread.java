package control;

import java.util.Random;
import javax.swing.*;

public class PlanteaThread extends JLabel implements Runnable {
        private Thread carroThread = null;
        private int posX;
        private int posY;
        private ImageIcon imagem;
        private String nome;
        public static int pos=0;
        // CONSTRUTOR DEFAULT
        public PlanteaThread() {

        }
        // CONSTRUTOR SOBRECARREGADO
        public PlanteaThread(String nome, ImageIcon img, int posX, int posY){
            super(img);
            this.nome=nome;
            this.imagem = img;
            this.posX = posX;
            this.posY = posY;

            carroThread = new Thread(this, nome);
            carroThread.start();

        }
        // MÉTODO RUN() DA INTERFACE RUNNABLE
        @Override
        public void run() {
            posX += new Random().nextInt(3) * 10;
            this.setLocation(posX, posY);

            if (posX >= 1280) {

                pos++;

                JOptionPane.showMessageDialog(null, pos+")"+nome);

                return;

            }

            try {
                Thread.sleep(new Random().nextInt(5) * 10);
                run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

