package design_pattern.creational.builder;

/**
 * 手写 Builder太复杂且不好维护，建议用 lombok
 */
public class Phone {
    private final int length;
    private final int width;
    private final String name;

    private Phone(int length, int width, String name) {
        this.length = length;
        this.width = width;
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void printInfo() {
        System.out.println("name: " + this.name);
        System.out.println("length: " + this.length);
        System.out.println("width: " + this.width);
    }

    /**
     * 静态内部类, 需要是public的
     */
    public static final class Builder {
        private int length;
        private int width;
        private String name;

        private Builder() {
        }

        /**
         * 生成 Phone， 可以加校验
         */
        public Phone build() {
            // 其他校验逻辑
            //
            return new Phone(this.length, this.width, this.name);
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
    }
}

