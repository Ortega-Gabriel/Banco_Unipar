package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Telefone;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefoneDAO {
    private static final String INSERT =
            "INSERT INTO TELEFONE (ID, NUMERO, OPERADORA, RA, "
            + "AGENCIA_ID, PESSOA_ID) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
    private static final String FIND_ALL =
            "SELECT ID, NUMERO, OPERADORA, RA, "
            + "AGENCIA_ID, PESSOA_ID FROM TELEFONE;";
    private static final String FIND_BY_ID =
            "SELECT ID, NUMERO, OPERADORA, RA, "
            + "AGENCIA_ID, PESSOA_ID "
            + "FROM TELEFONE "
            + "WHERE ID = ?";
    private static final String DELETE_BY_ID = 
            "DELETE FROM TELEFONE WHERE ID = ?";
    private static final String UPDATE =
            "UPDATE TELEFONE SET "
            + "ID = ?,"
            + "NUMERO = ?,"
            + "OPERADORA = ?,"
            + "RA = ?,"
            + "AGENCIA_ID = ?,"
            + "PESSOA_ID = ? "
            + "WHERE ID = ?";
    
   public void insert(Telefone telefone) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(INSERT);
           
           pstmt.setInt(1, telefone.getId());
           pstmt.setString(2, telefone.getNumero());
           pstmt.setInt(3, telefone.getOperadora());
           pstmt.setString(4, telefone.getRa());
           pstmt.setInt(5, telefone.getPessoa().getId());
           pstmt.setInt(6, telefone.getAgencia().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
    
   public List<Telefone> findAll() throws SQLException{
       
       List<Telefone> retorno = new ArrayList<Telefone>();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       
       try{
           while(rs.next()){
              
              Telefone telefone = new Telefone();
              conn = new DatabaseUtils().getConnection();
              pstmt = conn.prepareStatement(FIND_ALL);
              rs = pstmt.executeQuery();
              
              telefone.setId(rs.getInt("ID"));
              telefone.setNumero(rs.getString("NUMERO"));
              telefone.setOperadora(rs.getInt("OPERADORA"));
              telefone.setRa(rs.getString("RA"));
              telefone.setPessoa(new PessoaDAO().findById(rs.getInt(
                      "PESSOA_ID")));
              telefone.setAgencia(new AgenciaDAO().findById(rs.getInt(
                      "AGENCIA_ID")));
              retorno.add(telefone);
              
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
   
   public Telefone findById(int id) throws SQLException{
       
       Telefone retorno = new Telefone();
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
               retorno.setNumero(rs.getString("NUMERO"));
               retorno.setOperadora(rs.getInt("OPERADORA"));
               retorno.setRa(rs.getString("RA"));
               retorno.setPessoa(new PessoaDAO().findById(rs.getInt(
                      "PESSOA_ID")));
               retorno.setAgencia(new AgenciaDAO().findById(rs.getInt(
                      "AGENCIA_ID")));
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
   
   public void update(Telefone telefone) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(UPDATE);
           
           pstmt.setInt(1, telefone.getId());
           pstmt.setString(2, telefone.getNumero());
           pstmt.setInt(3, telefone.getOperadora());
           pstmt.setString(4, telefone.getRa());
           pstmt.setInt(5, telefone.getAgencia().getId());
           pstmt.setInt(6, telefone.getPessoa().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
}
