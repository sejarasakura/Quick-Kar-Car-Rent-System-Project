/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _manipulation;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ITSUKA KOTORI
 */
public class Path_Manipulate {
    
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    private static Path_Manipulate static_path = new Path_Manipulate("GroupProject");
    private String project_dir = "";
    private String project_name;
    
    private  Path_Manipulate(String project_name){
        this.project_name = project_name;
        project_dir = getProjectPath(); 
        if(project_dir.isEmpty()){
            JOptionPane.showConfirmDialog(null, "The project path is load in error please retry or redevelop agian to ensure free of error!!! "
                    + "\n Class: Path_Manipulation\n Error: Empty path directory", "Path load error", JOptionPane.ERROR_MESSAGE);
        }
   }
    
    public static String getAssignmentDirectory(){
        return static_path.project_dir;
    }
    
    public static String getDatabaseDirectory(){
        return static_path.project_dir + "Database_Data/";
    }
    
    public static String getProjectDirectory(){
        return static_path.project_dir +  static_path.project_name +'/';
    }
    
    public static String getWebProjectDirectory(){
        return static_path.project_dir +  static_path.project_name + "/build/web/";
    }
    
    public static String getClassProjectDirectory(){
        return static_path.project_dir + static_path.project_name +  "/build/web/WEB-INF/classes/";
    }
    
    public static String getPageDirectory(){
        return static_path.project_dir + static_path.project_name +  "/build/web/_page/";
    }
    
    public static String getResourceDirectory(){
        return getWebProjectDirectory() +  "_resource/";
    }

    private String getProjectPath(){
        try {
             String data = URLDecoder.decode(this.getClass().getClassLoader().getResource("").getPath(), "UTF-8");
             String[] datas = data.split(project_name);
             return datas[0].substring(1);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Path_Manipulate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    } 
    
    public static void main(String[] args) {
        JOptionPane.showConfirmDialog(null, 
                "<html><body style=\"padding:10px;\"><h1>Path data</h1><ol>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getProjectDirectory(): </p><b>" + Path_Manipulate.getProjectDirectory() + "</b></li><br>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getAssginmentDirectory():</p><b> " + Path_Manipulate.getAssignmentDirectory()+ "</b></li><br>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getClassProjectDirectory(): </p><b>" + Path_Manipulate.getClassProjectDirectory()+ "</b></li><br>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getHTMLPageDirectory(): </p><b>" + Path_Manipulate.getPageDirectory()+ "</b></li><br>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getJSPPageDirectory(): </p><b>" + Path_Manipulate.getPageDirectory()+ "</b></li><br>"
                        + "<li><p style=\"color:red\">Path_Manipulate.getWebProjectDirectory(): </p><b>" + Path_Manipulate.getWebProjectDirectory()+ "</b></li><br>"
                        + "</ol></body><html>", "Path Information", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
    }
    //</editor-fold>
}
