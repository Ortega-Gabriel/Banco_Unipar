package com.mycompany.bancounipar;

import com.mycompany.bancounipar.models.Agencia;
import com.mycompany.bancounipar.repositories.BancoDAO;
import com.mycompany.bancounipar.services.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        int selOper = 1;
        
        do{
            selOper = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Escolha uma Opção para Consultar, Consultar Todos, "
                            + "Deletar ou Alterar: \n"
                            + "1 - Agência \n"
                            + "2 - Banco \n"
                            + "3 - Conta \n"
                            + "4 - Cidade \n"
                            + "5 - Estado \n"
                            + "6 - Pais \n"
                            + "7 - Endereco \n"
                            + "8 - Pessoa \n"
                            + "9 - Pessoa Física \n"
                            + "10 - Pessoa Juridica \n"
                            + "11 - Telefone \n"
                            + "12 - Transacao \n"
                            + "0 - Cancelar Operação \n"));
            
            switch(selOper){
                case 1:
                    AgenciaService agServ = new AgenciaService();
                    switch(opcManipulacao()){
                        case 1:
                           Agencia agNova = new Agencia();
                           String agCod = JOptionPane.showInputDialog(null, 
                                           "Informe o Código da Agência:");
                           String agDigito = JOptionPane.showInputDialog(null,
                                   "Informe o Digito da Agência: ");
                           String agRazao = JOptionPane.showInputDialog(null,
                                   "Informe a Razão Social da Agência: ");
                           String agCnpj = JOptionPane.showInputDialog(null,
                                   "Informe o CNPJ da Agência: ");
                           int idBanco = Integer.parseInt(
                                   JOptionPane.showInputDialog(null,
                                           "Informe a ID do Banco: "));
                           agNova.setCodigo(agCod);
                           agNova.setDigito(agDigito);
                           agNova.setRazaoSocial(agRazao);
                           agNova.setCnpj(agCnpj);
                           agNova.setBanco(new BancoService().findById(idBanco));
                           
                           
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Selecionada "
                            + "Inválida");
            }
        }while(selOper != 0);
    }
     public static int opcManipulacao(){
            int opcMani = Integer.parseInt(JOptionPane.showInputDialog(null, 
                    "Selecione o que deseja realizar: \n"
                            + "1 - Adicionar Dados \n"
                            + "2 - Excluir Cadastro \n"
                            + "3 - Atualizar Cadastro \n"
                            + "4 - Consultar \n"
                            + "5 - Consultar Todos os Registros"));
            return opcMani;
        }
}
