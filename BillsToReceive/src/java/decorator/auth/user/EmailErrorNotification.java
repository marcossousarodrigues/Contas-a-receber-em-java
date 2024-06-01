/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
public class EmailErrorNotification extends Notification {
    public EmailErrorNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Erro de e-mail. Por favor, tente novamente. ";
    }
}