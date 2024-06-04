/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
public class BlockedPasswordErrorNotification extends Notification{
    public BlockedPasswordErrorNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Bloqueado após errar a senha 3 vezes. Por favor entre em contato com o administrador do sistema. ";
    }
}
