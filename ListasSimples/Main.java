/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas.ListasSimples;

/**
 *
 * @author ADMIN
 */
public class Main {
    
    
    
    public static void main(String[] args) {
        int [] valores = {5, 59, 91, -17, 73, 34, 40};
        ListaSimplementeEnlazada lse = new ListaSimplementeEnlazada();
        
        for (int i = 0; i < valores.length ; i++){
            lse.insertar(valores[i]);
        }
        
        lse.eliminar(2);
        lse.eliminar(3);
        
        System.out.println(lse.obtener(3));
    }
}
