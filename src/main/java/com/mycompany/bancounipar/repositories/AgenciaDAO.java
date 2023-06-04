package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Agencia;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    
    private static final String INSERT =
            "INSERT INTO AGENCIA (CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, "
            + "RA, BANCO_ID)"
            + "VALUES (?, ?, ?, ?, ?, ?);";
    
    private static final String FIND_ALL =
            "SELECT CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, "
            + "RA, BANCO_ID FROM AGENCIA";
    
    private static final String FIND_BY_ID = 
            "SELECT CODIGO, DIGITO, RAZAOSOCIAL, CNPJ, "
            + "RA, BANCO_ID FROM AGENCIA"
            + "WHERE ID = ?";
    
    private static final String DELETE_BY_ID =
            "DELETE * FROM PAIS WHERE ID = ?";
    
    private static final String UPDATE =
            "UPDATE PAIS SET "
            + "CODIGO = ?,"
            + "DIGITO = ?,"
            + "RAZAOSOCIAL = ?"
            + "CNPJ = ?"
            + "RA = ?"
            + "BANCO_ID = ?"
            + "WHERE ID = ?";
    
    public void insert(Agencia agencia) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, agencia.getId());
            
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getDigito());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setString(6, agencia.getRa());
            pstmt.setInt(7, agencia.getBanco().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public List<Agencia> findAll() throws SQLException{
        
        List<Agencia> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                Agencia agencia = new Agencia();
                agencia.setId(rs.getInt("ID"));
                agencia.setCodigo(rs.getString("CODIGO"));
                agencia.setDigito(rs.getString("DIGITO"));
                agencia.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                agencia.setCnpj(rs.getString("CNPJ"));
                agencia.setRa(rs.getString("RA"));
                agencia.setBanco(new BancoDAO().findById(rs.getInt(
                        "BANCO_ID")));
                retorno.add(agencia);
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
    
    public Agencia findById(int id) throws SQLException {
        
        Agencia retorno = new Agencia();
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
                retorno.setCodigo(rs.getString("CODIGO"));
                retorno.setDigito(rs.getString("DIGITO"));
                retorno.setRazaoSocial(rs.getString("RAZAOSOCIAL"));
                retorno.setCnpj(rs.getString("CNPJ"));
                retorno.setRa(rs.getString("RA"));
                retorno.setBanco(new BancoDAO().findById(rs.getInt(
                        "BANCO_ID")));
                
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
    
    public void update(Agencia agencia) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, agencia.getId());
            pstmt.setString(2, agencia.getCodigo());
            pstmt.setString(3, agencia.getDigito());
            pstmt.setString(4, agencia.getRazaoSocial());
            pstmt.setString(5, agencia.getCnpj());
            pstmt.setString(6, agencia.getRa());
            pstmt.setInt(7, agencia.getBanco().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    
}
