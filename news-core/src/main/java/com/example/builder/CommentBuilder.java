package com.example.builder;

public class CommentBuilder {
    private int col1;
    private int col2;
    private long parentId;
    private long dataLevel;

    public int getCol1() {
        return col1;
    }

    public int getCol2() {
        return col2;
    }

    public long getParentId() {
        return parentId;
    }

    public long getDataLevel() {
        return dataLevel;
    }

    public CommentBuilder(Builder builder) {
        this.parentId = builder.parentId;
        this.col2 = builder.col2;
        this.col1 = builder.col1;
        this.dataLevel =  builder.dataLevel;
    }

    public static class Builder {
        private int col1;
        private int col2;
        private long parentId;
        private long dataLevel;

        public Builder setCol1(int col1) {
            this.col1 = col1;
            return this;
        }

        public Builder setCol2(int col2) {
            this.col2 = col2;
            return this;
        }

        public Builder setParentId(long parentId) {
            this.parentId = parentId;
            return this;
        }

        public Builder setDataLevel(long dataLevel) {
            this.dataLevel = dataLevel;
            return this;
        }

        public CommentBuilder build() {
            return new CommentBuilder(this);
        }
    }
}
