package tk.mybatis.simple.enums;

/**
 * @author peng.li
 * @Description: TODO
 * @date 2020/7/30 10:45
 */
public enum Enabled {

    enabled(1),

    disabled(0);

    private final int value;

    Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
