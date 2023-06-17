package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Estado;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EstadoDAO {
    
    private static final String INSERT =
            "INSERT INTO ESTADO (ID, NOME, SIGLA, RA, PAIS_ID) "
            + "VALUES (?, ?, ?, ?, ?);";
    private static final String FIND_ALL =
            "SELECT ID, NOME, SIGLA, RA, PAIS_ID FROM ESTADO;";
    private static final String FIND_BY_ID =
            "SELECT ID, NOME, SIGLA, RA, PAIS_ID FROM ESTADO "
            + "WHERE ID = ?";
    private static final String DELETE_BY_ID = 
            "DELETE FROM ESTADO WHERE ID = ?";
    private static final String UPDATE =
            "UPDATE ESTADO SET NOME = ?,"
            + "SIGLA = ?,"
            + "RA = ?,"
            + "PAIS_ID = ? "
            + "WHERE ID = ?";
    
   public void insert(Estado estado) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(INSERT);
           
           pstmt.setInt(1, estado.getId());
           pstmt.setString(2, estado.getNome());
           pstmt.setString(3, estado.getSigla());
           pstmt.setString(4, estado.getRa());
           pstmt.setInt(5, estado.getPais().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
    
   public List<Estado> findAll() throws SQLException{
       
       List<Estado> retorno = new ArrayList<Estado>();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       
       try{
           while(rs.next()){
              
              Estado estado = new Estado();
              conn = new DatabaseUtils().getConnection();
              pstmt = conn.prepareStatement(FIND_ALL);
              rs = pstmt.executeQuery();
              
              estado.setId(rs.getInt("ID"));
              estado.setNome(rs.getString("NOME"));
              estado.setSigla(rs.getString("SIGLA"));
              estado.setRa(rs.getString("RA"));
              estado.setPais(new PaisDAO().findById(rs.getInt(
                      "PESSOA_ID")));
              retorno.add(estado);
              
           }
       }finally{
           if(rs != null)
               rs.close();
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
       return retorno;
   }
   
   public Estado findById(int id) throws SQLException{
       
       Estado retorno = new Estado();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       try{
           if(rs.next()){
               
               conn = new DatabaseUtils().getConnection();
               pstmt = conn.prepareStatement(FIND_BY_ID);
               pstmt.setInt(1, id);
               rs = pstmt.executeQuery();
               
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setSigla(rs.getString("SIGLA"));
               retorno.setRa(rs.getString("RA"));
               retorno.setPais(new PaisDAO().findById(rs.getInt("PAIS_ID")));
           }
           
       }finally{
           if(rs != null)
               rs.close();
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
       return retorno;
   }
   
   public void deleteById(int id) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(DELETE_BY_ID);
           pstmt.setInt(1, id);
           pstmt.executeUpdate();
           
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
   
   public void update(Estado estado) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(UPDATE);
           
           pstmt.setInt(1, estado.getId());
           pstmt.setString(2, estado.getNome());
           pstmt.setString(3, estado.getSigla());
           pstmt.setString(4, estado.getRa());
           pstmt.setInt(5, estado.getPais().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
}
