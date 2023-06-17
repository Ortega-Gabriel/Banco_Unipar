package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Pais;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PaisDAO {
    
    private static final String INSERT = 
            "INSERT INTO PAIS (ID, NOME, SIGLA, RA) "
            + "VALUES (?, ?, ?,?)";
    
    private static final String FIND_ALL = 
            "SELECT ID, NOME, SIGLA, RA, DATACADASTRO FROM PAIS";
    
    private static final String FIND_BY_ID =
            "SELECT ID, NOME, SIGLA, RA FROM PAIS WHERE ID = ?";
    
    private static final String DELETE_BY_ID =
            "DELETE FROM PAIS WHERE ID = ?";
    
    private static final String UPDATE =
            "UPDATE PAIS SET NOME = ?, "
            + "SIGLA =?, "
            + "RA = ? "
            + "WHERE ID = ?";
    
    public void insert(Pais pais) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, pais.getNome());
            pstmt.setString(2, pais.getSigla());
            pstmt.setString(3, pais.getRa());
            pstmt.setInt(4, pais.getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public List<Pais> findAll() throws SQLException {
       
        List<Pais> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Pais pais = new Pais();
                pais.setId(rs.getInt("ID"));
                pais.setNome(rs.getString("NOME"));
                pais.setSigla(rs.getString("SIGLA"));
                pais.setRa(rs.getString("RA"));
                pais.setDataCadastro(rs.getDate("DATACADASTRO"));
                retorno.add(pais);
            }
        } finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        
        return retorno;
    } 
    
    public Pais findById(int id) throws SQLException {
        
        Pais pais = new Pais();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()){
                pais.setId(rs.getInt("ID"));
                pais.setNome(rs.getString("NOME"));
                pais.setSigla(rs.getString("SIGLA"));
                pais.setRa(rs.getString("RA"));
            }
            
        } finally {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
        return pais;
    }
    
    public void deleteById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public void update(Pais pais) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pais.getNome());
            pstmt.setString(2, pais.getSigla());
            pstmt.setString(3, pais.getRa());
            pstmt.setInt(4, pais.getId());
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
