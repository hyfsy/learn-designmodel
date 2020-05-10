package designpattern.other.memento.black;

/**
 * 管理者
 */
public class Caretaker {

    private IMemento memento;

    public IMemento getMemento() {
        return memento;
    }

    public void setMemento(IMemento memento) {
        this.memento = memento;
    }
}
