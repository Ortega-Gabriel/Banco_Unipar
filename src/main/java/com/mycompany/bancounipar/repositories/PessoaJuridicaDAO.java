package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.PessoaJuridica;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    private static final String INSERT =
            "INSERT INTO PESSOAJURIDICA (RAZAOSOCIAL, CNPJ, CNAEPRINCIPAL, "
            + "FANTASIA, PESSOA_ID)"
            + "VALUES (?, ?, ?, ?, ?);";
    private static final String FIND_ALL =
            "SELECT RAZAOSOCIAL, CNPJ, CNAEPRINCIPAL, "
            + "FANTASIA, PESSOA_ID FROM PESSOAJURIDICA;";
    private static final String FIND_BY_ID =
            "SELECT RAZAOSOCIAL, CNPJ, CNAEPRINCIPAL, "
            + "FANTASIA, PESSOA_ID FROM PESSOAJURIDICA"
            + "WHERE ID = ?";
    private static final String DELETE_BY_ID = 
            "DELETE FROM PESSOAJURIDICA WHERE ID = ?";
    private static final String UPDATE =
            "UPDATE PESSOAJURIDICA SET "
            + "RAZAOSOCIAL = ?,"
            + "CNPJ = ?,"
            + "CNAEPRINCIPAL = ?,"
            + "FANTASIA = ?,"
            + "PESSOA_ID = ?"
            + "WHERE ID = ?";
    
   public void insert(PessoaJuridica pessoaJuridica) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(INSERT);
           
           pstmt.setString(1, pessoaJuridica.getRazaoSocial());
           pstmt.setString(2, pessoaJuridica.getCnpj());
           pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
           pstmt.setString(4, pessoaJuridica.getFantasia());
           pstmt.setInt(5, pessoaJuridica.getPessoa().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
    
   public List<PessoaJuridica> findAll() throws SQLException{
       
       List<PessoaJuridica> retorno = new ArrayList<PessoaJuridica>();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       
       try{
           while(rs.next()){
              
              PessoaJuridica pessoaJuridica = new PessoaJuridica();
              conn = new DatabaseUtils().getConnection();
              pstmt = conn.prepareStatement(FIND_ALL);
              rs = pstmt.executeQuery();
              
              pessoaJuridica.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
              pessoaJuridica.setCnpj(rs.getString("CNPJ"));
              pessoaJuridica.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
              pessoaJuridica.setFantasia(rs.getString("FANTASIA"));
              pessoaJuridica.setPessoa(new PessoaDAO().findById(rs.getInt(
                      "PESSOA_ID")));
              retorno.add(pessoaJuridica);
              
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
   
   public PessoaJuridica findById(int id) throws SQLException{
       
       PessoaJuridica retorno = new PessoaJuridica();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       try{
           if(rs.next()){
               
               conn = new DatabaseUtils().getConnection();
               pstmt = conn.prepareStatement(FIND_BY_ID);
               pstmt.setInt(1, id);
               rs = pstmt.executeQuery();
               
               retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
               retorno.setCnpj(rs.getString("CNPJ"));
               retorno.setCnaePrincipal(rs.getString("CNAEPRINCIPAL"));
               retorno.setFantasia(rs.getString("FANTASIA"));
               retorno.setPessoa(new PessoaDAO().findById(rs.getInt(
                       "PESSOA_ID")));
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
   
   public void update(PessoaJuridica pessoaJuridica) throws SQLException{
       
       Connection conn = null;
       PreparedStatement pstmt = null;
       
       try{
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(UPDATE);
           
           pstmt.setString(1, pessoaJuridica.getRazaoSocial());
           pstmt.setString(2, pessoaJuridica.getCnpj());
           pstmt.setString(3, pessoaJuridica.getCnaePrincipal());
           pstmt.setString(4, pessoaJuridica.getFantasia());
           pstmt.setInt(5, pessoaJuridica.getPessoa().getId());
           
           pstmt.executeUpdate();
           
       }finally{
           if(pstmt != null)
               pstmt.close();
           if(conn != null)
               conn.close();
       }
   }
}
