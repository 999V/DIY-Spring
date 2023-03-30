package org.spring.demo.effective.demo2;

import java.util.Objects;

public class User {
    private String id;
    private String name;
    private Integer age;

    User() {

    }

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private String id;
        private String name;
        private Integer age;

        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public User build() {
            Objects.requireNonNull(1);
            return new User(this);
        }
    }
}
