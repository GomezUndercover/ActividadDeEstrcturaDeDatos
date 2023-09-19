/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas.ListasDobles;

/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
         int [] valores = {5, 59, 91, -17, 73, 34, 40};
         ListaDoblementeEnlazada lde = new ListaDoblementeEnlazada();
         
         for (int i = 0; i < valores.length; i++){
             lde.insertar(valores[i]);
         }
         
        lde.eliminar(2);
        lde.eliminar(3);
        
        System.out.println(lde.longitud());
        System.out.println(lde.obtener(4));
    }
}
