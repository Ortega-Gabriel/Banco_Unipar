package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Pessoa;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    
    public static final String INSERT =
            "INSERT INTO PESSOA (ID, EMAIL, RA)"
            + "VALUES (?, ?, ?)";
    
    public static final String FIND_ALL =
            "SELECT ID, EMAIL, RA, DATACADASTRO FROM PESSOA";
    
    public static final String FIND_BY_ID =
            "SELECT ID, EMAIL, RA, DATACADASTRO FROM PESSOA"
            + "WHERE ID = ?";
    
    public static final String DELETE_BY_ID =
            "DELETE ID, EMAIL, RA, DATACADASTRO FROM PESSOA"
            + "WHERE ID = ?";
    
    public static final String UPDATE =
            "UPDATE PESSOA SET"
            + "ID = ?,"
            + "EMAIL = ?,"
            + "RA = ?"
            + "WHERE ID = ?";
    
    public static void insert(Pessoa pessoa) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getRa());
            
        }finally{
            if(pstmt != null)
                pstmt.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public static List<Pessoa> findAll() throws SQLException {
        
        List<Pessoa> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("ID"));
                pessoa.setEmail(rs.getString("EMAIL"));
                pessoa.setRa(rs.getString("RA"));
                retorno.add(pessoa);
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
    
    public static Pessoa findById(int id) throws SQLException {
        Pessoa retorno = new Pessoa();
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
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setRa(rs.getString("RA"));
                
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
    
    public void update(Pessoa pessoa) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, pessoa.getEmail());
            pstmt.setString(3, pessoa.getRa());
            
        }finally{
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
            
            
            
}
