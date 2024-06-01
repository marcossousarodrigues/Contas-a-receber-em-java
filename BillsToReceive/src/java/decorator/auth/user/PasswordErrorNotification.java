/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
// Decorator for password error
public class PasswordErrorNotification extends Notification {
    public PasswordErrorNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Erro de senha. Por favor, tente novamente. ";
    }
}