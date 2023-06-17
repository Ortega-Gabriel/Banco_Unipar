package com.mycompany.bancounipar.repositories;

import com.mycompany.bancounipar.models.Transacao;
import com.mycompany.bancounipar.utils.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TransacaoDAO {
    
    private static final String INSERT =
            "INSERT INTO TRANSACAO (ID, DATAHORA, VALOR, TIPO, RA, "
            + "CONTA_ORIGEM, CONTA_DESTINO)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    
    private static final String FIND_ALL =
            "SELECT ID, DATAHORA, VALOR, TIPO, RA, "
            + "CONTA_ORIGEM, CONTA_DESTINO FROM TRANSACAO";
    
    private static final String FIND_BY_ID = 
            "SELECT ID, DATAHORA, VALOR, TIPO, RA, "
            + "CONTA_ORIGEM, CONTA_DESTINO FROM TRANSACAO"
            + "WHERE ID = ?";
    
    private static final String DELETE_BY_ID =
            "DELETE * FROM TRANSACAO WHERE ID = ?";
    
    private static final String UPDATE =
            "UPDATE TRANSACAO SET "
            + "ID = ?,"
            + "DATAHORA = ?,"
            + "VALOR = ?,"
            + "TIPO = ?,"
            + "RA = ?,"
            + "CONTA_ORIGEM = ?,"
            + "CONTA_DESTINO = ? "
            + "WHERE ID = ?";
    
    public void insert(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, transacao.getId());
            //pstmt.setDate(2, transacao.getDataHora());
            pstmt.setDouble(3, transacao.getValor());
            pstmt.setInt(4, transacao.getTipo());
            pstmt.setString(5, transacao.getRa());
            pstmt.setInt(6, transacao.getContaOrigem().getId());
            pstmt.setInt(7, transacao.getContaDestino().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
    
    public List<Transacao> findAll() throws SQLException{
        
        List<Transacao> retorno = new ArrayList<Transacao>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                
                Transacao transacao = new Transacao();
                transacao.setId(rs.getInt("ID"));
                //transacao.setDataHora(rs.getDate("DATAHORA"));
                transacao.setValor(rs.getDouble("DIGITO"));
                transacao.setTipo(rs.getInt("TIPO"));
                transacao.setRa(rs.getString("RA"));
                transacao.setContaOrigem(new ContaDAO().findById(rs.getInt(
                        "CONTA_ORIGEM")));
                transacao.setContaDestino(new ContaDAO().findById(rs.getInt(
                        "CONTA_DESTINO")));
                retorno.add(transacao);
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
    
    public Transacao findById(int id) throws SQLException {
        
        Transacao retorno = new Transacao();
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
                //retorno.setDataHora(rs.getDate("DATAHORA"));
                retorno.setValor(rs.getDouble("DIGITO"));
                retorno.setTipo(rs.getInt("TIPO"));
                retorno.setRa(rs.getString("RA"));
                retorno.setContaOrigem(new ContaDAO().findById(rs.getInt(
                        "CONTA_ORIGEM")));
                retorno.setContaDestino(new ContaDAO().findById(rs.getInt(
                        "CONTA_DESTINO")));
                
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
    
    public void update(Transacao transacao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try{
            conn = new DatabaseUtils().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, transacao.getId());
            //pstmt.setDate(2, transacao.getDatahora());
            pstmt.setDouble(3, transacao.getValor());
            pstmt.setInt(4, transacao.getTipo());
            pstmt.setString(5, transacao.getRa());
            pstmt.setInt(7, transacao.getContaOrigem().getId());
            pstmt.setInt(8, transacao.getContaDestino().getId());
            
            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        }
    }
}
