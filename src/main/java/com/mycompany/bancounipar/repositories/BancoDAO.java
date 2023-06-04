package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Banco;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BancoDAO {
    
    
    public static final String INSERT =
            "INSERT INTO BANCO (ID, NOME, RA)"
            + "VALUES (?, ?, ?)";
    
    public static final String FIND_ALL =
            "SELECT ID, NOME, RA, DATACADASTRO";
    
    public static final String FIND_BY_ID =
            "SELECT ID, NOME, RA, DATACADASTRO FROM PAIS"
            + "WHERE ID = ?";
    
    public static final String DELETE_BY_ID =
            "DELETE FROM PAIS WHERE ID = ?";
    
    public static final String UPDATE =
            "UPDATE PAIS SET"
            + "ID = ?,"
            + "NOME = ?,"
            + "RA = ?"
            + "WHERE ID = ?";
    
    public void insert(Banco banco) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());
            pstmt.setString(3, banco.getRa());
            
            pstmt.executeUpdate();
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public List<Banco> findAll() throws SQLException{
        
        List<Banco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Banco banco = new Banco();
                banco.setId(rs.getInt("ID"));
                banco.setNome(rs.getString("NOME"));
                banco.setRa(rs.getString("RA"));
                retorno.add(banco);
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
    
    public Banco findById(int id) throws SQLException{
        
        Banco retorno = new Banco();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setRa(rs.getString("RA")); 
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
    
    public void update(Banco banco) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, banco.getId());
            pstmt.setString(2, banco.getNome());;
            pstmt.setString(3, banco.getRa());
            
            pstmt.executeUpdate();
            
        }finally{
            if(conn != null)
                conn.close();
            if(pstmt != null)
                pstmt.close();
        }
    }
}
