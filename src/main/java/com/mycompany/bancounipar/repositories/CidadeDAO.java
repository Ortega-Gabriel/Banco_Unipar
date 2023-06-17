package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Cidade;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CidadeDAO {
    
    private static final String INSERT =
            "INSERT INTO CIDADE (NOME, RA, ESTADO_ID, DATACADASTRO) "
            + "VALUES (?, ?, ? ,?)";
    private static final String FIND_ALL =
            "SELECT ID, NOME, RA, ESTADO_ID, DATACADASTRO "
            + "FROM CIDADE";
    private static final String FIND_BY_ID =
            "SELECT ID, NOME, RA, ESTADO_ID, DATACADASTRO "
            + "FROM CIDADE WHERE ID = ?";
    private static final String DELETE_BY_ID = 
            "DELETE ID, NOME, RA, ESTADO_ID, DATACADASTRO "
            + "FROM CIDADE WHERE ID = ?";
    private static final String UPDATE =
            "UPDATE CIDADE SET "
            + "ID = ?,"
            + "NOME = ?,"
            + "RA = ?,"
            + "ESTADO_ID = ?"
            + "DATACADASTRO = ?";
    
    public void insert(Cidade cidade) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());
            
            pstmt.executeUpdate();
            
        } finally{
            
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
            
        }
    }
    
    public List<Cidade> findAll() throws SQLException{
        
        List<Cidade> retorno = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("ID"));
                cidade.setNome(rs.getString("NOME"));
                cidade.setRa(rs.getString("RA"));
                cidade.setEstado(new EstadoDAO().findById(rs.getInt(
                        "ESTADO_ID")));
                retorno.add(cidade);
            }
        }finally{
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
     return retorno;    
    }
    
    public Cidade findById(int id) throws SQLException{
       
       Cidade retorno = new Cidade();
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       
       try{
           
           conn = new DatabaseUtils().getConnection();
           pstmt = conn.prepareStatement(FIND_BY_ID);
           pstmt.setInt(1, id);
           rs = pstmt.executeQuery();
           
           if (rs.next()){
               
               retorno.setId(rs.getInt("ID"));
               retorno.setNome(rs.getString("NOME"));
               retorno.setRa(rs.getString("RA"));
               retorno.setEstado(new EstadoDAO().findById(rs.getInt(
                       "ESTADO_ID")));
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
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public void update(Cidade cidade) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, cidade.getId());
            pstmt.setString(2, cidade.getNome());
            pstmt.setString(3, cidade.getRa());
            pstmt.setInt(4, cidade.getEstado().getId());
            
        } finally {
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
    
}
