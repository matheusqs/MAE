/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manutencaodeturmas.model.controller;

import manutencaodeturmas.model.controller.TelaInicialController;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import manutencaodeturmas.model.ManutencaoDeTurmas;

/**
 * FXML Controller class
 *
 * @author mathe
 */
public class ApagarTurmasController implements Initializable {

    private com.mysql.jdbc.Connection link = null;
    private static ManutencaoDeTurmas main;
    
    @FXML
    private TextField idTurma;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            link = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/educatio", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(link == null)
            System.out.println("Erro!");
        else
            System.out.println("Conexao feita com sucesso!");
            
    } 
    
    @FXML
    public void apagaTurma() throws SQLException, IOException{
        Statement comando = link.createStatement();
        String query = "UPDATE `turmas` SET `ativo` = 'N' WHERE `turmas`.`id` = " + idTurma.getText();
        comando.executeUpdate(query);
        System.out.println("Apaguei a turma.");
        alteraTelaInicial();
    }
    
    @FXML
    public void alteraTelaInicial() throws IOException{
        main.abreTelaInicial();
    }
    public void setMain(ManutencaoDeTurmas main) {
        this.main = main;
    }   
    
}
