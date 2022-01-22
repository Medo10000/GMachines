package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Marque;
import beans.user;
import connexion.Connexion;
import dao.IDao;
import dao.IUserDao;

public class UserService implements IUserDao<user>{

	@Override
	public user checkLogin(String email, String password) {
		String sql = "Select from user where email = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	  user userModel = new user(rs.getInt("id"),rs.getString("fullname"), rs.getString("email") ,rs.getString("password"));
            	  if(password == userModel.getPassword()) {
            		  return userModel;
            	  }
            	  else { 
            		  return null;
            	  }
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return null;
	}

}
