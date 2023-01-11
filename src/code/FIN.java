package code;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class FIN extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FIN frame = new FIN();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FIN() {
		String personne="dede";
		int score=9;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//recuperer la requete 
		/* ResultSet rs=null;
		
		rs= lireEnBase();
		int i=0;
		while(rs.next()){
	 		personne=rs.getString("personne");
			score=rs.getInt("score");
			g.setColor(new Color(0, 0, 0));
			g.drawString(personne, 25, 20+i);
			g.drawInt(score,50 , 20+i);
			i+=20;
			
		
		*/

		setContentPane(contentPane);
	}
	
	/**
	 * Affichage des 3 meilleurs résultats
	 **/
	public ResultSet lireEnBase() {
		//informations d'acces à la base de données 
		String url = "jdbc:mysql://localhost:3306/SOKOBAN";
		String login = "root";
		String passwd = "";
		Connection cn= null;
		Statement st=null;
		ResultSet rs=null;
		try {
			//Etape 1 : chargement du driver 
			Class.forName("com.mysql.jdbc.Driver");
			//Etape 2 : recuperation de la connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3 : Creation d'un statement
			st=cn.createStatement();
			String sql="SELECT DISTINCT(personne),score FROM SCORES ORDER BY score LIMIT(3) ";
			//Etape 4 : execution de la requete sql
			rs=st.executeQuery(sql);
			
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
		
	}

}
