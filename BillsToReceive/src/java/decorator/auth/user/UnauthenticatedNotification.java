/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
// Decorator for unauthenticated user
public class UnauthenticatedNotification extends Notification {
    public UnauthenticatedNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Usuário não autenticado! ";
    }
}
