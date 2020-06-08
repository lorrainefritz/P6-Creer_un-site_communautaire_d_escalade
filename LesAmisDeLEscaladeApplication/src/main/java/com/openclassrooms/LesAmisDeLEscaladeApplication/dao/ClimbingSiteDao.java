package com.openclassrooms.LesAmisDeLEscaladeApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.openclassrooms.LesAmisDeLEscaladeApplication.domain.ClimbingSiteItem;

public class ClimbingSiteDao {
	private static String INSERT = "insert into climbingSites(id,title,image,secteur,longueur,nombreDeVoies,difficulty,tagged) values(?,?,?,?,?,?,?,?)";
	private static String SELECT_ONE = "select id,title,image,secteur,longueur,nombreDeVoies,difficulty,tagged from climbingSites where id=?";
	private static String SELECT_ALL="select id,title,image,secteur,longueur,nombreDeVoies,difficulty,tagged";
	public ClimbingSiteItem getClimbingSite(Integer id) throws Exception {
		ClimbingSiteItem climbingSiteItem = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_ONE)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				climbingSiteItem.setTitle(rs.getString("title"));
				climbingSiteItem.setImage(rs.getString("image"));
				climbingSiteItem.setSecteur(rs.getString("secteur"));
				climbingSiteItem.setLongueur(rs.getInt("longueur"));
				climbingSiteItem.setNombreDeVoies(rs.getInt("nombreDeVoies"));
				climbingSiteItem.setDifficulty(rs.getString("difficulty"));
				climbingSiteItem.setTagged(rs.getBoolean("tagged"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Erreur à la lecture du site d'escalade recherché", e);
		}
		return climbingSiteItem;

	}

	public void addClimbingSite(ClimbingSiteItem climbingSiteItem) throws Exception {
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT)) {
			pstmt.setInt(1, climbingSiteItem.getId());
			pstmt.setString(2, climbingSiteItem.getTitle());
			pstmt.setString(3, climbingSiteItem.getImage());
			pstmt.setString(4, climbingSiteItem.getSecteur());
			pstmt.setInt(5, climbingSiteItem.getLongueur());
			pstmt.setInt(6, climbingSiteItem.getNombreDeVoies());
			pstmt.setString(7, climbingSiteItem.getDifficulty());
			pstmt.setBoolean(8, climbingSiteItem.isTagged());
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
			throw new Exception("Erreur à l'enregistrement du site d'escalade", e);
		}
	}

	public List<ClimbingSiteItem> getClimbingSiteList() throws Exception{
		List <ClimbingSiteItem> climbingSiteItems = new ArrayList<>();
		try(
			  Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL))
		{
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ClimbingSiteItem climbingSiteItem = new ClimbingSiteItem();
				climbingSiteItem.setId(rs.getInt("id"));
				climbingSiteItem.setTitle(rs.getString("title"));
				climbingSiteItem.setImage(rs.getString("image"));
				climbingSiteItem.setSecteur(rs.getString("secteur"));
				climbingSiteItem.setLongueur(rs.getInt("longueur"));
				climbingSiteItem.setNombreDeVoies(rs.getInt("nombreDeVoies"));
				climbingSiteItem.setDifficulty(rs.getString("difficulty"));
				climbingSiteItem.setTagged(rs.getBoolean("tagged"));
				climbingSiteItems.add(climbingSiteItem);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new Exception ("Erreur à la lecture de la liste de sites d'escalade",e);
		}
		return climbingSiteItems;
		
	}
	
}
