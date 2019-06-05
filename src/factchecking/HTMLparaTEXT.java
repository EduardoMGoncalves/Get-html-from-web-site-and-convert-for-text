package factchecking;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class HTMLparaTEXT extends HTMLEditorKit.ParserCallback {
    
    //construtor para ser chamado na interface
    public HTMLparaTEXT(){
        
        try {   
            
            //o HTML para converter
            FileReader in = new FileReader("C:\\Users\\USSenterprise\\Desktop\\Trabalho Final Eng Soft\\TESTE.html");           
            this.parse(in);
            in.close();
            System.out.println(this.getText());
            
             try{
            
            String content = this.getText();
            
            // Cria arquivo
            File file = new File("C:\\Users\\USSenterprise\\Desktop\\Trabalho Final Eng Soft\\ResultadoFinal.txt");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }

            // Prepara para escrever no arquivo
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            // Escreve e fecha arquivo
            bw.write(content);
            bw.close();
        
        } catch (IOException e) {
            
            e.printStackTrace();
        
        }
            
        } catch (IOException ex) {
            
            Logger.getLogger(HTMLparaTEXT.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    
    StringBuffer s;
   
    public void parse(Reader in) throws IOException {
        
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        delegator.parse(in, this, Boolean.TRUE);
        
    }
    public void handleText(char[] text, int pos) {
        
        s.append(text);
        s.append("\n");
        
    }
    public String getText() {
        
        return s.toString();
        
    }
    public void CONVERTER () throws FileNotFoundException, IOException {
        
            //o HTML para converter
            FileReader in = new FileReader("C:\\Users\\USSenterprise\\Desktop\\Trabalho Final Eng Soft\\TESTE.html");
            HTMLparaTEXT parser = new HTMLparaTEXT();
            parser.parse(in);
            in.close();
            System.out.println(parser.getText());
            
    }
}