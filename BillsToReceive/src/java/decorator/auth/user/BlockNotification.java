/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
public class BlockNotification extends Notification {
    public BlockNotification(INotification notification) {
        super(notification);
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " Conta bloqueada. Por favor, contate o administrador do sistema.";
    }
}