package pratiquons;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VolDAO {

    private String url = "jdbc:mysql://localhost:3306/aeroprt";
    private String user = "root";   
    private String password = "";
    
    public List<vol>getvols(){
    	List<vol>vols = new ArrayList<>();
    	String selectSQL = "SELECT * FROM vol";
 
    	try (
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(selectSQL)){
    		
    		while(rs.next()) {
    			vol v1 = new vol (
    					rs.getString("numero_vol"),
    					rs.getString("ville_depart"),
    					rs.getString("ville_arrivee")
    					);
    					vols.add(v1);
    						 
    		}
    		System.out.println("Connexion réussie !");
		
	}
    catch(SQLException e) {
   	 System.out.println("excution error:"+e.getMessage());
    }
    	
	return vols;	
   }
   public void ajouterVol(vol vols) {
	   String insertSQL= "INSERT INTO vol (numero_vol,ville_depart,ville_arrivee) VALUES (?,?,?)";
	   try(
			   Connection conn = DriverManager.getConnection(url, user, password);
			   PreparedStatement ps = conn.prepareStatement(insertSQL)){
		   ps.setString(1, vols.getNumero_vol());
		   ps.setString(2, vols.getVille_depart());
		   ps.setString(3, vols.getVille_arrivee());
		   ps.executeUpdate();  
	   }catch(SQLException e) {
		   System.out.println("Erreur ajouter Vol: " + e.getMessage());
	   }
   }
   public void modifierDestination(String numero_vol ,  String nouvelle_destination) {
	   String insertSQL="UPDATE vol SET ville_arrivee = ? WHERE numero_vol = ?";
	   try(
			   Connection conn = DriverManager.getConnection(url, user, password);
			   PreparedStatement ps = conn.prepareStatement(insertSQL)
			   ){
		   ps.setString(1, nouvelle_destination);
           ps.setString(2, numero_vol);
           ps.executeUpdate();
	   }
	   catch(SQLException e) {
		   System.out.println("Erreur modifierDestination: " + e.getMessage());
	   }
   }
   public vol chercherVol(String numero_vol) {
	   String insertSQL="SELECT * FROM vol WHERE numero_vol = ?";
	   try(Connection conn = DriverManager.getConnection(url, user, password);
			   PreparedStatement ps = conn.prepareStatement(insertSQL)
			   ){
		   ps.setString(1, numero_vol);
		   ResultSet rs = ps.executeQuery();
		   
	   }
	   catch(SQLException e) {
		   System.out.println("Erreur chercherVol: " + e.getMessage());
		   
	   }
	   return null;
	   
   }

}
