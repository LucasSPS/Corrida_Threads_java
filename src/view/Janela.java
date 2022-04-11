package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.PlanteaThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgPlaneta1;
    private ImageIcon imgPlaneta2;
    private ImageIcon imgPlaneta3;
    private ImageIcon pista;
    private ImageIcon velocimetro;

    public Janela() {
        super();
        // ADICIONANDO ELEMENTOS AO FORMULÁRIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);

        this.setTitle("Corrida de planetas");
        velocimetro = new ImageIcon("./src/imagens/velocimetro.gif");
        pista = new ImageIcon("./src/imagens/fundo.jpg");

        this.lblPista = new JLabel(pista);
        this.lblVelocimetro = new JLabel(velocimetro);
        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblVelocimetro.setBounds(200, 490, 150, 150);
        this.lblPista.setBounds(0, 0, 1920, 1280);

        this.add(lblPista);
        this.lblPista.add(lblVelocimetro);

        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Start Corrida");
        this.btnCancel = new JButton("Stop Corrida");
        // POSIONADO OS BOTÕES
        this.btnCorrida.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
        // INSERINDO AS IMAGENS DOS CARROS
        imgPlaneta1 = new ImageIcon("./src/imagens/planeta1.png");
        imgPlaneta2 = new ImageIcon("./src/imagens/planeta2.png");
        imgPlaneta3 = new ImageIcon("./src/imagens/planeta3.png");

        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("[Grupo de Trabalho]"));
        jPanel.setVisible(true);

        this.repaint();

    }
    // INSERINDO AS JLABELS DOS CARROS
    public JLabel JLabelCarros(String nome, ImageIcon img, int posX, int posY) {
        PlanteaThread planeta = new PlanteaThread(nome, img, posX, posY);
        planeta.setSize(360, 300);
        planeta.setVisible(true);
        this.add(planeta);
        return planeta;
    }
    // PROGRAMANDO A AÇÃO DOS BOTÕES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida) {
            this.lblPista.add(JLabelCarros(" Planeta 1", imgPlaneta1, 0, 50));
            this.lblPista.add(JLabelCarros(" Planeta 2", imgPlaneta2, 0, 200));
            this.lblPista.add(JLabelCarros(" Planeta 3", imgPlaneta3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}