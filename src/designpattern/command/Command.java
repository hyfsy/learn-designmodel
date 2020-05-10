package designpattern.command;

/**
 * 命令接口
 */
public interface Command {

    /**
     * 执行命令方法
     */
    void execute();

    /**
     * 撤销命令方法
     */
    void undo();

}
