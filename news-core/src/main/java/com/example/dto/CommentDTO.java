package com.example.dto;

import java.util.ArrayList;
import java.util.List;

public class CommentDTO extends AbstractDTO<CommentDTO> {

    private static final long serialVersionUID = -2176203490090456213L;

    private String content;
    private long dataLevel;
    private NewDTO news;
    private UserDTO users;
    private int col1;
    private int col2;
    private List<CommentDTO> subComments = new ArrayList<>();
    private long newId;
    private long parentId;

    public long getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(long dataLevel) {
        this.dataLevel = dataLevel;
    }

    public NewDTO getNews() {
        return news;
    }

    public void setNews(NewDTO news) {
        this.news = news;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentDTO> getSubComments() {
        return subComments;
    }

    public void setSubComments(List<CommentDTO> subComments) {
        this.subComments = subComments;
    }

    public long getNewId() {
        return newId;
    }

    public void setNewId(long newId) {
        this.newId = newId;
    }

    public UserDTO getUsers() {
        return users;
    }

    public void setUsers(UserDTO users) {
        this.users = users;
    }
}
