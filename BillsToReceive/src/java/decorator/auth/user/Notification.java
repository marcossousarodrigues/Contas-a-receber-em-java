/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator.auth.user;

/**
 *
 * @author Marcos
 */
// Abstract Decorator
public abstract class Notification implements INotification {
    protected INotification notification;

    public Notification(INotification notification) {
        this.notification = notification;
    }

    @Override
    public String getMessage() {
        return notification.getMessage();
    }
}