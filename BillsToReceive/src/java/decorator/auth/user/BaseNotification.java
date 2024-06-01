/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
// Base Notification Implementation
public class BaseNotification implements INotification {
    @Override
    public String getMessage() {
        return "Atenção: ";
    }
}
