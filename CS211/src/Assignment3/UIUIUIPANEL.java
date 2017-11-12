package Assignment3;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UIUIUIPANEL extends JPanel{
	JPanel Scores,Computer,Player;
	JLabel PScores,CSCores,PlayerIcon,ComputerIcon,PID,CID;
	// ImageIcon Starter; Starter Image
	private int PlayerScores=0,ComputerScores=0;
	public UIUIUIPANEL() {
		//Starter = new ImageIcon(); Starter Image
		Scores = new JPanel();
		Computer = new JPanel();
		Player = new JPanel();
		PScores = new JLabel("Player "+PlayerScores);
		CSCores = new JLabel("Computer "+ComputerScores);
		PlayerIcon = new JLabel("player.jpg"); 
		ComputerIcon = new JLabel("computer.jpg"); 
		PID = new JLabel("ME");
		CID = new JLabel("Computer");
		this.setLayout(new GridLayout(0, 3));
		Scores.setLayout(new GridLayout());
		Scores.add(PScores);
		Scores.add(CSCores);
		Computer.setLayout(new GridLayout());
		Computer.add(ComputerIcon);
		Computer.add(CID);
		Player.setLayout(new GridLayout());
		Player.add(PlayerIcon);
		Player.add(PID);
		this.add(Scores);
		this.add(Computer);
		this.add(Player);
	}
	public void setPlayerScores(int s){
		PlayerScores = s;
		System.out.println("3");
	}
	public void setComputerScores(int s){
		ComputerScores = s;
		System.out.println("4");
	}
	public void setScoresLabel(){
		PScores.setText("Player "+PlayerScores);
		CSCores.setText("Computer "+ComputerScores);
	}
	public void setComLabel(String t){
		ComputerIcon.setText(t);
	}
	public void setPlayerLabel(String t){
		PlayerIcon.setText(t);
	}
	public void resultTell(){
		if(PlayerScores>ComputerScores){
			JOptionPane.showMessageDialog(null, "You Win");
		}else if(PlayerScores<ComputerScores){
			JOptionPane.showMessageDialog(null, "You Lose");
		}else if(PlayerScores==ComputerScores){
			JOptionPane.showMessageDialog(null, "Draw");
		}
	}

}
