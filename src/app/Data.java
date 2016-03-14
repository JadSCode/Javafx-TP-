package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Etudiant;
import util.DateHelper;

public class Data extends DataSet {

	
	private ObservableList<Etudiant> dataEtudiant = FXCollections.observableArrayList();
	
	
	
	public Data(){
		

	}
	
	public ObservableList<Etudiant> getDataEtudiant() {
		Connection dbConn = null;
		try{
			dbConn = DBConnection.createConnection();
			if(dbConn == null) 
				throw new Exception("DataSet sql connection pb");
			
			Statement stmt = dbConn.createStatement();
			String query = "SELECT * FROM etudiants";
			ResultSet res = stmt.executeQuery(query);
			while(res.next()){
				
				String codeEtudiant = res.getString(1);
				String nom 			= res.getString(2);
				String prenom 		= res.getString(3);
				String dateDeNaissance = res.getString(4);
				String Master = res.getString(5);
				int Semestre  = res.getInt(6);
				
				dataEtudiant.add(new Etudiant(codeEtudiant, nom, prenom, DateHelper.parse(dateDeNaissance), Master, Semestre));
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(dbConn != null){
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dataEtudiant;
		
	}
	
	
	public Etudiant lookup(String codeEtudiant){
		Connection dbConn = null;
		Etudiant found = null;
		try{
			dbConn = DBConnection.createConnection();
			if(dbConn == null) 
				throw new Exception("DataSet sql connection pb");
			
			
			PreparedStatement stmt = dbConn.prepareStatement("SELECT * FROM etudiants WHERE codeEtudiant=? LIMIT 1");
			stmt.setString(1, codeEtudiant.trim());			
			ResultSet res = stmt.executeQuery();
			while (res.next()){
				
				String nom 			= res.getString(2);
				String prenom 		= res.getString(3);
				String dateDeNaissance = res.getString(4);
				String Master = res.getString(5);
				int Semestre  = res.getInt(6);
				found  = new Etudiant(codeEtudiant, nom, prenom, DateHelper.parse(dateDeNaissance), Master, Semestre);

			}
			
			
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if(dbConn != null){
				try {
					dbConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
			
		return found;
	}
	
	public void addEtudiant(Etudiant emp){
		
		if(lookup(emp.getCodeEtudiant()) == null){
			Connection dbConn = null;
			try{
				dbConn = DBConnection.createConnection();
				if(dbConn == null) 
					throw new Exception("DataSet sql connection pb");
				
				String query = "INSERT INTO etudiants values (?,?,?,?,?,?) ";
				PreparedStatement prepInsert = dbConn.prepareStatement(query);
				prepInsert.setString(1,emp.getCodeEtudiant());
				prepInsert.setString(2, emp.getNom());
				prepInsert.setString(3,emp.getPrenom());
				prepInsert.setString(4,DateHelper.format(emp.getDateDeNaissance()));
				prepInsert.setString(5, emp.getMasterIntitule());
				prepInsert.setInt(6, emp.getSemestreEns());

				prepInsert.executeUpdate();
				
				
			} catch (Exception e){
				e.printStackTrace();
			} finally {
				if(dbConn != null){
					try {
						dbConn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			
			dataEtudiant.add(emp);
		} else {
			
			System.out.println("duplicated pk");
			
		}
		
		
	}
    
}
