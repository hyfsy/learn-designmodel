package designpattern.adapter.clazz;

/**
 * 实现[旧的接口]并继承[新的接口实现类]
 */
public class newModAdapter extends newModImpl implements Mod {

    @Override
    public void mod() {
        super.newMod();
    }

}
